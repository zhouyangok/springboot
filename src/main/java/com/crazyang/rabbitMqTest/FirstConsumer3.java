package com.crazyang.rabbitMqTest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FirstConsumer
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/4/9 下午3:55.
 */
@Component
@RabbitListener(queues =  {"first-queue"}, containerFactory = "rabbitListenerContainerFactory")
public class FirstConsumer3 {

//    @RabbitListener(queues = {"first-queue","second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    @RabbitHandler
    public void handleMessage(String message) throws Exception {
        // 处理消息
        System.out.println("接收队列消息3 {} handleMessage :"+message);
    }

}
