package com.moda.swagger.spring.boot.autoconfigure;

import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyh
 * @date 2019-04-28 00:41:40
 **/
@Configuration
@EnableConfigurationProperties(ModaMyBatisProperties.class)
@ConditionalOnClass(name = {
        "org.apache.ibatis.session.AutoMappingBehavior",
        "org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer"
})
public class ModaMyBatisAutoConfiguration {
    private Logger logger = LoggerFactory.getLogger(ModaMyBatisAutoConfiguration.class);
    @Autowired
    private ModaMyBatisProperties modaMyBatisProperties;

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        logger.info("Init ModaMyBatisAutoConfiguration.configurationCustomizer....");
        return configuration -> {
            configuration.setCacheEnabled(true);
            configuration.setLazyLoadingEnabled(false);
            configuration.setAggressiveLazyLoading(true);
            configuration.setMultipleResultSetsEnabled(true);
            configuration.setUseColumnLabel(true);
            configuration.setUseGeneratedKeys(false);
            configuration.setAutoMappingBehavior(AutoMappingBehavior.PARTIAL);
            configuration.setDefaultExecutorType(ExecutorType.SIMPLE);
            configuration.setMapUnderscoreToCamelCase(true);
            configuration.setLocalCacheScope(LocalCacheScope.SESSION);
            configuration.setJdbcTypeForNull(JdbcType.NULL);
        };
    }
}
