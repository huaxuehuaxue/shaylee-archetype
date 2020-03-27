package com.shaylee.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Title: 全局拦截器
 * Project: shaylee-gateway
 *
 * @author Adrian
 * @date 2020-03-23
 */
@Slf4j
@Component
public class RequestGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.debug("====>RequestGlobalFilter.filter exchange:[{}], chain:[{}]", exchange, chain);
        return chain.filter(exchange);
    }
}
