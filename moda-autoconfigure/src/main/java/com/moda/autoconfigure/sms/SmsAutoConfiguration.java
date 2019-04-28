package com.moda.autoconfigure.sms;

import com.moda.util.sms.SmsSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配短信发送器
 *
 * @author lyh
 * @create 2018/09/02 16:20
 **/
@Configuration
@EnableConfigurationProperties(SmsProperties.class)
public class SmsAutoConfiguration {
    private static Logger logger = LoggerFactory.getLogger(SmsAutoConfiguration.class);
    @Autowired
    private SmsProperties smsProperties;

    @Bean
    public SmsSender smsSender() {
        logger.debug("Init SmsAutoConfiguration...");
        return new SmsSender(smsProperties.getApiKey());
    }
}
