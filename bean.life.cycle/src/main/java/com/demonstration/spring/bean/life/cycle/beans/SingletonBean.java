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
        logger.info("CALL: Constructor with param : {} ", booleanField);
        this.booleanField = booleanField;
        created = true;
    }

    public void setStringField(String stringField) {
        logger.info("CALL: setStringField(String stringField) : {}", stringField);
        this.stringField = stringField;
    }

    public static boolean isCreated() {
        return created;
    }

    @Override
    public void setBeanName(String name) {
        logger.info("CALL: setBeanName(String name) : {}", name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        logger.info("CALL: setBeanClassLoader(ClassLoader classLoader) : {}", classLoader.getClass().getSimpleName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("CALL: setBeanFactory(BeanFactory beanFactory) : {}", beanFactory.toString());
    }

    public void initMethod() {
        logger.info("CALL: initMethod()");
    }

    @PostConstruct
    public void springPostConstruct() {
        logger.info("CALL: springPostConstruct()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("CALL: afterPropertiesSet()");
    }

    public void destroyMethod() {
        logger.info("CALL: destroyMethod()");
    }

    @PreDestroy
    public void springPreDestroy() {
        logger.info("CALL: springPreDestroy()");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("CALL: destroy()");
    }

    @Override
    protected void finalize() {
        logger.info("CALL: finalize()");
    }
}