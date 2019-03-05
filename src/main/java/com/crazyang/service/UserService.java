package com.crazyang.service;

import com.crazyang.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by zhouyang
 * Date 2019/3/5.
 */
public interface UserService extends IService<User> {

    List<User> queryUserList(Map<String,Object> map);

    int insert(User user);
}
