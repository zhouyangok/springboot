package com.crazyang.dao;

import com.crazyang.core.util.MyMapper;
import com.crazyang.entity.Permission;
import com.crazyang.entity.Role;
import com.crazyang.entity.UserRole;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserRoleMapper extends MyMapper<UserRole> {
    List<UserRole> queryUserRoleList(Map<String, Object> map);
}