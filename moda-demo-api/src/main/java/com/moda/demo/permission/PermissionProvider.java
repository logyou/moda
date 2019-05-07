package com.moda.demo.permission;

import com.moda.entity.session.CurrentUser;

import java.util.List;

/**
 * 权限提供者接口，在需要校验权限的项目中实现该接口
 * 并在实现的类上注解 @Service ,该注解为 org.springframework.stereotype.Service
 * 根据指定的类型 com.devkeep.permission.provider.PermissionProvider 获取实现类实例
 *
 * @author lyh
 * @date 2019-05-07
 **/
public interface PermissionProvider {
    /**
     * 获取当前登录用户的权限列表
     *
     * @param currentUser 当前登录用户
     * @return 权限列表
     */
    List<String> getPermissions(CurrentUser currentUser);
}
