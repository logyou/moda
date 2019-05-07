package com.moda.demo.permission;

import com.moda.util.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.security.DenyAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author lyh
 * @date 2019-05-07 17:09
 **/
@Component("authSecurityInterceptor")
public class AuthSecurityInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(AuthSecurityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("AuthSecurityInterceptor.preHandle...");

        logger.info("request请求地址path[{}] uri[{}]", request.getServletPath(), request.getRequestURI());
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        DenyAll denyAll = method.getAnnotation(DenyAll.class);
        if (denyAll == null) {
            denyAll = method.getDeclaringClass().getAnnotation(DenyAll.class);
        }

        if (denyAll != null) {
            ExceptionUtils.throwAccessException("拒绝访问");
        }

        try {
            RequestWrapper requestWrapper = new RequestWrapper(request);
            String body = requestWrapper.getBody();
            System.out.println(body);
            return true;
        } catch (Exception e) {
            logger.error("权限判断出错", e);
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
