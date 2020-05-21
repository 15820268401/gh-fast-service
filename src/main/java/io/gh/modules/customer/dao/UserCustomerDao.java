package io.gh.modules.customer.dao;

import io.gh.modules.customer.entity.UserCustomerEntity;
import io.gh.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCustomerDao extends BaseDao<UserCustomerEntity> {
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