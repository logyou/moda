package com.moda.autoconfigure.mail;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云短信自动装配
 *
 * @author lyh
 * @create 2018/09/02 16:20
 **/
@Configuration
@ConditionalOnClass({DefaultProfile.class, DefaultAcsClient.class})
@EnableConfigurationProperties(AliyunMailProperties.class)
public class AliyunMailAutoConfiguration {
    private static Logger logger = LoggerFactory.getLogger(AliyunMailAutoConfiguration.class);
    @Autowired
    private AliyunMailProperties aliyunMailProperties;

    @Bean
    public DefaultProfile defaultProfile() {
        logger.debug("Init DefaultProfile...");
        return DefaultProfile.getProfile(aliyunMailProperties.getRegionId(),
                aliyunMailProperties.getAccessKeyID(),
                aliyunMailProperties.getAccessKeySecret());
    }

    @Bean
    public DefaultAcsClient defaultAcsClient() {
        logger.debug("Init DefaultAcsClient...");
        return new DefaultAcsClient(defaultProfile());
    }
}
