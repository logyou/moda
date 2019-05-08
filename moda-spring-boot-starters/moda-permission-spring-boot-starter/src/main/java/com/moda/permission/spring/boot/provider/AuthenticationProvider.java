package com.moda.permission.spring.boot.provider;

import com.moda.entity.exception.AccessException;
import com.moda.entity.rest.BaseRequest;
import com.moda.permission.spring.boot.wrapper.CustomHttpServletRequestWrapper;
import com.moda.util.lang.StringUtils;
import com.moda.util.mapper.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 认证服务提供者
 *
 * @author lyh
 * @date 2019-05-08
 **/
public interface AuthenticationProvider {
    /**
     * 获取请求体
     *
     * @param request HttpServletRequest
     * @return BaseRequest
     */
    default BaseRequest getBaseRequest(HttpServletRequest request) {
        String body = new CustomHttpServletRequestWrapper(request).getBody();
        if (StringUtils.isEmpty(body)) {
            throw new AccessException("缺少参数！");
        }
        BaseRequest param = JsonMapper.parseObject(body, BaseRequest.class);
        if (param == null) {
            throw new AccessException("参数格式错误！");
        }
        return param;
    }

    /**
     * 认证
     *
     * @param request HttpServletRequest
     * @param handler Object
     * @return boolean
     */
    boolean authenticate(HttpServletRequest request, Object handler);

    /**
     * 检测方法或类加是否加了注解
     *
     * @param method Method
     * @param clazz  Class
     * @return boolean
     */
    default boolean isAnnotationPresent(Method method, Class<? extends Annotation> clazz) {
        return (method.isAnnotationPresent(clazz) || method.getDeclaringClass().isAnnotationPresent(clazz));
    }
}
