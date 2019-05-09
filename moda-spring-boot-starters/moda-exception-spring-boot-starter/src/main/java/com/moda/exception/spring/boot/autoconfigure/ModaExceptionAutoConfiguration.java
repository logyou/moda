package com.moda.exception.spring.boot.autoconfigure;

import com.moda.autoconfigure.product.ProductProperties;
import com.moda.autoconfigure.sys.SysProperties;
import com.moda.exception.spring.boot.config.MyWebServerFactoryCustomizer;
import com.moda.exception.spring.boot.controller.GlobalExceptionHandler;
import com.moda.exception.spring.boot.handler.ErrorController;
import com.moda.util.exception.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties({ProductProperties.class, SysProperties.class})
public class ModaExceptionAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ModaExceptionAutoConfiguration.class);
    @Autowired
    private ProductProperties productProperties;
    @Autowired
    private SysProperties sysProperties;

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

    @Bean
    public ExceptionHandler exceptionHandler() {
        logger.debug("Init ExceptionHandler...");
        return new ExceptionHandler(productProperties.getName(),
                sysProperties.getEnv(),
                sysProperties.getNotifyMailAddress());
    }
}