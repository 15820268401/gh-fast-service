package io.gh.modules.sys.service.impl;

import com.google.gson.Gson;
import io.gh.common.exception.RRException;
import io.gh.datasources.DataSourceNames;
import io.gh.modules.sys.dao.SysConfigDao;
import io.gh.modules.sys.entity.SysConfigEntity;
import io.gh.modules.sys.redis.SysConfigRedis;
import io.gh.modules.sys.service.SysConfigService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {
    @Autowired
    private SysConfigDao sysConfigDao;
    @Autowired
    private SysConfigRedis sysConfigRedis;

    @Override
    @Transactional(transactionManager = DataSourceNames.FIRST)
    public void save(SysConfigEntity config) {
        sysConfigDao.save(config);
        sysConfigRedis.saveOrUpdate(config);
    }

    @Override
    @Transactional(transactionManager = DataSourceNames.FIRST)
    public void update(SysConfigEntity config) {
        sysConfigDao.update(config);
        sysConfigRedis.saveOrUpdate(config);
    }

    @Override
    @Transactional(transactionManager = DataSourceNames.FIRST)
    public void updateValueByKey(String key, String value) {
        sysConfigDao.updateValueByKey(key, value);
        sysConfigRedis.delete(key);
    }

    @Override
    @Transactional
    public void deleteBatch(Long[] ids) {
        for (Long id : ids) {
            SysConfigEntity config = queryObject(id);
            sysConfigRedis.delete(config.getKey());
        }

        sysConfigDao.deleteBatch(ids);
    }

    @Override
    public List<SysConfigEntity> queryList(Map<String, Object> map) {
        return sysConfigDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysConfigDao.queryTotal(map);
    }

    @Override
    public SysConfigEntity queryObject(Long id) {
        return sysConfigDao.queryObject(id);
    }

    @Override
    public String getValue(String key) {
        SysConfigEntity config = sysConfigRedis.get(key);
        if (config == null) {
            config = sysConfigDao.queryByKey(key);
            sysConfigRedis.saveOrUpdate(config);
        }

        return config == null ? null : config.getValue();
    }

    @Override
    public <T> T getConfigObject(String key, Class<T> clazz) {
        String value = getValue(key);
        if (StringUtils.isNotBlank(value)) {
            return new Gson().fromJson(value, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RRException("获取参数失败");
        }
    }
}