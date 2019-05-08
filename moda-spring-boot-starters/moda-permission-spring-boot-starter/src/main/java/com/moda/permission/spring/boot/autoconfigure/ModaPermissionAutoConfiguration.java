package com.moda.permission.spring.boot.autoconfigure;

import com.moda.permission.spring.boot.config.CustomWebMvcConfigurer;
import com.moda.permission.spring.boot.filter.RewriteRequestBodyFilter;
import com.moda.permission.spring.boot.provider.AuthLoginProvider;
import com.moda.permission.spring.boot.provider.AuthPermissionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 自动装配权限配置
 *
 * @author lyh
 * @date 2019-5-6
 */
@Configuration
@Import(CustomWebMvcConfigurer.class)
public class ModaPermissionAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ModaPermissionAutoConfiguration.class);

    @Bean
    public AuthPermissionProvider authenticationProvider() {
        logger.info("Init AuthPermissionProvider...");
        return new AuthPermissionProvider();
    }

    @Bean
    public AuthLoginProvider authLoginProvider() {
        logger.info("Init AuthLoginProvider...");
        return new AuthLoginProvider();
    }

    @Bean
    public RewriteRequestBodyFilter rewriteRequestBodyFilter() {
        logger.info("Init RewriteRequestBodyFilter...");
        return new RewriteRequestBodyFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        logger.info("Init FilterRegistrationBean...");
        FilterRegistrationBean<RewriteRequestBodyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(rewriteRequestBodyFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("rewriteRequestBodyFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}