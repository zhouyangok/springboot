package com.crazyang.dao;

import com.crazyang.common.baseClass.MyMapper;
import com.crazyang.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface PermissionMapper extends MyMapper<Permission> {

    List<Permission> queryPermissionList(Map<String, Object> map);

    List<String> queryPermissionByUserId(@Param("userId")String userId);

}