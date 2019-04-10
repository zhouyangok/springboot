package com.crazyang.service.impl;

import com.crazyang.common.exception.BusinessException;
import com.crazyang.common.baseClass.Page;
import com.crazyang.dao.UserMapper;
import com.crazyang.entity.User;
import com.crazyang.service.UserService;
import com.crazyang.common.utils.MD5Utils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
        User userVo = userMapper.findByName(user.getName());
        if (userVo != null) {
            throw new BusinessException(1,"用户已存在");
        }
        user.setUserId(String.valueOf(new Random().nextLong()));
        user.setPassword(MD5Utils.getResult(user.getPassword() + user.getName()));
        return userMapper.insert(user);
    }

    @Override
    public int insertBatch(List<User> userList) {
        for (User user : userList) {
            user.setPassword(MD5Utils.getResult(user.getPassword() + user.getName()));
        }
        return userMapper.insertBatch(userList);
    }

    /**
     * 修改用户，不包括用户密码
     *
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        try {
            return userMapper.update(user);
        }catch (Exception e){
            throw new BusinessException(1,e.getMessage());
        }

    }

    /**
     * 修改用户密码
     *
     * @param id
     * @return
     */
    public int editPassword(int id, String password) {
        return 0;
    }


    @Override
    public int deleteById(int id) {
        User user = userMapper.getOne(id);
        if(user==null){
            throw new BusinessException(404,"用户不存在");
        }
        try {
            return userMapper.deleteById(id);
        }catch (Exception e){
            throw new BusinessException("根据用户id"+id+"删除用户失败");
        }
    }
}
