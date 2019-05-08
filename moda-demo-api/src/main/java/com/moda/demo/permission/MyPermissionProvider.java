package com.moda.demo.permission;

import com.moda.entity.session.CurrentUser;
import com.moda.permission.spring.boot.provider.PermissionProvider;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author lyh
 * @date 2019-05-08
 **/
@Configuration
public class MyPermissionProvider implements PermissionProvider {
    @Override
    public List<String> getPermissions(CurrentUser currentUser) {
        return Arrays.asList("user.test", "user.a");
    }
}
