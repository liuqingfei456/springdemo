package com.weiyi.pojo;

import com.weiyi.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean(Person.class));
        String[] names = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name+"---");
        }
    }
}
