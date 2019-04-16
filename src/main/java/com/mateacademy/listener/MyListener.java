package com.mateacademy.listener;

import org.apache.log4j.Logger;

import javax.persistence.*;

public class MyListener<T extends Table> {
    private Logger logger = Logger.getLogger(MyListener.class);

    @PrePersist
    public void onPrePersist(T t) {
        logger.info("PrePersist message." + t.getClass().getName());
    }
    @PostPersist
    public void onPostPersist(T t) {
        logger.info("PostPersist message." + t.getClass().getName());
    }
    @PostLoad
    public void onPostLoad(T t) {
        logger.info("PostLoad message." + t.getClass().getName());
    }
    @PreUpdate
    public void onPreUpdate(T t) {
        logger.info("PreUpdate message." + t.getClass().getName());
    }
    @PostUpdate
    public void onPostUpdate(T t) {
        logger.info("PostUpdate message." + t.getClass().getName());
    }
    @PreRemove
    public void onPreRemove(T t) {
        logger.info("PreRemove message." + t.getClass().getName());
    }
    @PostRemove
    public void onPostRemove(T t) {
        logger.info("PostRemove message." + t.getClass().getName());
    }
}
