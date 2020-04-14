package com.shaylee.common.gateway.utils;

import org.springframework.web.server.ServerWebExchange;

/**
 * Title: Webflux Request上下文(传递filter的ServerWebExchange)
 * Project: shaylee-gateway
 *
 * @author Adrian
 * @date 2020-04-14
 */
public class WebFluxRequestHolder {

    private static ThreadLocal<ServerWebExchange> threadLocal = new ThreadLocal<>();

    public static ServerWebExchange getServerWebExchange() {
        return threadLocal.get();
    }

    public static void setServerWebExchange(ServerWebExchange serverWebExchange) {
        threadLocal.set(serverWebExchange);
    }
}
