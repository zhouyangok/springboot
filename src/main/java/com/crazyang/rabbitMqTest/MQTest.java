package com.crazyang.rabbitMqTest;

import com.crazyang.common.config.rabbitMqConfig.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName FirstSender
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/4/9 下午3:54.
 */
@Component
public class MQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送字符串消息
     * @param uuid
     * @param message  消息
     */
    public void sendString(String uuid,Object message) {
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY1,
                message, correlationId);
    }

    /**
     * 发送字符串消息
     * @param uuid
     * @param message  消息
     */
    public void sendObject(String uuid,Object message) {
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY2,
                message, correlationId);
    }

    /**
     * 广播模式
     * @param content
     */
    public void sendAll(String content) {
        rabbitTemplate.convertAndSend("fanoutExchange","", content);
    }

}
