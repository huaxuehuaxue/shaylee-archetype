package com.shaylee.common.datasource.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.shaylee.common.core.base.constant.BaseConstant;
import com.shaylee.common.datasource.entity.BaseEntity;
import com.shaylee.common.datasource.mapper.BaseMapper;
import com.shaylee.common.datasource.service.BaseService;
import com.shaylee.common.datasource.utils.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Title: 基础服务接口实现
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-04-12
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> implements BaseService<T> {
    @Autowired
    protected M baseMapper;

    @Override
    public T selectById(Serializable id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectList(T entity) {
        return baseMapper.select(entity);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public int selectCount(T entity) {
        return baseMapper.selectCount(entity);
    }

    @Override
    public PageInfo<T> selectPage(T entity, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(() -> baseMapper.select(entity));
    }

    @Override
    public boolean insert(T entity) {
        return SqlUtil.retBool(baseMapper.insertSelective(entity));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBatch(List<T> entityList) {
        return this.insertBatch(entityList, 100);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBatch(List<T> entityList, int batchSize) {
        if (CollectionUtils.isEmpty(entityList)) {
            throw new IllegalArgumentException("Error: entityList must not be empty");
        }
        if (entityList.size() >= batchSize) {
            baseMapper.insertList(entityList);
            return true;
        }
        // Guava对集合进行分割
        List<List<T>> partitionList = Lists.partition(entityList, batchSize);
        partitionList.forEach(anEntityList -> baseMapper.insertList(anEntityList));
        return true;
    }

    @Override
    public boolean updateById(T entity) {
        return SqlUtil.retBool(baseMapper.updateByPrimaryKeySelective(entity));
    }

    @Override
    public boolean deleteById(Serializable id) {
        return SqlUtil.delBool(baseMapper.deleteByPrimaryKey(id));
    }

    @Override
    public boolean deleteBatchByIds(Collection<? extends Serializable> idList) {
        return SqlUtil.delBool(baseMapper.deleteByIds(Joiner.on(",").join(idList)));
    }

    @Override
    public boolean deleteLogicById(T entity) {
        entity.setDelFlag(BaseConstant.DEL_FLAG_DELETE);
        return this.updateById(entity);
    }

    @Override
    public boolean deleteLogicById(Serializable id, Class<T> clazz) {
        try {
            T entity = clazz.newInstance();
            entity.setDelFlag(BaseConstant.DEL_FLAG_DELETE);
            Example example = Example.builder(clazz)
                    .where(Sqls.custom().andEqualTo("id", id))
                    .build();
            return SqlUtil.delBool(baseMapper.updateByExampleSelective(entity, example));
        } catch (IllegalAccessException | InstantiationException ignored) {
            return false;
        }
    }

    @Override
    public boolean deleteLogicBatchByIds(Collection<? extends Serializable> idList, Class<T> clazz) {
        try {
            T entity = clazz.newInstance();
            entity.setDelFlag(BaseConstant.DEL_FLAG_DELETE);
            Example example = Example.builder(clazz)
                    .where(Sqls.custom().andIn("id", idList))
                    .build();
            return SqlUtil.delBool(baseMapper.updateByExampleSelective(entity, example));
        } catch (IllegalAccessException | InstantiationException ignored) {
            return false;
        }
    }
}
