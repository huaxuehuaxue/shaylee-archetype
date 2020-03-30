package com.shaylee.mq.consumer.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
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
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "shaylee_test_queue", durable = "true"),
        exchange = @Exchange(name="shaylee_test_exchange", ignoreDeclarationExceptions = "true", type = "topic"),
        key = {"shaylee_test_key"}))
public class GatewayListener {

    @RabbitHandler
    public void process(@Payload String data) {
        log.info("接收消息：" + data);
        log.info("接收消息时间："+ new Date());
    }
}
