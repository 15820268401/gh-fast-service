package io.gh.modules.customer.service;

import io.gh.modules.customer.entity.CustomerEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CustomerService {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerEntity record);

    int insertSelective(CustomerEntity record);

    CustomerEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerEntity record);

    int updateByPrimaryKey(CustomerEntity record);

    /**
     * 查询客户列表
     */
    List<CustomerEntity> queryList(Map<String, Object> map);

    /**
     * 查询总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 删除客户
     */
    void deleteBatch(Long[] customerIds);

    /**
     * 批量添加数据
     *
     * @param list
     * @return
     */
    int insertBatch(List<CustomerEntity> list);

    List<CustomerEntity> selectByIds(Long[] ids);

    /**
     * 批量更新下发数据的下发时间和下发人
     *
     * @param customerEntityList
     * @return
     */
    int updateBatchByPrimaryKeySelective(List<CustomerEntity> customerEntityList);

    List<CustomerEntity> selectByGTUpdateTime(Date updateTime);
}
