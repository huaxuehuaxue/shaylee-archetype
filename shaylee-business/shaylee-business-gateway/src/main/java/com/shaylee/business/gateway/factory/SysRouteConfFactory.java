package com.shaylee.business.gateway.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaylee.business.gateway.manager.entity.SysRouteConfEntity;
import com.shaylee.common.core.base.constant.BaseConstant;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.Date;
import java.util.UUID;

/**
 * 路由配置表(SysRouteConf)实体工厂
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-24
 */
public class SysRouteConfFactory {

    private static ObjectMapper objectMapper;

    static {
        SysRouteConfFactory.objectMapper = new ObjectMapper();
    }

    public static SysRouteConfEntity buildSysRouteConfEntity(RouteDefinition routeDefinition) {
        SysRouteConfEntity sysRouteConfEntity = new SysRouteConfEntity();
        sysRouteConfEntity.setRouteId(routeDefinition.getId());
        try {
            sysRouteConfEntity.setFilters(objectMapper.writeValueAsString(routeDefinition.getFilters()));
            sysRouteConfEntity.setPredicates(objectMapper.writeValueAsString(routeDefinition.getPredicates()));
            sysRouteConfEntity.setUri(routeDefinition.getUri().toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        sysRouteConfEntity.setRouteName(UUID.randomUUID().toString().replaceAll("-", ""));
        sysRouteConfEntity.setSort(0);
        sysRouteConfEntity.setCreateTime(new Date());
        sysRouteConfEntity.setUpdateTime(new Date());
        sysRouteConfEntity.setDelFlag(BaseConstant.DEL_FLAG_NORMAL);
        return sysRouteConfEntity;
    }
}
