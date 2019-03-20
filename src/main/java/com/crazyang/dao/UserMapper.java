package com.crazyang.dao;

import com.crazyang.entity.User;
import com.crazyang.common.baseClass.MyMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserMapper extends MyMapper<User> {

    List<User> queryUserList(Map<String, Object> map);

    @Select("SELECT * FROM user WHERE id=#{id}")
    User getOne(int id);

    @Select("SELECT * FROM user WHERE name=#{name}")
    User findByName(String name);

    int insert(User user);

    int insertBatch(List<User> userList);

    int update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    int deleteById(int id);

}