package com.shaylee.business.gateway.factory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaylee.business.gateway.manager.entity.SysRouteConfEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 路由定义信息工厂
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-24
 */
public class RouteDefinitionFactory {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Deprecated
    public static List<RouteDefinition> getRouteDefinitionList() {
        List<RouteDefinition> routeDefinitions = new LinkedList<>();
        routeDefinitions.add(
                buildRouteDefinition("shaylee-api-oss", "lb://shaylee-api-oss", "/api/oss/**"));
        routeDefinitions.add(
                buildRouteDefinition("shaylee-api", "lb://shaylee-api", "/api/**"));
        return routeDefinitions;
    }

    @Deprecated
    public static RouteDefinition buildRouteDefinition(String id, String uri, String path) {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(id);
        routeDefinition.setUri(URI.create(uri));
        List<PredicateDefinition> predicateDefinitionList = new ArrayList<>();
        PredicateDefinition predicateDefinition = new PredicateDefinition();
        predicateDefinition.setName("Path");
        Map<String, String> args = new HashMap<>(1);
        args.put("_genkey_0", path);
        predicateDefinition.setArgs(args);
        predicateDefinitionList.add(predicateDefinition);
        routeDefinition.setPredicates(predicateDefinitionList);
        return routeDefinition;
    }

    public static RouteDefinition buildRouteDefinition(String id, String uri, String predicates, String filters, Integer order) {
        RouteDefinition routeDefinition = new RouteDefinition();
        // 设置ID
        routeDefinition.setId(id);
        // 设置URI
        routeDefinition.setUri(URI.create(uri));
        // 设置Order
        routeDefinition.setOrder(order);
        try {
            // 设置Predicates [{"args": {"_genkey_0": "/api/oss/**"}, "name": "Path"}]
            if (StringUtils.isNotBlank(predicates)) {
                List<PredicateDefinition> predicateDefinitionList = objectMapper.readValue(predicates, new TypeReference<List<PredicateDefinition>>(){});
                routeDefinition.setPredicates(predicateDefinitionList);
            }
            // 设置filters [{"args": {"key-resolver": "#{@remoteAddrKeyResolver}", "redis-rate-limiter.burstCapacity": "1000", "redis-rate-limiter.replenishRate": "1000"}, "name": "RequestRateLimiter"}]
            if (StringUtils.isNotBlank(filters)) {
                List<FilterDefinition> filterDefinitionList = objectMapper.readValue(filters, new TypeReference<List<FilterDefinition>>(){});
                routeDefinition.setFilters(filterDefinitionList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        routeDefinition.setFilters(null);
        return routeDefinition;
    }

    public static List<RouteDefinition> buildRouteDefinition(List<SysRouteConfEntity> sysRouteConfEntity) {
        List<RouteDefinition> routeDefinitions = new LinkedList<>();
        sysRouteConfEntity.forEach(entity -> routeDefinitions.add(RouteDefinitionFactory.buildRouteDefinition(entity)));
        return routeDefinitions;
    }

    public static RouteDefinition buildRouteDefinition(SysRouteConfEntity sysRouteConfEntity) {
        return RouteDefinitionFactory.buildRouteDefinition(sysRouteConfEntity.getRouteId(),
                sysRouteConfEntity.getUri(),
                sysRouteConfEntity.getPredicates(),
                sysRouteConfEntity.getFilters(),
                sysRouteConfEntity.getOrder());
    }
}
