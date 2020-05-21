package io.gh.modules.customer.service;

import io.gh.modules.customer.entity.Customer4ParentSysEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Customer4ParentSysService {
    int deleteByPrimaryKey(Long id);

    int insert(Customer4ParentSysEntity record);

    int insertSelective(Customer4ParentSysEntity record);

    Customer4ParentSysEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Customer4ParentSysEntity record);

    int updateByPrimaryKey(Customer4ParentSysEntity record);

    /**
     * 查询客户列表
     */
    List<Customer4ParentSysEntity> queryList(Map<String, Object> map);

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
    int insertBatch(List<Customer4ParentSysEntity> list);

    List<Customer4ParentSysEntity> selectByIds(Long[] ids);

    List<Customer4ParentSysEntity> selectByForeignKey(Long childSysCustomerId);

    /**
     * 批量更新下发数据的下发时间和下发人
     *
     * @param Customer4ParentSysEntityList
     * @return
     */
    int updateBatchByPrimaryKeySelective(List<Customer4ParentSysEntity> Customer4ParentSysEntityList);

    int updateBatchByForeignKeySelective(List<Customer4ParentSysEntity> Customer4ParentSysEntityList);

    int updateByForeignKeySelective(Customer4ParentSysEntity customer4ParentSysEntity);

    List<Customer4ParentSysEntity> selectByGTUpdateTime(Date updateTime);
}
