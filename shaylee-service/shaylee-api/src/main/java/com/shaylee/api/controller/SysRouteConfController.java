package com.shaylee.api.controller;

import com.shaylee.business.gateway.factory.RouteDefinitionFactory;
import com.shaylee.business.gateway.factory.SysRouteConfFactory;
import com.shaylee.business.gateway.manager.entity.SysRouteConfEntity;
import com.shaylee.business.gateway.manager.service.SysRouteConfService;
import com.shaylee.common.core.base.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统路由配置控制器
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-24
 */
@RestController
@RequestMapping("/routeConf")
public class SysRouteConfController {

    @Autowired
    private SysRouteConfService sysRouteConfService;

    @RequestMapping("/save")
    public R save() {
        List<RouteDefinition> routeDefinitionList = RouteDefinitionFactory.getRouteDefinitionList();
        List<SysRouteConfEntity> sysRouteConfEntities = new ArrayList<>();
        for (RouteDefinition routeDefinition : routeDefinitionList) {
            sysRouteConfEntities.add(SysRouteConfFactory.buildSysRouteConfEntity(routeDefinition));
        }
        sysRouteConfService.batchInsert(sysRouteConfEntities);
        return R.success();
    }

    @RequestMapping("/list")
    public R list() {
        List<SysRouteConfEntity> sysRouteConfEntityList = sysRouteConfService.queryAll();
        return R.data(sysRouteConfEntityList);
    }
}
