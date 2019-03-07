package com.crazyang.dao;

import com.crazyang.core.util.MyMapper;
import com.crazyang.entity.Role;
import com.crazyang.entity.RolePermission;
import com.crazyang.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface RolePermissionMapper extends MyMapper<RolePermission> {

    List<RolePermission> queryRolePermissionList(Map<String, Object> map);

};