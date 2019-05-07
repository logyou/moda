package com.moda.demo.permission;

import com.moda.entity.annotation.AuthPermission;
import com.moda.entity.exception.AccessException;
import com.moda.entity.rest.BaseRequest;
import com.moda.entity.rest.Status;
import com.moda.entity.session.CurrentUser;
import com.moda.session.spring.boot.autoconfigure.SessionContext;
import com.moda.util.lang.StringUtils;
import com.moda.util.mapper.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyh
 * @date 2019/05/07 0007
 **/
public class AuthenticationProvider {
    private Logger logger = LoggerFactory.getLogger(AuthenticationProvider.class);
    @Autowired(required = false)
    private PermissionProvider permissionProvider;
    @Autowired
    private SessionContext sessionContext;

    public boolean authenticate(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("authenticate...");
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            //如果方法或类加了 AuthPermission 注解，则方法参数不能为空，同时验证权限信息
            if (method.isAnnotationPresent(AuthPermission.class)
                    || method.getDeclaringClass().isAnnotationPresent(AuthPermission.class)) {
                RequestWrapper requestWrapper = new RequestWrapper(request);
                String body = requestWrapper.getBody();
                if (StringUtils.isEmpty(body)) {
                    throw new AccessException("缺少参数！");
                }
                BaseRequest param = JsonMapper.parseObject(body, BaseRequest.class);
                if (param == null) {
                    throw new AccessException("参数格式错误！");
                }

                //获取方法上的注解
                AuthPermission authPermission = method.getAnnotation(AuthPermission.class);
                //如果方法上的注解为空，则获取类上的注解
                if (authPermission == null) {
                    authPermission = method.getDeclaringClass().getAnnotation(AuthPermission.class);
                }
                //验证权限信息
                checkRight(param.getAccessToken(), authPermission);
            }
        }
        return true;
    }

    /**
     * 验证权限信息
     *
     * @param accessToken    访问凭证
     * @param authPermission 权限信息
     */
    private void checkRight(String accessToken, AuthPermission authPermission) {
        if (StringUtils.isEmpty(accessToken)) {
            throw new AccessException(Status.NOT_LOGIN, "缺少访问凭证！");
        }
        CurrentUser currentUser = sessionContext.getCurrentUser(accessToken);
        if (currentUser == null) {
            throw new AccessException(Status.NOT_LOGIN, "登录失效，请重新登录！");
        }

        // 需要的权限
        String[] flags = authPermission.value();
        //拥有的权限
        List<String> permissions = getPermissions(currentUser);

        if (permissions == null || permissions.isEmpty()) {
            logger.info("当前登录用户未拥有任何权限！");
            throw new AccessException("没有权限！");
        }

        //是否包含该权限
        boolean isSuccess = permissions.containsAll(Arrays.asList(flags));
        if (!isSuccess) {
            logger.info("当前登录用户未拥有 " + StringUtils.join(flags, ",") + " 权限！");
            throw new AccessException("没有权限！");
        }
    }

    /**
     * 获取当前用户权限列表
     *
     * @param currentUser 当前用户
     * @return 权限列表
     */
    private List<String> getPermissions(CurrentUser currentUser) {
        if (permissionProvider == null) {
            throw new NoSuchBeanDefinitionException(PermissionProvider.class,
                    "必须实现 " + PermissionProvider.class.getName() + " 接口！");
        }
        return permissionProvider.getPermissions(currentUser);
    }
}
