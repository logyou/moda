package com.moda.exception.spring.boot.autoconfigure;

import com.moda.exception.spring.boot.config.MyWebServerFactoryCustomizer;
import com.moda.exception.spring.boot.controller.GlobalExceptionHandler;
import com.moda.exception.spring.boot.handler.ErrorController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义 WEB 服务器参数
 * 可以配置默认错误页面
 *
 * @author lyh
 * @date 2019-5-6
 */
@Configuration
public class ModaExceptionAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ModaExceptionAutoConfiguration.class);

    @Bean
    public MyWebServerFactoryCustomizer myWebServerFactoryCustomizer() {
        logger.info("Init ModaExceptionAutoConfiguration.myWebServerFactoryCustomizer...");
        return new MyWebServerFactoryCustomizer();
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        logger.info("Init ModaExceptionAutoConfiguration.globalExceptionHandler...");
        return new GlobalExceptionHandler();
    }

    @Bean
    public ErrorController errorController() {
        logger.info("Init ModaExceptionAutoConfiguration.errorController...");
        return new ErrorController();
    }
}