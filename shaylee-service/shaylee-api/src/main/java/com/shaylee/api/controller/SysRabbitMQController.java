package com.shaylee.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaylee.common.core.base.result.Result;
import com.shaylee.common.rabbit.service.AmqpService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 消息队列测试
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-30
 */
@RestController
@RequestMapping("/rabbit")
public class SysRabbitMQController {

    /** 交换机名 */
    private final static String SHAYLEE_TEST_EXCHANGE = "shaylee_test_exchange";
    /** 交换关键字 */
    private final static String SHAYLEE_TEST_ROUTHINGKEY = "shaylee_test_key";
    /** 接收队列 */
    private final static String SHAYLEE_TEST_QUEUE = "shaylee_test_queue";

    @Autowired
    private AmqpService amqpService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/test")
    public Result test() throws JsonProcessingException {
        TestRabbit testRabbit = new TestRabbit();
        testRabbit.setUserId(10001L);
        testRabbit.setUserName("adrian");
        testRabbit.setCreateDate(new Date());
        testRabbit.setUpdateDate(new Date());
        amqpService.sendMessage(SHAYLEE_TEST_EXCHANGE, SHAYLEE_TEST_ROUTHINGKEY, objectMapper.writeValueAsString(testRabbit));
        return Result.success();
    }

    @Data
    public static class TestRabbit {
        private Long userId;
        private String userName;
        private Date createDate;
        private Date updateDate;
    }
}
