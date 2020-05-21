package io.gh.modules.customer.service.impl;

import io.gh.datasources.DataSourceNames;
import io.gh.datasources.annotation.DataSource;
import io.gh.modules.customer.dao.UserCustomerDao;
import io.gh.modules.customer.entity.UserCustomerEntity;
import io.gh.modules.customer.service.UserCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userCustomerService")
@DataSource(name = DataSourceNames.FIRST)
public class UserCustomerServiceImpl implements UserCustomerService {
    @Autowired
    private UserCustomerDao userCustomerDao;

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int deleteByPrimaryKey(Long id) {
        return userCustomerDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int insert(UserCustomerEntity record) {
        return userCustomerDao.insert(record);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int insertSelective(UserCustomerEntity record) {
        return userCustomerDao.insertSelective(record);
    }

    @Override
    public UserCustomerEntity selectByPrimaryKey(Long id) {
        return userCustomerDao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int updateByPrimaryKeySelective(UserCustomerEntity record) {
        return userCustomerDao.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int updateByPrimaryKey(UserCustomerEntity record) {
        return userCustomerDao.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int insertBatch(List<UserCustomerEntity> list) {
        return userCustomerDao.insertBatch(list);
    }

    @Override
    @Transactional(DataSourceNames.FIRST)
    public int deleteBatchByCustomerIds(Long[] ids) {
        return userCustomerDao.deleteBatchByCustomerIds(ids);
    }

    @Override
    public int deleteBatchByEntitys(List<UserCustomerEntity> list) {
        return userCustomerDao.deleteBatchByEntitys(list);
    }

    @Override
    public List<UserCustomerEntity> selectByEntity(UserCustomerEntity uc) {
        return userCustomerDao.selectByEntity(uc);
    }
}