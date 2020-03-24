package com.shaylee.business.gateway.manager.service;

import com.shaylee.business.gateway.manager.entity.SysRouteConfEntity;

import java.util.List;

/**
 * 路由配置表(SysRouteConf)服务层
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-24
 */
public interface SysRouteConfServce {

    /**
     * 根据ID查询数据
     *
     * @return 实例对象
     */
    SysRouteConfEntity queryById(Long id);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<SysRouteConfEntity> queryAll();

    /**
     * 新增数据
     *
     * @param sysRouteConfEntity 实例对象
     */
    void insert(SysRouteConfEntity sysRouteConfEntity);

    /**
     * 批量新增数据
     *
     * @param sysRouteConfEntityList 实例对象列表
     */
    void batchInsert(List<SysRouteConfEntity> sysRouteConfEntityList);

    /**
     * 修改数据
     *
     * @param sysRouteConfEntity 实例对象
     */
    void update(SysRouteConfEntity sysRouteConfEntity);

    /**
     * 通过主键逻辑删除数据
     *
     * @param id 主键
     */
    void deleteById(Long id);

    /**
     * 通过routeId逻辑删除数据
     *
     * @param routeId 路由ID
     */
    void deleteByRouteId(String routeId);
}
