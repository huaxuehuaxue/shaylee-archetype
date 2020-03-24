package com.shaylee.mq.consumer.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Title: 网关消息监听器
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-09
 */
@Slf4j
@Component
@RabbitListener(queues = "message")
public class GatewayListener {

    @RabbitHandler
    public void process(String json) {
        log.info("接收消息：" + json);
        log.info("接收消息时间："+ new Date());
    }
}
