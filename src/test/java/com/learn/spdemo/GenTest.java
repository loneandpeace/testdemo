package com.learn.spdemo;

import com.learn.spdemo.entity.AppUser;
import com.learn.spdemo.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GenTest {

    @Autowired
    IUserService uss;

    @Test
    public void testAdd(){
        AppUser u = new AppUser();
        u.setId(2);
        u.setEmail("q");
        u.setUsername("a");
        u.setPassword("b");
        uss.saveUser(u);
    }

}
