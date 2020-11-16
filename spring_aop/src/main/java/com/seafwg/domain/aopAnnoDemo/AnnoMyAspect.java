package com.seafwg.domain.aopAnnoDemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
//织入切面 标注当前MyAspect是一个切面类
@Aspect
public class AnnoMyAspect {
    //注入前置增强方法
    @Before("execution(* com.seafwg.aopAnnoDemo.*.*(..))")
    public void before() {
        System.out.println("前置增强方法...");
    }
    @Around("com.seafwg.domain.aopAnnoDemo.AnnoMyAspect.myPoint()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强方法...");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强...");
        return proceed;
    }

    @Pointcut("execution(* com.seafwg.aopAnnoDemo.*.*(..))")
    public void myPoint() {}
}
