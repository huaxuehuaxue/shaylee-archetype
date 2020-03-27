package com.shaylee.api.controller;

import com.shaylee.business.gateway.factory.RouteDefinitionFactory;
import com.shaylee.business.gateway.factory.SysRouteConfFactory;
import com.shaylee.business.gateway.manager.entity.SysRouteConfEntity;
import com.shaylee.business.gateway.manager.service.SysRouteConfServce;
import com.shaylee.common.core.base.result.Result;
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
    private SysRouteConfServce sysRouteConfServce;

    @RequestMapping("/save")
    public Result save() {
        List<RouteDefinition> routeDefinitionList = RouteDefinitionFactory.getRouteDefinitionList();
        List<SysRouteConfEntity> sysRouteConfEntities = new ArrayList<>();
        for (RouteDefinition routeDefinition : routeDefinitionList) {
            sysRouteConfEntities.add(SysRouteConfFactory.buildSysRouteConfEntity(routeDefinition));
        }
        sysRouteConfServce.batchInsert(sysRouteConfEntities);
        return Result.success();
    }

    @RequestMapping("/list")
    public Result list() {
        List<SysRouteConfEntity> sysRouteConfEntityList = sysRouteConfServce.queryAll();
        return Result.data(sysRouteConfEntityList);
    }
}