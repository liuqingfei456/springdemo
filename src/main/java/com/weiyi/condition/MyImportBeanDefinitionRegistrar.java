package com.weiyi.condition;

import com.weiyi.pojo.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition注册类
     *                 把所有需要加载到容器中的类手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean definition1 = registry.containsBeanDefinition("com.weiyi.pojo.Red");
        boolean definition2 = registry.containsBeanDefinition("com.weiyi.pojo.Blue");
        if(definition1&& definition1){
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //可以注册类的作用域等等
            registry.registerBeanDefinition("rainbow",beanDefinition);

        }
    }
}
