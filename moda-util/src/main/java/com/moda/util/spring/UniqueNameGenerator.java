package com.moda.util.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * @author lyh
 * @create 2018/10/03 0003 23:40
 **/
public class UniqueNameGenerator extends AnnotationBeanNameGenerator {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        logger.info("generateBeanName...");
        String beanName = definition.getBeanClassName();
        logger.info(beanName);
        return beanName;
    }
}
