package com.aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJTest {

    @Test
    public void aspectj(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean11.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigAspectJ.class);  // 完全注解开发
        User user = context.getBean("user",User.class);
//        user.add();
        String name = user.getName();
        System.out.println("name is:"+name);
//        User.setArdess("CHINA");

        System.out.println(User.ardess);
    }
}
