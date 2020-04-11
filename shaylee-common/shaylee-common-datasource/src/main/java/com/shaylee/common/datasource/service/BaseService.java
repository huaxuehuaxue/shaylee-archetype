package com.shaylee.common.datasource.service;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Title: 基础服务接口，所有Service接口都要继承(继承后即可获得BaseMapper的CRUD功能)
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-04-12
 */
public interface BaseService<T> {

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     * @return 查询结果
     */
    T selectById(Serializable id);

    /**
     * <p>
     * 条件查询
     * </p>
     *
     * @param entity 实体
     * @return 查询结果
     */
    List<T> selectList(T entity);

    /**
     * <p>
     * 查询所有
     * </p>
     *
     * @return 查询结果
     */
    List<T> selectAll();

    /**
     * <p>
     * 查询数据量
     * </p>
     *
     * @return 查询结果
     */
    int selectCount(T entity);

    /**
     * <p>
     * 分页条件查询
     * </p>
     *
     * @param entity    查询实例
     * @param pageNum   页码
     * @param pageSize  每页数据量
     * @return 查询结果
     */
    PageInfo<T> selectPage(T entity, int pageNum, int pageSize);

    /**
     * <p>
     * 插入一条记录（选择字段，策略插入）
     * </p>
     *
     * @param entity 实体对象
     */
    boolean insert(T entity);

    /**
     * <p>
     * 插入（批量）
     * </p>
     *
     * @param entityList 实体对象集合
     */
    boolean insertBatch(List<T> entityList);

    /**
     * <p>
     * 插入（批量）
     * </p>
     *
     * @param entityList 实体对象集合
     * @param batchSize  插入批次数量
     * @return 插入结果
     */
    boolean insertBatch(List<T> entityList, int batchSize);

    /**
     * <p>
     * 根据 ID 选择修改
     * </p>
     *
     * @param entity 实体对象
     */
    boolean updateById(T entity);

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     */
    boolean deleteById(Serializable id);

    /**
     * <p>
     * 删除（根据ID 批量删除）
     * </p>
     *
     * @param idList 主键ID列表
     */
    boolean deleteBatchByIds(Collection<? extends Serializable> idList);

    /**
     * <p>
     * 根据 ID 逻辑删除
     * </p>
     *
     * @param entity 实体对象(主键ID)
     */
    boolean deleteLogicById(T entity);

    /**
     * <p>
     * 根据 ID 逻辑删除
     * </p>
     *
     * @param id 主键ID
     */
    boolean deleteLogicById(Serializable id, Class<T> clazz);

    /**
     * <p>
     * 逻辑删除（根据ID 批量逻辑删除）
     * </p>
     *
     * @param idList 主键ID列表
     */
    boolean deleteLogicBatchByIds(Collection<? extends Serializable> idList, Class<T> clazz);
}
