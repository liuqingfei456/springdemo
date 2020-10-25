package com.weiyi;

import com.weiyi.config.MainConfigOfProfile;
import com.weiyi.config.MainConfigOfPropertyValues;
import com.weiyi.pojo.Person;
import com.weiyi.pojo.Yellow;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {


    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames= applicationContext.getBeanNamesForType(Yellow.class);
        for (String name:definitionNames) {
            System.out.println(name);
        }
    }
    @Test
    public void  test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //1.创建一个无餐构造applicationContext
        //2。设置激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test");
        //3。注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4。启动刷新容器
        applicationContext.refresh();

        printBeans(applicationContext);
    }
}
