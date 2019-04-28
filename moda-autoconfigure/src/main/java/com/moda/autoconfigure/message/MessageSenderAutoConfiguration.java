package com.moda.autoconfigure.message;

import com.moda.util.message.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息发送器自动装配
 *
 * @author lyh
 * @create 2018/09/02 16:20
 **/
@Configuration
public class MessageSenderAutoConfiguration {
    private static Logger logger = LoggerFactory.getLogger(MessageSenderAutoConfiguration.class);

    @Bean
    public MessageSender messageSender() {
        logger.debug("Init MessageSender...");
        return new MessageSender();
    }
}
