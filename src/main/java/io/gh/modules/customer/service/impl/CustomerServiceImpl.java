package io.gh.modules.customer.service.impl;

import io.gh.datasources.DataSourceNames;
import io.gh.datasources.annotation.DataSource;
import io.gh.modules.customer.dao.CustomerDao;
import io.gh.modules.customer.entity.CustomerEntity;
import io.gh.modules.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("customerService")
@DataSource(name = DataSourceNames.FIRST)
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int deleteByPrimaryKey(Long id) {
        return customerDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int insert(CustomerEntity record) {
        return customerDao.insert(record);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int insertSelective(CustomerEntity record) {
        return customerDao.insertSelective(record);
    }

    @Override
    public CustomerEntity selectByPrimaryKey(Long id) {
        return customerDao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int updateByPrimaryKeySelective(CustomerEntity record) {
        return customerDao.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int updateByPrimaryKey(CustomerEntity record) {
        return customerDao.updateByPrimaryKey(record);
    }

    @Override
    public List<CustomerEntity> queryList(Map<String, Object> map) {
        return customerDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return customerDao.queryTotal(map);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public void deleteBatch(Long[] customerIds) {
        customerDao.deleteBatch(customerIds);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int insertBatch(List<CustomerEntity> list) {
        return customerDao.insertBatch(list);
    }

    @Override
    public List<CustomerEntity> selectByIds(Long[] ids) {
        return customerDao.selectByIds(ids);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int updateBatchByPrimaryKeySelective(List<CustomerEntity> customerEntityList) {
        return customerDao.updateBatchByPrimaryKeySelective(customerEntityList);
    }

    @Override
    public List<CustomerEntity> selectByGTUpdateTime(Date updateTime) {
        return customerDao.selectByGTUpdateTime(updateTime);
    }

}
