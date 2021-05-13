package com.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect  // 生成代理对象
public class UserProxy {
    //相同切入点抽取
    @Pointcut(value =  "execution(* com.aspectj.User.add())")
    public void pointcutDemo(){

    }
    // 前置通知
//    @Before(value = "execution(* com.aspectj.User.add())")
    @Before(value = "pointcutDemo()")
    @Order(4) // 设置优先级
    public void before(){
        System.out.println("before method...");
    }

    // 最终通知(不管有没有异常都会执行；在方法执行后就会执行）
    @After(value = "execution(* com.aspectj.User.add())")
    public void after(){
        System.out.println("after method...");
    }

    //后置返回通知（有异常不会执行；在方法执行返回结果之后才执行）
    @AfterReturning(value = "execution(* com.aspectj.User.add())")
    public void afterReturn(){
        System.out.println("afterReturning method...");
    }

    //异常通知（有异常才执行）
    @AfterThrowing(value = "execution(* com.aspectj.User.add())")
    public void afterThrowing(){
        System.out.println("afterThrowing method....");
    }

    //环绕通知（被增强方法的前后执行，但有异常时则中断执行）
    @Around(value = "execution(* com.aspectj.User.add())")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕之前");
        proceedingJoinPoint.proceed();  // 执行被增强的方法
        System.out.println("环绕之后");

    }
}
