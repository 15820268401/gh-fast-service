package io.gh.modules.customer.dao;

import io.gh.modules.customer.entity.Customer4ParentSysEntity;
import io.gh.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface Customer4ParentSysDao extends BaseDao<Customer4ParentSysEntity> {
    int deleteByPrimaryKey(Long id);

    int insert(Customer4ParentSysEntity record);

    int insertSelective(Customer4ParentSysEntity record);

    Customer4ParentSysEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Customer4ParentSysEntity record);

    int updateByPrimaryKey(Customer4ParentSysEntity record);

    int insertBatch(List<Customer4ParentSysEntity> list);


    List<Customer4ParentSysEntity> selectByIds(Long[] ids);

    List<Customer4ParentSysEntity> selectByForeignKey(Long childSysCustomerId);

    List<Customer4ParentSysEntity> selectByGTUpdateTime(@Param("ut") Date updateTime);

    int updateBatchByPrimaryKeySelective(List<Customer4ParentSysEntity> list);

    int updateByForeignKeySelective(Customer4ParentSysEntity customer4ParentSysEntity);

    int updateBatchByForeignKeySelective(List<Customer4ParentSysEntity> list);


}