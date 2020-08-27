package com.demonstration.spring.bean.life.cycle.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrototypeBean {

    private static final Logger logger = LoggerFactory.getLogger(PrototypeBean.class);
    private static boolean created;

    public PrototypeBean() {
        logger.info("--- Constructor ---");
        created = true;
    }

    public void destroyMethod() {
        logger.info("--- destroy-method ---");
    }

    public void initMethod() {
        logger.info("--- init-method ---");
    }

    public static boolean isCreated() {
        return created;
    }
}
