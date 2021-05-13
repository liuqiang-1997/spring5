package com.spring5.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoimpl implements UserDao {
    @Override
    public void update() {
        System.out.println("dao update");
    }
}
