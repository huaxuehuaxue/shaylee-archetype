package com.shaylee.api.feign.fallback;

import com.shaylee.api.dto.SysRouteConfDTO;
import com.shaylee.api.feign.SysRouteConfClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Title:
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-04-03
 */
@Slf4j
@Component
public class SysRouteConfClientFallback implements FallbackFactory<SysRouteConfClient> {

    @Override
    public SysRouteConfClient create(Throwable throwable) {
        log.error(throwable.getMessage());
        return new SysRouteConfClient() {
            @Override
            public List<SysRouteConfDTO> getRouteConfList() {
                return null;
            }
        };
    }
}
