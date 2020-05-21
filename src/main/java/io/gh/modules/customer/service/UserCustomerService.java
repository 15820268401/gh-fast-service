package io.gh.modules.customer.service;

import io.gh.modules.customer.entity.UserCustomerEntity;

import java.util.List;

public interface UserCustomerService {
    int deleteByPrimaryKey(Long id);

    int insert(UserCustomerEntity record);

    int insertSelective(UserCustomerEntity record);

    UserCustomerEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserCustomerEntity record);

    int updateByPrimaryKey(UserCustomerEntity record);

    int insertBatch(List<UserCustomerEntity> list);

    int deleteBatchByCustomerIds(Long[] ids);

    int deleteBatchByEntitys(List<UserCustomerEntity> list);

    List<UserCustomerEntity> selectByEntity(UserCustomerEntity uc);
}