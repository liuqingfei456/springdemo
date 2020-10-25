package com.weiyi;


import com.weiyi.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_ext {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布了一个事件")) {
        });
        applicationContext.close();
    }
}
