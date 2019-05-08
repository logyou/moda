package com.moda.permission.spring.boot.config;

import com.moda.permission.spring.boot.interceptor.AuthLoginInterceptor;
import com.moda.permission.spring.boot.interceptor.AuthPermissionInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器
 *
 * @author lyh
 * @date 2019-5-8
 **/
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(CustomWebMvcConfigurer.class);

    @Bean
    public AuthLoginInterceptor authLoginInterceptor() {
        logger.info("Init AuthLoginInterceptor...");
        return new AuthLoginInterceptor();
    }

    @Bean
    public AuthPermissionInterceptor authPermissionInterceptor() {
        logger.info("Init AuthPermissionInterceptor...");
        return new AuthPermissionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("Init addInterceptors...");

        //排除不需要拦截的地址
        String[] excludePathPatterns = {
                "/webjars/**",
                "/doc.html",
                "/swagger-resources",
                "/v2/api-docs",
                "/error/**"
        };

        //登录校验拦截器
        registry.addInterceptor(authLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludePathPatterns);

        //权限校验拦截器
        registry.addInterceptor(authPermissionInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludePathPatterns);
    }
}
