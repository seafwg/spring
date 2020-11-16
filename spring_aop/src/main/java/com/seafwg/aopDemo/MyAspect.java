package com.seafwg.aopDemo;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    //前置增强方法
    public void before() {
        System.out.println("前置增强代码...");
    }
    //后置增强代码
    public void beforeRunning() {
        System.out.println("后置增强代码...");
    }
    //环绕增强
    //Proceeding JoinPoint:  正在执行的连接点===切点
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕增强前...");
        Object proceed = pjp.proceed();
        System.out.println("环绕增强后...");
        return proceed;
    }
}
