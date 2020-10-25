package com.weiyi;

import com.weiyi.config.MainConfig;
import com.weiyi.config.MainConfig2;
import com.weiyi.pojo.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name + "---");
        }
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        System.out.println("ioc容器创建完成。。。。");
//        for (String name : names) {
//            System.out.println(name+"---");
//        }
        Object bean1 = applicationContext.getBean("person");
//        Object bean2 = applicationContext.getBean("person");
//        System.out.println(bean1==bean2);
    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        for (String name : names) {
            System.out.println(name + "---");
        }
        Map<String, Person> personMap = applicationContext.getBeansOfType(Person.class);
        System.out.println(personMap);
    }

    @Test
    public void testImport() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name: names) {
            System.out.println(name);
        }
        //工厂bean获取的是调用getObject创建的对象
        Object object = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean类型:"+object.getClass());
        Object object2 = applicationContext.getBean("&colorFactoryBean");
        System.out.println("bean类型:"+object2.getClass());

    }
}
