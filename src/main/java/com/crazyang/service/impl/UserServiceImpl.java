package com.crazyang.service.impl;

import com.crazyang.core.util.Page;
import com.crazyang.dao.UserMapper;
import com.crazyang.entity.User;
import com.crazyang.service.UserService;
import com.crazyang.core.tools.MD5Utils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhouyang
 * Date 2019/3/5.
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList(Page<User> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return userMapper.queryUserList(page.getCondition());
    }

    @Override
    public User getOne(int id) {
        return userMapper.getOne(id);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public int insert(User user) {
        user.setPassword(MD5Utils.getResult(user.getPassword() + user.getName()));
        return userMapper.insert(user);
    }

    @Override
    public int insertBatch(List<User> userList) {
        for (User user:userList) {
            user.setPassword(MD5Utils.getResult(user.getPassword() + user.getName()));
        }
        return userMapper.insertBatch(userList);
    }


    @Override
    public int update(User user) {
        user.setPassword(MD5Utils.getResult(user.getPassword() + user.getName()));
        return userMapper.update(user);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }
}
