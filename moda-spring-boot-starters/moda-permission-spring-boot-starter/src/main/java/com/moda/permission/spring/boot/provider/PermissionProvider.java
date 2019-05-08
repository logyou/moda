package com.moda.permission.spring.boot.provider;

import com.moda.entity.session.CurrentUser;

import java.util.List;

/**
 * 权限提供者接口，在需要校验权限的项目中实现该接口
 * <p>并在实现的类上注解 @Configuration ,该注解为 org.springframework.context.annotation.Configuration</p>
 * <p>根据指定的类型 com.moda.permission.spring.boot.provider.PermissionProvider 获取实现类实例</p>
 *
 * @author lyh
 * @date 2019-05-08
 **/
public interface PermissionProvider {
    /**
     * 获取当前登录用户的权限列表
     * <p> 即当前用户拥有哪些权限</p>
     *
     * @param currentUser 当前登录用户
     * @return 权限列表
     */
    List<String> getPermissions(CurrentUser currentUser);
}
