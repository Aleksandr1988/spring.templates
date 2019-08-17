package com.demonstration.spring.bean.life.cycle.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonBean implements
        InitializingBean,
        DisposableBean,
        BeanFactoryAware,
        BeanNameAware,
        BeanClassLoaderAware {

    private static final Logger logger = LoggerFactory.getLogger(SingletonBean.class);
    private static boolean created;

    private String stringField;
    private Boolean booleanField;

    private SingletonBean(Boolean booleanField) {
        logger.info("--- Constructor with param : {} ---", booleanField);
        this.booleanField = booleanField;
        created = true;
    }

    public void setStringField(String stringField) {
        logger.info("--- Setter for StringField : {} ---", stringField);
        this.stringField = stringField;
    }

    public static boolean isCreated() {
        return created;
    }

    @Override
    public void setBeanName(String name) {
        logger.info("--- BeanNameAware.setBeanName : {} ---", name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        logger.info("--- BeanClassLoaderAware.setBeanClassLoader : {} ---", classLoader.toString());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("--- BeanFactoryAware.setBeanFactory : {} ---", beanFactory.toString());
    }

    public void initMethod() {
        logger.info("--- init-method ---");
    }

    @PostConstruct
    public void springPostConstruct() {
        logger.info("--- @PostConstruct ---");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("--- InitializingBean.afterPropertiesSet ---");
    }

    public void destroyMethod() {
        logger.info("--- destroy-method ---");
    }

    @PreDestroy
    public void springPreDestroy() {
        logger.info("--- @PreDestroy ---");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("--- DisposableBean.destroy ---");
    }

    @Override
    protected void finalize() {
        logger.info("--- Object finalize ---");
    }
}