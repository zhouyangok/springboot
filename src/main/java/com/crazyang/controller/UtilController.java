package com.crazyang.controller;

import com.crazyang.common.baseClass.AjaxObject;
import com.crazyang.rabbitMqTest.MQTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName UtilController
 * @Description: 用于测试一些功能
 * @Author zhouyang
 * @Date 2019/4/9 下午4:03.
 */
@RestController
@Api(value="测试类", description="测试控制类，用于测试一些集成功能")
public class UtilController {


    @Autowired
    private MQTest firstSender;

    @ApiOperation(value = "rabbitMq发送字符串测试", response = String.class)
    @GetMapping("/sendString")
    public String send(@RequestParam(value = "message")String message) {
        String uuid = UUID.randomUUID().toString();
        firstSender.sendString(uuid, message);
        return uuid;
    }

    @GetMapping("/sendObject")
    public String sendObject(@RequestParam(value = "message")String message) {
        String uuid = UUID.randomUUID().toString();
        firstSender.sendObject(uuid, message);
        return uuid;
    }

    /**
     * 并发 测试，一个生产者多个消费者
     * 添加多个消费者，负载均衡消费队列消息
     * @param message
     * @return
     */
    @GetMapping("/mulSend")
    public String mulSend(@RequestParam(value = "message")String message) {
        for(int i = 0;i<100;i++){
            String uuid = UUID.randomUUID().toString();
            firstSender.sendString(uuid, message);
        }
      return AjaxObject.ok().toString();
    }

    /**
     * 广播模式
     * @param message
     * @return
     */
    @GetMapping("/sendAll")
    @ApiOperation(value = "rabbitMq发送广播模式测试", response = String.class)
    public String sendAll(@RequestParam(value = "message")String message) {
            firstSender.sendAll(message);
        return AjaxObject.ok().toString();
    }
}
