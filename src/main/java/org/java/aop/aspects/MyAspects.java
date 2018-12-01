package org.java.aop.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.*;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.awt.datatransfer.StringSelection;

@Aspect
@Component
@Order(1)
public class MyAspects {

    @Pointcut("execution(public void add*(..))")
    public void general(){}
    @Pointcut("execution(public String get*(..))")
    public void getter(){}
    @Pointcut("execution(public void set*(..))")
    public void setter(){}


    @Before("general() && !(getter()||setter())")
    public void display()
    {
        System.out.println("=====================>>CALLING Aspects");
    }

    @AfterReturning(pointcut = "execution(public String get*(..))",returning = "returnVal")
    public void getAnswer(JoinPoint joinPoint,String returnVal)
    {
        //System.out.println("Hello");
        String method=joinPoint.getSignature().toShortString();
        System.out.println(method+returnVal);
    }

    @AfterThrowing(pointcut = "execution(public void set*(..))",throwing = "exception")
    public void getException(JoinPoint joinPoint,Throwable exception)
    {
        String method=joinPoint.getSignature().toShortString();
        System.out.println(method);
        System.out.println("The exception is"+exception);
    }

    @Around("general() || getter() || setter()")
    public void around(ProceedingJoinPoint proceedingJoinPoint)
    {
        System.out.println("Started");
        try {
            proceedingJoinPoint.proceed();
        }
        catch (Throwable e)
        {
            return;
        }
        System.out.println("Ending");
    }


}
