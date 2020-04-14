package com.shaylee.gateway.exception;

import com.alibaba.fastjson.JSON;
import com.shaylee.common.core.base.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * Title: 全局异常拦截处理
 * Project: shaylee-gateway
 *
 * @author Adrian
 * @date 2020-04-14
 */
@Slf4j
@Primary
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler implements ErrorWebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        log.info("GLOBAL EXCEPTION:{}, \n{}", serverWebExchange.getRequest().getPath(), throwable);
        String message = "Sorry, problem occurs. Please contact our staff for help.";
        return this.response(serverWebExchange, Result.error(message));
    }

    private Mono<Void> response(ServerWebExchange exchange, Object object) {
        String json = JSON.toJSONString(object);
        exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        DataBuffer buffer = exchange.getResponse().bufferFactory()
                .wrap(json.getBytes(StandardCharsets.UTF_8));
        return exchange.getResponse().writeWith(Flux.just(buffer));
    }
}