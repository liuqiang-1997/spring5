package comment.demo.service;

import comment.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Component(value = "userServices")  // 相当于<bean id="userServices" class="..."/>
@Service
public class UserServices {
    // 定义dao类型属性,不需要set方法
//    @Autowired  // 根据类型自动装配注入
//    private UserDao userDao;

//    @Autowired  // 根据类型自动装配注入
//    @Qualifier(value = "userDaoImpl1")
//    private UserDao userDao;

//    @Resource
    @Resource(name = "userDaoImpl1")
    private UserDao userDao;

    @Value(value = "wahaha")
    private String name;

    public String getName() {
        return name;
    }

    public void add(){
        System.out.println("service add,,,,");
        userDao.add();
    }
}
