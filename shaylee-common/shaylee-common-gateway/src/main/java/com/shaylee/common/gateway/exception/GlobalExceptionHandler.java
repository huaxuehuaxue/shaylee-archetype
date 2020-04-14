package com.shaylee.common.gateway.exception;

import com.shaylee.common.core.base.result.Result;
import com.shaylee.common.gateway.utils.WebfluxResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

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
        return WebfluxResponseUtils.response(serverWebExchange, HttpStatus.INTERNAL_SERVER_ERROR, Result.error(message));
    }
}