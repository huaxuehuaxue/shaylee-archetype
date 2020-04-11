package com.shaylee.common.datasource.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Title: 基础实体类
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-04-12
 */
@Getter
@Setter
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -8265830076772326768L;
    private Integer delFlag;
}
