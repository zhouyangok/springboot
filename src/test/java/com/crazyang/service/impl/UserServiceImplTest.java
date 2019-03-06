package com.crazyang.service.impl;

import com.crazyang.core.util.Page;
import com.crazyang.entity.User;
import com.crazyang.model.LeanQueryLeanListReq;
import com.crazyang.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouyang
 * Date 2019/3/5.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    /**
     * 查询所有
     *
     * @throws Exception
     */
    @Test
    public void queryUserList() throws Exception {
        Page<User> page = new Page<>();
        List<User> list = userService.queryUserList(page);
        System.out.println(list.size());
    }

    /**
     * 单个查询
     */
    @Test
    public void selectOne() {
        int id = 1;
        User user = userService.getOne(id);
        System.out.println(user.getName());
    }

    @Test
    public void findByName() {
        String name = "admin1";
        User user = userService.findByName(name);
        System.out.println(user.getName());
    }

    /**
     * 单个插入
     *
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {

        User user = new User();
        user.setName("test01");
        user.setPassword("test01");
        user.setAddress("test02");
        int result = userService.insert(user);
        System.out.println(result);
    }


    /**
     * 批量插入
     */
    @Test
    public void insetBatch() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("test-" + i);
            user.setPassword("test-" + i);
            user.setAddress("pass-" + i);
            user.setPhone("phone_" + i);
            users.add(user);
        }
        int result = userService.insertBatch(users);
        System.out.println(result);
    }

    /**
     * 更新操作
     *
     * @throws Exception
     */
    @Test
    public void update() throws Exception {
        User user = new User();
        user.setId(4);
        user.setName("test01");
        user.setPassword("test01");
        user.setAddress("test02");
        user.setPhone("13789873322");
        int result = userService.update(user);
        System.out.println(result);
    }

    /**
     * 删除操作
     *
     * @throws Exception
     */
    @Test
    public void delete() throws Exception {
        int result = userService.deleteById(3);
        System.out.println(result);
    }


}