package com.moda.autoconfigure.exception;

import com.moda.autoconfigure.product.ProductProperties;
import com.moda.autoconfigure.sys.SysProperties;
import com.moda.util.exception.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配异常处理
 *
 * @author lyh
 * @create 2018-09-02
 **/
@Configuration
@EnableConfigurationProperties({ProductProperties.class, SysProperties.class})
public class ExceptionHandlerAutoConfiguration {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHandlerAutoConfiguration.class);
    @Autowired
    private ProductProperties productProperties;
    @Autowired
    private SysProperties sysProperties;

    @Bean
    public ExceptionHandler exceptionHandler() {
        logger.debug("Init ExceptionHandler...");
        return new ExceptionHandler(productProperties.getName(),
                sysProperties.getEnv(), sysProperties.getNotifyMailAddress());
    }
}
