package com.shaylee.common.rabbit.service.impl;

import com.shaylee.common.rabbit.service.AmqpService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Title: AMQP服务实现
 * Project: shaylee-framework
 *
 * @author Adrian
 * @date 2020-03-01
 */
@Component
public class AmqpServiceImpl implements AmqpService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public AmqpTemplate getAmqpTemplate() {
        return this.rabbitTemplate;
    }

    @Override
    public void sendMessage(String routingKey, Object message) {
        rabbitTemplate.convertAndSend(routingKey, message);
    }

    @Override
    public void sendMessage(String exchange, String routingKey, Object message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

    @Override
    public void sendMessageToExchange(String exchange, Object message) {
        rabbitTemplate.convertAndSend(exchange, null, message);
    }
}
