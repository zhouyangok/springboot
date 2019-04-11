package com.crazyang.dao;

import com.crazyang.common.baseClass.MyMapper;
import com.crazyang.entity.SysLog;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/4/11 上午11:17.
 */

@Component
public interface LogMapper extends MyMapper<SysLog> {

    int insertLog(SysLog log);
}
