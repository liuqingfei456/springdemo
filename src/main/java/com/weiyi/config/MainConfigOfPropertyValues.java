package com.weiyi.config;

import com.weiyi.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 并定义组件想要使用spring容器底层的一些组建（applicationcontext，beanfactory，xxx）
 *    自定义组件实现xxxAware接口，功能是由xxxAwareProcessor实现
 *     ApplicationContextAware==》ApplicationContextAwareProcessor
 *
 *
 */
@ComponentScan("com.weiyi.pojo")
@PropertySource("classpath:/person.properties")
@Configuration
public class MainConfigOfPropertyValues {
    @Bean("person")
    public Person person() {
        Person person = new Person();
        return person;
    }
}
