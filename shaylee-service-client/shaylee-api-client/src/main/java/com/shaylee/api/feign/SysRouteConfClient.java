package com.shaylee.api.feign;

import com.shaylee.api.dto.SysRouteConfDTO;
import com.shaylee.api.feign.fallback.SysRouteConfClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Title: 系统路由信息接口Client
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-04-03
 */
@FeignClient(value = "shaylee-api", path = "api", fallbackFactory = SysRouteConfClientFallback.class)
public interface SysRouteConfClient {

    @GetMapping("/routeConf/list")
    List<SysRouteConfDTO> getRouteConfList();
}
