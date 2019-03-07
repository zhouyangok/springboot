package com.crazyang.dao;

import com.crazyang.core.util.MyMapper;
import com.crazyang.entity.Permission;
import com.crazyang.entity.Role;
import com.crazyang.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface PermissionMapper extends MyMapper<Permission> {

    List<Permission> queryPermissionList(Map<String, Object> map);

    List<String> queryPermissionByUserId(@Param("userId")String userId);

}