package com.crazyang.dao;

import com.crazyang.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouyang
 * Date 2019/3/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void queryUserList() throws Exception {
        Map map = new HashMap<>();
        List<User> lists = userMapper.queryUserList(map);

        for(User user:lists){
            System.out.println(user.getName());
        }

        System.out.println(lists.size());
    }

}