package io.gh.modules.customer.controller;

import io.gh.common.annotation.SysLog;
import io.gh.common.exception.RRException;
import io.gh.common.utils.PageUtils;
import io.gh.common.utils.Query;
import io.gh.common.utils.R;
import io.gh.common.validator.ValidatorUtils;
import io.gh.common.validator.group.AddGroup;
import io.gh.common.validator.group.UpdateGroup;
import io.gh.modules.customer.entity.Customer4ParentSysEntity;
import io.gh.modules.customer.entity.CustomerEntity;
import io.gh.modules.customer.entity.UserCustomerEntity;
import io.gh.modules.customer.service.Customer4ParentSysService;
import io.gh.modules.customer.service.CustomerService;
import io.gh.modules.customer.service.UserCustomerService;
import io.gh.modules.sys.controller.AbstractController;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 客户信息管理类
 */
@RestController
@RequestMapping("/customer/user")
public class CustomerController extends AbstractController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private Customer4ParentSysService customer4ParentSysService;

    @Autowired
    private UserCustomerService userCustomerService;

    /**
     * 所有客户列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("customer:user:list")
    public R list(@RequestParam Map<String, Object> params) {
        //通过user_id查询出customer_id s
        UserCustomerEntity uc = new UserCustomerEntity();
        uc.setUserId(getUserId());
        List<UserCustomerEntity> userCustomerEntities = userCustomerService.selectByEntity(uc);
        Long[] customerIds = new Long[userCustomerEntities != null ? userCustomerEntities.size() : 1];
        int index = 0;
        for (UserCustomerEntity c : userCustomerEntities) {
            customerIds[index] = c.getCustomerId();
            index++;
        }

        //查询列表数据
        Query query = new Query(params);
        query.put("customerIds", customerIds);
        List<CustomerEntity> userList = customerService.queryList(query);
        int total = customerService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 客户信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("customer:user:info")
    public R info(@PathVariable("userId") Long userId) {
        if (StringUtils.isBlank(userId + "")) {
            throw new RRException("用户ID不能为空！");
        }
        CustomerEntity customerEntity = customerService.selectByPrimaryKey(userId);

        return R.ok().put("customer", customerEntity);
    }

    /**
     * 保存客户信息
     * 插入子系统 同时插入母系统
     */
    @SysLog("保存客户信息")
    @RequestMapping("/save")
    @RequiresPermissions("customer:user:save")
    public R save(@RequestBody CustomerEntity customer) throws Exception {
        ValidatorUtils.validateEntity(customer, AddGroup.class);

        customer.setCreaterTime(new Date());
        customer.setUpdateTime(new Date());
        int insertSelective = customerService.insertSelective(customer);

        if (insertSelective > 0) {//插入子系统成功
            //组装数据插入母系统
            Customer4ParentSysEntity customer4ParentSysEntity = new Customer4ParentSysEntity();
            BeanUtils.copyProperties(customer, customer4ParentSysEntity);
            customer4ParentSysEntity.setChildSysCustomerId(customer.getId());
            int i = customer4ParentSysService.insertSelective(customer4ParentSysEntity);
        }

        //插入权限表
        UserCustomerEntity uc = new UserCustomerEntity();
        uc.setUserId(getUserId());
        uc.setCustomerId(customer.getId());
        int i = userCustomerService.insertSelective(uc);

        return insertSelective > 0 ? R.ok() : R.ok().put("code", -1).put("msg", "保存失败！");
    }

    /**
     * 修改客户信息
     */
    @SysLog("修改客户信息")
    @RequestMapping("/update")
    @RequiresPermissions("customer:user:update")
    public R update(@RequestBody CustomerEntity customer) throws Exception {
        ValidatorUtils.validateEntity(customer, UpdateGroup.class);

        customer.setUpdateTime(new Date());
        int updateByPrimaryKeySelective = customerService.updateByPrimaryKeySelective(customer);

        List<Customer4ParentSysEntity> customer4ParentSysEntityList = customer4ParentSysService.selectByForeignKey(customer.getId());

        //判断母系统中是否存在该数据，存在--更新     不存在--插入
        if (customer4ParentSysEntityList != null && !customer4ParentSysEntityList.isEmpty()) {
            Customer4ParentSysEntity customer4ParentSysEntity = customer4ParentSysEntityList.get(0);
            BeanUtils.copyProperties(customer, customer4ParentSysEntity);
            int i = customer4ParentSysService.updateByForeignKeySelective(customer4ParentSysEntity);
        } else {
            Customer4ParentSysEntity customer4ParentSysEntity = new Customer4ParentSysEntity();
            BeanUtils.copyProperties(customer, customer4ParentSysEntity);
            customer4ParentSysEntity.setChildSysCustomerId(customer.getId());
            int i = customer4ParentSysService.insertSelective(customer4ParentSysEntity);
        }

        return updateByPrimaryKeySelective > 0 ? R.ok() : R.ok().put("code", -1).put("msg", "修改失败！");
    }

    /**
     * 上传数据
     */
    @SysLog("上传客户信息")
    @RequestMapping("/uploadData")
    @RequiresPermissions("customer:user:uploadData")
    public R uploadData(@RequestBody Long[] customerIds) throws Exception {
        if (customerIds == null || customerIds.length < 1) {
            throw new RRException("上传的数据不能为空！");
        }

        //1. 查询出需要上传的数据
        List<CustomerEntity> customerEntityList = customerService.selectByIds(customerIds);
        if (customerEntityList == null || customerEntityList.isEmpty()) {
            throw new RRException("上传数据为空！");
        }

        //需要更新到母系统中的数据
        List<Customer4ParentSysEntity> customer4ParentSysEntityList = new ArrayList<>();
        Customer4ParentSysEntity customer4ParentSysEntity;

        for (CustomerEntity ce : customerEntityList) {
            ce.setDel(false);
            ce.setUpdateTime(new Date());
            ce.setUploadTime(new Date());
            ce.setUploadUser(getUser().getAliasname());

            customer4ParentSysEntity = new Customer4ParentSysEntity();
            BeanUtils.copyProperties(ce, customer4ParentSysEntity);
            customer4ParentSysEntity.setChildSysCustomerId(ce.getId());
            customer4ParentSysEntityList.add(customer4ParentSysEntity);
        }

        //2. 修改子系统中数据的 del=false(即上传完不删除),update_time = new Date(),upload_time=new Date(),upload_user = getUserId()
        int i = customerService.updateBatchByPrimaryKeySelective(customerEntityList);
        if (i > 0) {
            //2.1 将数据更新到母系统tb_customer表中
            int updateBatchByForeignKeySelective = customer4ParentSysService.updateBatchByForeignKeySelective(customer4ParentSysEntityList);
            if (updateBatchByForeignKeySelective < 1) {
                throw new RRException("上传失败！");
            }
        }

        return R.ok();
    }

    /**
     * 删除客户信息
     */
    @SysLog("删除客户信息")
    @RequestMapping("/delete")
    @RequiresPermissions("customer:user:delete")
    public R delete(@RequestBody Long[] customerIds) {
        customerService.deleteBatch(customerIds);
        if (customerIds != null && customerIds.length > 0) {
            List<UserCustomerEntity> ucList = new ArrayList<>();
            Long userId = getUserId();
            UserCustomerEntity uc;
            for (Long customerId : customerIds) {
                uc = new UserCustomerEntity();
                uc.setUserId(userId);
                uc.setCustomerId(customerId);
                ucList.add(uc);
            }
            int deleteBatchByEntitys = userCustomerService.deleteBatchByEntitys(ucList);
            logger.info("删除客户信息后同时删除权限表中的权限：{}", deleteBatchByEntitys > 0 ? "成功" : "失败");
        }

        return R.ok();
    }
}
