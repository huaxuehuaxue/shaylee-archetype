package com.shaylee.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 路由配置表(SysRouteConf)实体类
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-24
 */
@Data
public class SysRouteConfDTO implements Serializable {
    private static final long serialVersionUID = -31333469256676509L;

    /**
     * 数据ID
     */
    private Long id;

    /**
     * 路由名称
     */
    private String routeName;

    /**
     * 路由ID
     */
    private String routeId;

    /**
     * 断言
     */
    private String predicates;

    /**
     * 过滤器
     */
    private String filters;

    /**
     * 资源名称
     */
    private String uri;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除标志(0正常 1删除)
     */
    private Integer delFlag;

}