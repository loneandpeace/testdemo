package com.learn.spdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Aspect
@Service
public class LoggerDevice {

    @Pointcut("execution(* com.learn..*.*(..))")
    //@Pointcut("within(com.learn..*)")
    public void initLogAsp(){}

    @Before("initLogAsp()")
    //@Before("execution(* com.learn.spdemo..*.*(..)) && @annotation(loggerManage)") //, LoggerManage loggerManage
    public void beforeRun(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "initLogAsp()", returning = "obj")
    public void afterRun(JoinPoint joinPoint, Object obj){
        if (obj != null){
            //System.out.println(obj.toString());
        }
    }


}
