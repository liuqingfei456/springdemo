package com.weiyi.config;

import com.weiyi.pojo.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期
 * 容器管理bean的生命周期
 * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候调用我们自定义的初始化和销毁方法
 *
 * 构造（对象创建）
 *   单实例的bean： 在容器启动的时候创建对象；
 *   多实例： 每次获取的时候；
 *BeanPostProcesser.postProcessBeforeInitialization
 *初始化：
 *   对象创建完成，并赋值好，调用初始化方法；
 *BeanPostProcesser.postProcessAfterInitialization
 *销毁：
 *   单实例bean：在容器关闭的时候；
 *   多实例bean：容器不会管理这个bean，容器不会调用销毁方法；
 *
 * 遍历得到所有的BeanPostProcesser,挨个执行beforeInitialization,一旦返回null，跳出for循环，不会执行后边BeanPostProcesser.postProcessorsBeforeInitialization
 *
 *
 * BeanPostProcesser的原理
 * populateBean(beanName, mbd, instanceWrapper);//给bean进行属性赋值
 * initializeBean
 * {
 *     applyBeanPostProcessorsBeforeInitialization(bean, beanName)
 *     invokeInitMethods(beanName, wrappedBean, mbd)
 *     applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName)
 * }
 *
 *
 * 1。指定初始化和销毁方法
 *       通过@bean指定 init-method destroy-method
 * 2。通过让Bean实现InitializingBean(定义初始化逻辑)
 *                DisposableBean（定义销毁逻辑）
 * 3。可以使用jsr250 @PostConstruct 在bean创建完成并且属性设置完成，来执行初始化方法，
 *                 @PreDestroy 在容器销毁bean之前同志我们进行清理工作
 * 4。BeanPostProcesser接口，bean的后置处理器；
 *    在bean初始化前后进行一些处理工作；
 *    postProcessBeforeInitialization:初始化之前调用
 *    postProcessAfterInitialization：初始化之后调用
 *
 *
 * spring底层BeanPostProcessor的原理：
 *    bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Async，。。。都是用BeanPostProcessor来完成的；
 *
 *
 */
@ComponentScan("com.weiyi.pojo")
@Configuration
public class MainOfLifeCycle {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return  new Car();
    }

}
