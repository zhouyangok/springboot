package com.crazyang.dao;

import com.crazyang.common.baseClass.MyMapper;
import com.crazyang.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface RoleMapper extends MyMapper<Role> {
    List<Role> queryRoleList(Map<String, Object> map);
}