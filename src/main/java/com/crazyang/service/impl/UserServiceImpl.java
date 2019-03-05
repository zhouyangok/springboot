package com.crazyang.service.impl;

import com.crazyang.dao.UserMapper;
import com.crazyang.domain.User;
import com.crazyang.service.UserService;
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
    public List<User> queryUserList(Map<String, Object> map) {
        return userMapper.queryUserList(map);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
