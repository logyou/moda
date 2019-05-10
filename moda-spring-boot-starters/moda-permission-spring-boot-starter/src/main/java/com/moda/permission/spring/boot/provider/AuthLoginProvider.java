package com.moda.permission.spring.boot.provider;

import com.moda.entity.annotation.AuthLogin;
import com.moda.entity.exception.AccessException;
import com.moda.entity.rest.BaseRequest;
import com.moda.entity.rest.Status;
import com.moda.session.spring.boot.autoconfigure.SessionContext;
import com.moda.util.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 登录验证服务提供者
 *
 * @author lyh
 * @date 2019-5-8
 **/
public class AuthLoginProvider implements AuthenticationProvider {
    @Autowired
    private SessionContext sessionContext;

    @Override
    public boolean authenticate(HttpServletRequest request, Object handler) {
        if (handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod) handler).getMethod();

            //如果方法或类加了 @AuthLogin 注解，则方法参数不能为空，同时验证登录信息
            if (isAnnotationPresent(method, AuthLogin.class)) {
                //验证登录信息
                return checkLogin(getBaseRequest(request));
            }
        }
        return true;
    }

    /**
     * 检查是否已登录
     *
     * @param baseRequest 请求信息
     * @return boolean
     */
    private boolean checkLogin(BaseRequest baseRequest) {
        if (StringUtils.isEmpty(baseRequest.getAccessToken())) {
            throw new AccessException(Status.NOT_LOGIN, "缺少访问凭证！");
        }
        if (sessionContext.getCurrentUser(baseRequest.getAccessToken()) == null) {
            throw new AccessException(Status.NOT_LOGIN, "登录失效，请重新登录！");
        }

        //重置 Session 有效期
        sessionContext.refreshCurrentUser(baseRequest.getAccessToken());

        return true;
    }
}
