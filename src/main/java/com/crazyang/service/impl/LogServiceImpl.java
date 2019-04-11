package com.crazyang.service.impl;

import com.crazyang.dao.LogMapper;
import com.crazyang.entity.SysLog;
import com.crazyang.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LogServiceImpl
 * @Description: 日志服务层实现
 * @Author zhouyang
 * @Date 2019/4/11 上午11:16.
 */

@Service("logService")
public class LogServiceImpl extends BaseService<SysLog> implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public int insertLog(SysLog entity) {
        return logMapper.insertLog(entity);
    }
}
