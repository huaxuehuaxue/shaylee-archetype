package com.shaylee.common.gateway.utils;

import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 路由缓存工具类
 * Project: shaylee-gateway
 *
 * @author Adrian
 * @date 2020-03-22
 */
@Deprecated
public class RouteCacheHolder {

	private static List<RouteDefinition> routeDefinitions = new LinkedList<>();

	/**
	 * 获取内存的全部对象
	 *
	 * @return routeList
	 */
	public static List<RouteDefinition> getRouteList() {
		return routeDefinitions;
	}

	/**
	 * 更新内存
	 *
	 * @param routeList 缓存列表
	 */
	public static void setRouteList(List<RouteDefinition> routeList) {
		routeDefinitions = routeList;
	}

	/**
	 * 清空内存
	 */
	public static void removeRouteList() {
		routeDefinitions = new LinkedList<>();
	}

}
