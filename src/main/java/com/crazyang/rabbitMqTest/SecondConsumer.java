package com.crazyang.rabbitMqTest;

import com.crazyang.common.config.rabbitMqConfig.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName SecondConsumer
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/4/9 下午4:13.
 */


@Component
@RabbitListener(queues =  {"second-queue"}, containerFactory = "rabbitListenerContainerFactory")
public class SecondConsumer {

    @RabbitHandler
    public void handleMessage(String message) throws Exception {
        // 处理消息
        System.out.println("SecondConsumer {} handleMessage :"+message);
    }

}
