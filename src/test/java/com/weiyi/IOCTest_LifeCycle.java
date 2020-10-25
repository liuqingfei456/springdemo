package com.weiyi;

import com.weiyi.config.MainOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MainOfLifeCycle.class);
        System.out.println("容器创建完成");
        //关闭容器
        configApplicationContext.close();
    }
}
