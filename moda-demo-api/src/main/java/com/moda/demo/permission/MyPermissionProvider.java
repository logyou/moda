package com.moda.demo.permission;

import com.moda.entity.session.CurrentUser;
import com.moda.redis.spring.boot.autoconfigure.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现权限提供接口
 * 返回权限
 *
 * @author lyh
 * @date 2019-05-08
 **/
@Service
@EnableConfigurationProperties(RedisProperties.class)
public class MyPermissionProvider implements PermissionProvider {
    @Override
    public List<String> getPermissions(CurrentUser currentUser) {
        return null;
    }
}
