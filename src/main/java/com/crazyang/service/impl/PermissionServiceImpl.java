package com.crazyang.service.impl;

import com.crazyang.dao.PermissionMapper;
import com.crazyang.entity.LearnResource;
import com.crazyang.entity.Permission;
import com.crazyang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PermissionServiceImpl
 * @Description: 权限服务层实现类
 * @Author zhouyang
 * @Date 2019/3/6 下午10:24.
 */
@Service
public class PermissionServiceImpl extends BaseService<Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<String> queryPermissionByUserId(String userId) {
        return permissionMapper.queryPermissionByUserId(userId);
    }


}
