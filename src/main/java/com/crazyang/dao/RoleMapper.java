package com.crazyang.dao;

import com.crazyang.core.util.MyMapper;
import com.crazyang.entity.Permission;
import com.crazyang.entity.Role;
import com.crazyang.entity.RolePermission;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface RoleMapper extends MyMapper<Role> {
    List<Role> queryRoleList(Map<String, Object> map);
}