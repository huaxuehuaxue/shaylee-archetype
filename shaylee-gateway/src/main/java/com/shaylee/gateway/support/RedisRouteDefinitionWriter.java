package com.shaylee.gateway.support;

import com.shaylee.business.gateway.factory.RouteDefinitionFactory;
import com.shaylee.business.gateway.manager.entity.SysRouteConfEntity;
import com.shaylee.business.gateway.manager.service.SysRouteConfServce;
import com.shaylee.common.gateway.utils.RouteCacheHolder;
import com.shaylee.business.gateway.factory.SysRouteConfFactory;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Title: redis 保存路由信息，优先级比配置文件高
 * Project: shaylee-gateway
 *
 * @author Adrian
 * @date 2020-03-22
 */
@Component
public class RedisRouteDefinitionWriter implements RouteDefinitionRepository {
	private static Logger logger = LoggerFactory.getLogger(RedisRouteDefinitionWriter.class);
	@Autowired
	private SysRouteConfServce sysRouteConfServce;

	@Override
	public Mono<Void> save(Mono<RouteDefinition> route) {
		return route.flatMap(r -> {
			logger.info("保存路由信息{}", r);
			SysRouteConfEntity sysRouteConfEntity = SysRouteConfFactory.buildSysRouteConfEntity(r);
			sysRouteConfServce.insert(sysRouteConfEntity);
			RouteCacheHolder.removeRouteList();
			return Mono.empty();
		});
	}

	@Override
	public Mono<Void> delete(Mono<String> routeId) {
		routeId.subscribe(id -> {
			logger.info("删除路由信息{}", id);
			sysRouteConfServce.deleteByRouteId(id);
		});
		RouteCacheHolder.removeRouteList();
		return Mono.empty();
	}

	/**
	 * 动态路由入口
	 * <p>
	 * 1. 先从内存中获取
	 * 2. 为空加载Redis中数据
	 * 3. 更新内存
	 *
	 * @return
	 */
	@Override
	public Flux<RouteDefinition> getRouteDefinitions() {
		List<RouteDefinition> routeList = RouteCacheHolder.getRouteList();
		if (CollectionUtils.isNotEmpty(routeList)) {
			logger.debug("内存 中路由定义条数： {}， {}", routeList.size(), routeList);
			return Flux.fromIterable(routeList);
		}

		List<SysRouteConfEntity> routeConfEntityList = sysRouteConfServce.queryAll();
		List<RouteDefinition> values = RouteDefinitionFactory.buildRouteDefinition(routeConfEntityList);

		RouteCacheHolder.setRouteList(values);
		return Flux.fromIterable(values);
	}
}