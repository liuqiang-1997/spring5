package com.spring5.service;

import com.spring5.dao.UserDao;
import com.spring5.dao.UserDaoimpl;

public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add");
//        // 方式一：创建 UserDao对象调用其方法
//        UserDao userDao = new UserDaoimpl();
//        userDao.update();
        // 方式二：spring实现
        //1 创建UserDao类型的属性，生成set方法
        //2 配置文件中进行配置 bean2.xml
        userDao.update();
    }
}
