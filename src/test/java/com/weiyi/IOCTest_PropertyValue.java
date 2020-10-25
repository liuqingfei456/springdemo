package com.weiyi;

import com.weiyi.config.MainConfigOfPropertyValues;
import com.weiyi.config.MainOfLifeCycle;
import com.weiyi.pojo.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_PropertyValue {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames= applicationContext.getBeanDefinitionNames();
        for (String name:definitionNames) {
            System.out.println(name);
        }
        System.out.println("ioc容器："+applicationContext);
    }
    @Test
    public void  test01(){
        printBeans(applicationContext);
        System.out.println("========");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

}
