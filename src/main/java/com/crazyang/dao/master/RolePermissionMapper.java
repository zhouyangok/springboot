package com.crazyang.dao.master;

import com.crazyang.common.baseClass.MyMapper;
import com.crazyang.entity.RolePermission;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface RolePermissionMapper extends MyMapper<RolePermission> {

    List<RolePermission> queryRolePermissionList(Map<String, Object> map);

};