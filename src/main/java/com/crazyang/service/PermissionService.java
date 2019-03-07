package com.crazyang.service;

import com.crazyang.entity.Permission;

import java.util.List;

/**
 * @ClassName PermissionService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/6 下午10:22.
 */

public interface PermissionService extends IService<Permission>{

    List<String> queryPermissionByUserId(String userId);
}
