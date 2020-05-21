package io.gh.modules.customer.dao;

import io.gh.modules.customer.entity.CustomerEntity;
import io.gh.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CustomerDao extends BaseDao<CustomerEntity> {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerEntity record);

    int insertSelective(CustomerEntity record);

    CustomerEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerEntity record);

    int updateByPrimaryKey(CustomerEntity record);

    int insertBatch(List<CustomerEntity> list);


    List<CustomerEntity> selectByIds(Long[] ids);

    List<CustomerEntity> selectByGTUpdateTime(@Param("ut") Date updateTime);

    int updateBatchByPrimaryKeySelective(List<CustomerEntity> list);


}