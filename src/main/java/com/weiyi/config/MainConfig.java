package com.weiyi.config;

import com.weiyi.pojo.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configurable
@ComponentScan(value = "com.weiyi",/*excludeFilters = {@Filter(type= FilterType.ANNOTATION,classes = {Controller.class})},*/
      includeFilters = {//@Filter(type=FilterType.ANNOTATION,classes =  {Controller.class}),
             @Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
      } , useDefaultFilters=false)
//@ComponentScans({@ComponentScan(value = "com.weiyi",
//        includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}, useDefaultFilters = false),
//        @ComponentScan(value = "com.weiyi",
//                includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Service.class})}, useDefaultFilters = false),
//        @ComponentScan(value = "com.weiyi",
//                includeFilters = {@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class})}, useDefaultFilters = false)})
public class MainConfig {
    @Bean("person") //给容器注册一个bean 类型为返回值类型，id默认：方法名作为🆔，也可以括号指定名称
    public Person person01() {
        Person person = new Person("zs", "13");
        return person;
    }
}
