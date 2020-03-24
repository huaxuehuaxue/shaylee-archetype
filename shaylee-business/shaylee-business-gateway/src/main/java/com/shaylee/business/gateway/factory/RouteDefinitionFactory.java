package com.shaylee.business.gateway.factory;

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

    public static List<RouteDefinition> getRouteDefinitionList() {
        List<RouteDefinition> routeDefinitions = new LinkedList<>();
        routeDefinitions.add(
                buildRouteDefinition("shaylee-api-oss", "lb://shaylee-api-oss", "/api/oss/**"));
        routeDefinitions.add(
                buildRouteDefinition("shaylee-api", "lb://shaylee-api", "/api/**"));
        return routeDefinitions;
    }

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
}
