package com.moda.demo.permission;

import com.moda.util.spring.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lyh
 * @date 2019-05-07 17:09
 **/
@Configuration
public class AuthSecurityInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(AuthSecurityInterceptor.class);
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandle...");
        logger.info("request path[{}] uri[{}]", request.getServletPath(), request.getRequestURI());
        if (authenticationProvider == null) {
            logger.info("SpringContextHolder.getBean(AuthenticationProvider.class)...");
            authenticationProvider = SpringContextHolder.getBean(AuthenticationProvider.class);
        }
        return authenticationProvider.authenticate(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("afterCompletion...");
    }
}
