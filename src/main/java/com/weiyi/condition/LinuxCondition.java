package com.weiyi.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory factory = context.getBeanFactory();//获取ioc bean工厂
        Environment environment = context.getEnvironment();//当前环境
        context.getClassLoader();//获取类加载器
        context.getRegistry();//获取bean定义的注册类
        if(environment.getProperty("os.name").contains("Mac")){
            return true;
        }
        return false;
    }
}
