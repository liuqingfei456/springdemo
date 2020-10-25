package com.weiyi.config;

import com.weiyi.condition.LinuxCondition;
import com.weiyi.condition.MyImportBeanDefinitionRegistrar;
import com.weiyi.condition.MyImportSelector;
import com.weiyi.pojo.Color;
import com.weiyi.pojo.ColorFactoryBean;
import com.weiyi.pojo.Person;
import com.weiyi.pojo.Red;
import org.springframework.context.annotation.*;


@Configuration
@Conditional({LinuxCondition.class})
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
    @Bean
    @Scope
    @Lazy
    public Person person(){
        System.out.println("给容器中添加Person");
        return new Person("zs","11");
    }
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates","62");
    }
    @Bean("linux")
    public Person person02(){
        return new Person("Linux","62");
    }
    /**
     * 给容器家组建：
     * 1）包扫描+注解 (@Controller,@Service...)
     * 2) 使用@Bean（导入第三方包）
     * 3）@Import（快速给容器中导入组建）
     *     1。@Import 自动导入组建 id为类的全类名
     *     2。@ImportSelector 返回需要导入的组建的全类名数组---springboot用的比较多
     *     3。@ImportBeanDefinitionRegistrar 手工注册bean到容器中
     * 4) 使用spring提供的FactoryBean工厂
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
