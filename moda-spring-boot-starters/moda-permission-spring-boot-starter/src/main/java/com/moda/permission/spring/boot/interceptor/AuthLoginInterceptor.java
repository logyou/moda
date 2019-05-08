package com.moda.permission.spring.boot.interceptor;

import com.moda.permission.spring.boot.provider.AuthLoginProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录校验拦截器
 *
 * @author lyh
 * @date 2019-5-8
 **/
public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private AuthLoginProvider authLoginProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return authLoginProvider.authenticate(request, handler);
    }
}
