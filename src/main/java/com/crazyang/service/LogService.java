package com.crazyang.service;

import com.crazyang.entity.SysLog;

/**
 * @ClassName LogService
 * @Description: 日志服务层接口
 * @Author zhouyang
 * @Date 2019/4/11 上午11:15.
 */

public interface LogService extends IService<SysLog> {

    /**
     * 插入日志
     * @param entity
     * @return
     */
    int insertLog(SysLog entity);
}
