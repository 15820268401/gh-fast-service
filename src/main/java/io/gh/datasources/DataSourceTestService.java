package io.gh.datasources;

import io.gh.datasources.annotation.DataSource;
import io.gh.modules.app.entity.UserEntity;
import io.gh.modules.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试
 * @author gh
 * @email
 * @date 2017/9/16 23:10
 */
@Service
public class DataSourceTestService {
    @Autowired
    private UserService userService;

    public UserEntity queryObject(Long userId){
        return userService.queryObject(userId);
    }

    @DataSource(name = DataSourceNames.SECOND)
    public UserEntity queryObject2(Long userId){
        return userService.queryObject(userId);
    }
}
