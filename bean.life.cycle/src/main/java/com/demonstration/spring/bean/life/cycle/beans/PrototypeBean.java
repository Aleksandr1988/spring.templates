package com.demonstration.spring.bean.life.cycle.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrototypeBean {

    private static final Logger logger = LoggerFactory.getLogger(PrototypeBean.class);
    private static boolean created;

    public PrototypeBean() {
        logger.info("CALL: Constructor");
        created = true;
    }

    public void destroyMethod() { // Never use for prototype scope! As it cannot be called :)
        logger.info("CALL: destroyMethod()");
    }

    public void initMethod() {
        logger.info("CALL: initMethod()");
    }

    public static boolean isCreated() {
        return created;
    }
}
