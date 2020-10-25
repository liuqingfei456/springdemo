package com.weiyi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {
    //如果其他切面类引入 则pointcut方法的
    @Pointcut("execution(public int com.weiyi.aop.MathCalculator.div(..))")
    public void pointCut(){};
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"运行。。。参数列表是:"+ Arrays.asList(joinPoint.getArgs()));
    }
    @After(value = "pointCut()")
    public void endStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"结束");
    }
    @AfterReturning(value = "pointCut()",returning = "result") //joinpoint要放在参数第一位
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"正常返回。。。运行结果，{"+result+"}");
    }
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logExeption(JoinPoint joinPoint,Exception exception){
        System.out.println(joinPoint.getSignature().getName()+"异常。。。异常信息，{}");
    }

}
