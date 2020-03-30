package com.shaylee.common.rabbit.base;

import lombok.Data;

import java.io.Serializable;

/**
 * Title: 消息队列传输基类
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-30
 */
@Data
public class BaseMessageQueueDTO implements Serializable {
    private static final long serialVersionUID = 4526684486918707033L;

    String messageUID;
}
