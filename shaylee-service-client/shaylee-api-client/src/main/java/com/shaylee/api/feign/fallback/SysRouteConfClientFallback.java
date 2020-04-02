package com.shaylee.api.feign.fallback;

import com.shaylee.api.dto.SysRouteConfDTO;
import com.shaylee.api.feign.SysRouteConfClient;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-04-03
 */
@Component
public class SysRouteConfClientFallback implements SysRouteConfClient {

    @Override
    public SysRouteConfDTO getRouteConfList() {
        return null;
    }
}
