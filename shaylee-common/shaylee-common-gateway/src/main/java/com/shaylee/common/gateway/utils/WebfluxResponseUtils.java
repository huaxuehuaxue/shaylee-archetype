package com.shaylee.common.gateway.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * Title: webflux响应工具类
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-04-14
 */
public class WebfluxResponseUtils {

    public static Mono<Void> response(ServerWebExchange exchange, HttpStatus httpStatus, Object object) {
        String json = JSON.toJSONString(object);
        exchange.getResponse().setStatusCode(httpStatus);
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(json.getBytes(StandardCharsets.UTF_8));
        return exchange.getResponse().writeWith(Flux.just(buffer));
    }
}
