package com.shaylee.business.gateway.dto;

import lombok.Data;

import java.util.Map;

/**
 * Title: gateway的predicates配置 JSON格式[{"args": {"_genkey_0": "/api/oss/**"}, "name": "Path"}]
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-24
 */
@Data
public class PredicateProperties {
    /**
     * 参数名
     */
    private String name;
    /**
     * 参数值
     */
    private Map<String, String> args;
}
