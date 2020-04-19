package com.shaylee.api.consumer.controller;

import com.shaylee.api.dto.SysRouteConfDTO;
import com.shaylee.api.feign.SysRouteConfClient;
import com.shaylee.common.core.base.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统路由配置控制器
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-24
 */
@RestController
@RequestMapping("/routeConf/consumer")
public class SysRouteConfController {

    @Autowired
    private SysRouteConfClient sysRouteConfClient;

    @RequestMapping("/list")
    public R list() {
        List<SysRouteConfDTO> sysRouteConfEntityList = sysRouteConfClient.getRouteConfList();
        return R.data(sysRouteConfEntityList);
    }
}
