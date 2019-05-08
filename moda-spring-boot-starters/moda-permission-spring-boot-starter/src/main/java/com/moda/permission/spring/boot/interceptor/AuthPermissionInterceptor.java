package com.moda.permission.spring.boot.interceptor;

import com.moda.permission.spring.boot.provider.AuthPermissionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限校验拦截器
 *
 * @author lyh
 * @date 2019-5-8
 **/
public class AuthPermissionInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private AuthPermissionProvider authenticationProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return authenticationProvider.authenticate(request, handler);
    }
}
