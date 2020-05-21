package io.gh.modules.customer.service.impl;

import io.gh.datasources.DataSourceNames;
import io.gh.datasources.annotation.DataSource;
import io.gh.modules.customer.dao.Customer4ParentSysDao;
import io.gh.modules.customer.entity.Customer4ParentSysEntity;
import io.gh.modules.customer.service.Customer4ParentSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("customer4ParentSysService")
@DataSource(name = DataSourceNames.SECOND)
public class Customer4ParentSysServiceImpl implements Customer4ParentSysService {
    @Autowired
    private Customer4ParentSysDao customer4ParentSysDao;

    @Override
    @Transactional(DataSourceNames.SECOND)
    public int deleteByPrimaryKey(Long id) {
        return customer4ParentSysDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(DataSourceNames.SECOND)
    public int insert(Customer4ParentSysEntity record) {
        return customer4ParentSysDao.insert(record);
    }

    @Override
    @Transactional(DataSourceNames.SECOND)
    public int insertSelective(Customer4ParentSysEntity record) {
        return customer4ParentSysDao.insertSelective(record);
    }

    @Override
    public Customer4ParentSysEntity selectByPrimaryKey(Long id) {
        return customer4ParentSysDao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(DataSourceNames.SECOND)
    public int updateByPrimaryKeySelective(Customer4ParentSysEntity record) {
        return customer4ParentSysDao.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(DataSourceNames.SECOND)
    public int updateByPrimaryKey(Customer4ParentSysEntity record) {
        return customer4ParentSysDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Customer4ParentSysEntity> queryList(Map<String, Object> map) {
        return customer4ParentSysDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return customer4ParentSysDao.queryTotal(map);
    }

    @Override
    @Transactional(DataSourceNames.SECOND)
    public void deleteBatch(Long[] customerIds) {
        customer4ParentSysDao.deleteBatch(customerIds);
    }

    @Override
    @Transactional(DataSourceNames.SECOND)
    public int insertBatch(List<Customer4ParentSysEntity> list) {
        return customer4ParentSysDao.insertBatch(list);
    }

    @Override
    public List<Customer4ParentSysEntity> selectByIds(Long[] ids) {
        return customer4ParentSysDao.selectByIds(ids);
    }

    @Override
    public List<Customer4ParentSysEntity> selectByForeignKey(Long childSysCustomerId) {
        return customer4ParentSysDao.selectByForeignKey(childSysCustomerId);
    }

    @Override
    @Transactional(DataSourceNames.SECOND)
    public int updateBatchByPrimaryKeySelective(List<Customer4ParentSysEntity> Customer4ParentSysEntityList) {
        return customer4ParentSysDao.updateBatchByPrimaryKeySelective(Customer4ParentSysEntityList);
    }

    @Override
    @Transactional(DataSourceNames.SECOND)
    public int updateBatchByForeignKeySelective(List<Customer4ParentSysEntity> Customer4ParentSysEntityList) {
        return customer4ParentSysDao.updateBatchByForeignKeySelective(Customer4ParentSysEntityList);
    }

    @Override
    public int updateByForeignKeySelective(Customer4ParentSysEntity customer4ParentSysEntity) {
        return customer4ParentSysDao.updateByForeignKeySelective(customer4ParentSysEntity);
    }

    @Override
    public List<Customer4ParentSysEntity> selectByGTUpdateTime(Date updateTime) {
        return customer4ParentSysDao.selectByGTUpdateTime(updateTime);
    }
}
