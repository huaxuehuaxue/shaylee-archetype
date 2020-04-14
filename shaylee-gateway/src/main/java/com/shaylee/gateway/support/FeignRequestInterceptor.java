package com.shaylee.gateway.support;

import com.shaylee.common.gateway.utils.WebFluxRequestHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ServerWebExchange;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Title: Feign拦截器(传递header)
 * Project: shaylee-gateway
 *
 * @author Adrian
 * @date 2020-04-14
 */
public class FeignRequestInterceptor implements RequestInterceptor {

    public static final String REQUEST_HEADER_TOKEN = "token";

    @Override
    public void apply(RequestTemplate template) {
        // Filter收到的header的token字段添加到Feign调用的请求头中
        ServerWebExchange exchange = WebFluxRequestHolder.getServerWebExchange();
        if (exchange != null) {
            ServerHttpRequest serverHttpRequest = exchange.getRequest();
            String token = serverHttpRequest.getHeaders().getFirst(REQUEST_HEADER_TOKEN);
            if(StringUtils.isBlank(token)){
                token = serverHttpRequest.getQueryParams().getFirst(REQUEST_HEADER_TOKEN);
            }
            template.header(REQUEST_HEADER_TOKEN, token);
        }

        // 服务之间的Feign调用，携带header
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                Enumeration<String> values = request.getHeaders(name);
                while (values.hasMoreElements()) {
                    String value = values.nextElement();
                    template.header(name, value);
                }
            }
        }
    }
}
