package comment.demo;

import comment.demo.config.SpringConfig;
import comment.demo.service.UserServices;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    @Test
    /**
     * 测试基于注解创建 bean实例对象
     */
    public void testUserServices(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean10.xml");
        UserServices services = context.getBean("userServices",UserServices.class);
        services.add();
        String name = services.getName();
        System.out.println(name);

    }
   @Test
   /**
    * 测试完全注解
    */
    public void testUserServices2(){
        // 1 加载配置类
       ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
       UserServices services = context.getBean("userServices",UserServices.class);
       services.add();
       String name = services.getName();
       System.out.println(name);
   }
}
