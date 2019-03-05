package com.crazyang.service.impl;

import com.crazyang.domain.User;
import com.crazyang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by zhouyang
 * Date 2019/3/5.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Test
    public void queryUserList() throws Exception {
    }

    @Test
    public void insert() throws Exception {

        User user = new User();
        user.setName("");
    }

}