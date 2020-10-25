package com.weiyi;

import com.weiyi.aop.MathCalculator;
import com.weiyi.config.MainConfigOfAop;
import com.weiyi.config.MainConfigOfPropertyValues;
import com.weiyi.pojo.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {


    @Test
    public void  test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        //不要自己new 要找spring容器的对象 不然spring没法代理
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1,1);
        applicationContext.close();
    }

}
