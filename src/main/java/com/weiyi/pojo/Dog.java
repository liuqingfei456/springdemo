package com.weiyi.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component
public class Dog implements InitializingBean,ApplicationContextAware {
    private ApplicationContext applicationContext;
    public Dog(){
        System.out.println("dog....constructor...");
    }
    //对象创建并赋值之前调用
    @PostConstruct
    public void init(){
        System.out.println("dog....@PostConstruct...");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("dog....@PreDestroy...");

    }
    //class ApplicationContextAwareProcessor 来做的
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("dog....afterPropertiesSet...");

    }
}