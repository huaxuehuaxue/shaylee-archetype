package com.shaylee.common.security.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Jwt
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-03-01
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    /**
     * 密钥
     */
    private String secret;
    /**
     * Token有效时长(单位秒)
     */
    private Integer expire;
}