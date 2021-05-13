package com.aspectj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class User {

    @Value(value = "wahahah")
    private String name;
//    @Autowired
//    @Qualifier(value = "china")
    public static String ardess;

    @Autowired
    public static void setArdess(String ardess) {
        User.ardess = ardess;
    }

    public String getName() {
        return name;
    }

    public void add(){
//        int i = 10/0;
        System.out.println("add method....");
    }
}
