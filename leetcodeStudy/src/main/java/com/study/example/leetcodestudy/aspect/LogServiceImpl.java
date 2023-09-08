package com.study.example.leetcodestudy.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogServiceImpl {
    //定义切入点
    @Pointcut("execution(* com.study.example.leetcodestudy..*.*(..))")
    public void myPointCut(){}

    //将logBefore方法封装成Before通知，织入到myPointCut()切入点
    @Before("myPointCut()")
    public void logBefore() {
        System.out.println("....logServiceImpl.logBefore....");
    }

    //将logAfter方法封装成After通知，织入到myPointCut()切入点
    @After("myPointCut()")
    public void logAfter() {
        System.out.println("....logServiceImpl.logAfter....");
    }

    //将logReturnAfter方法封装成AfterReturning通知，织入到myPointCut()切入点
    @AfterReturning("myPointCut()")
    public void logReturnAfter() {
        System.out.println("....logServiceImpl.logReturnAfter....");
    }

    //将logThrowing方法封装成AfterThrowing通知，织入到myPointCut()切入点
    @AfterThrowing("myPointCut()")
    public void logThrowing() {
        System.out.println("....logServiceImpl.logThrowing....");
    }

}
