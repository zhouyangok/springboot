package com.crazyang.dao;

import com.crazyang.domain.User;
import com.crazyang.util.MyMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserMapper extends MyMapper<User> {

    List<User> queryUserList(Map<String,Object> map);

    int insert(User user);

}