package com.spring5.testdemo;

import com.spring5.User;
import com.spring5.autowire.Dept;
import com.spring5.autowire.Emp;
import com.spring5.collectiontype.Books;
import com.spring5.collectiontype.Course;
import com.spring5.collectiontype.Stu;
import com.spring5.demo1.Book;
import com.spring5.demo1.Orders;
import com.spring5.service.UserService;
import com.spring5.factorybean.MyBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void testAdd(){
        /**
         * BeanFactory接口: IOC容器基本实现，是spring内部的使用接口，不提供开发人员使用
         *              加载配置文件时不会创建配置文件中的对象，只有在获取或使用对象时才创建对象（用时创建对象）
         * ApplicationContext接口: BeanFactory接口的子接口，提供更多更强大的功能，一般由开发人员使用
         *              加载配置文件时就会创建配置文件中的对象
         *              配置文件在src下使用ClassPathXmlApplicationContext(配置文件名.后缀)；
         *              配置文件在工程下使用FileSystemXmlApplicationContext（带盘符路径的配置文件名.后缀）
         */
        // 1. ApplicationContext接口 加载spring配置文件

//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 2. BeanFactory接口 加载spring配置文件
        BeanFactory context = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 获取配置创建的对象
        User user = context.getBean("user", User.class);// "user" 对应配置文件中的id

        System.out.println(user);
        user.add();
    }

    @Test
    /**
     * 测试set方法注入属性
     */
    public void testBook(){
     //1 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
     //2 获取配置创建的对象
        Book book = context.getBean("book",Book.class);
        book.testDemo();
    }

    @Test
    /**
     * 测试使用有参数构造器注入属性
     */
    public void testOrders(){
        //1 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2 获取配置创建的对象
        Orders orders = context.getBean("orders",Orders.class);
        orders.testDemo();
    }

    @Test
    /**
     * 测试注入外部bean
     */
    public void testUserService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService",UserService.class);
        userService.add();
    }

    @Test
    /**
     * 测试注入内部bean和级联赋值
     */
    public void testEmp(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml"); //内部bean
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");  // 级联赋值
        Emp emp = context.getBean("emp",Emp.class);
//        emp.showInfo();

    }

    @Test
    /**
     * 测试注入集合类型属性
     */
    public void testCollection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Stu stu = context.getBean("stu",Stu.class);
        stu.test();
    }
    @Test
    /**
     * 测试提取集合注入部分
     */
    public void testCollection1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean55.xml");
        Books books = context.getBean("books", Books.class);
        books.testbooks();
    }

    @Test
    /**
     * 测试工厂bean
     */
    public void testFactoryBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
//        MyBean myBean = context.getBean("mybean",MyBean.class);  // 普通bean
//        System.out.println(myBean);
        Course course = context.getBean("mybean", Course.class);  // 工厂bean
        System.out.println(course);
    }

    @Test
    /**
     * 测试bean的作用域（单实例和多实例）
     */
    public void testCollection2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean55.xml");
        Books books1 = context.getBean("books", Books.class);
        Books books2 = context.getBean("books", Books.class);
        System.out.println(books1);
        System.out.println(books2);
    }

    @Test
    /**
     * 测试bean的生命周期
     */
    public void testBean(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        com.spring5.bean.Orders orders = context.getBean("orders", com.spring5.bean.Orders.class);
        System.out.println("第四步：获取创建的bean实例对象");
        System.out.println(orders);
        // 手动销毁bean实例
//        ((ClassPathXmlApplicationContext)context).close();
        context.close();
    }

    @Test
    /**
     * 测试bean的自动装配
     */
    public void testAutoWire(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");
        Emp emp = context.getBean("emp",Emp.class);
        System.out.println(emp);

    }
}
