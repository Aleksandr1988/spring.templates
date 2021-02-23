package com.demonstration.spring.bean.life.cycle.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(CustomBeanPostProcessor.class);

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (beanName.contains("_bean"))
            logger.info("CALL: postProcessAfterInitialization(Object bean, String beanName) : {}", beanName);
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (beanName.contains("_bean"))
            logger.info("CALL: postProcessBeforeInitialization(Object bean, String beanName) : {}", beanName);
        return bean;
    }
}
