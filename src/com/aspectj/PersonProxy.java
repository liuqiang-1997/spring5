package com.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonProxy {

    // 前置通知
    @Before(value = "execution(* com.aspectj.User.add())")
    @Order(1)
    public void before(){
        System.out.println("PersonProxy before method...");
    }
}
