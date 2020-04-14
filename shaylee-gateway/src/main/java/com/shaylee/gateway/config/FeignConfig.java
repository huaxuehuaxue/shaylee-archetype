package com.shaylee.gateway.config;

import com.shaylee.gateway.support.FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: Feign配置类
 * Project: shaylee-gateway
 *
 * @author Adrian
 * @date 2020-04-14
 */
@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }
}
