package com.crazyang.service;

import com.crazyang.common.baseClass.Page;
import com.crazyang.entity.User;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2019/3/5.
 */
public interface UserService extends IService<User> {

    List<User> queryUserList(Page<User> page);

    User getOne(int id);

    User findByName(String name);

    int insert(User user);

    int insertBatch(List<User> userList);

    int update(User user);

    int deleteById(int id);
}
