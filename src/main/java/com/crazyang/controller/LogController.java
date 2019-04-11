package com.crazyang.controller;

import com.crazyang.common.config.logConfig.LogConfig;
import com.crazyang.service.LogService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LogController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/4/11 上午11:38.
 */

@RestController
public class LogController {

    private final static Logger log = org.slf4j.LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogService logService;

    @RequestMapping("/aop")
    @ResponseBody
    @LogConfig("测试aoplog")
    public Object aop(String name, String nick) {
        Map<String, Object> map =new HashMap<>();
        log.info("我被执行了！");
        map.put("res", "ok");
        return map;
    }
}
