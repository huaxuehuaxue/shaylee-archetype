package com.shaylee.business.gateway.manager.service.impl;

import com.shaylee.business.gateway.manager.dao.SysRouteConfDao;
import com.shaylee.business.gateway.manager.entity.SysRouteConfEntity;
import com.shaylee.business.gateway.manager.service.SysRouteConfServce;
import com.shaylee.common.core.base.constant.BaseConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 路由配置表(SysRouteConf)服务实现层
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-24
 */
@Service
public class SysRouteConfServceImpl implements SysRouteConfServce {

    @Autowired
    private SysRouteConfDao sysRouteConfDao;

    @Override
    public SysRouteConfEntity queryById(Long id) {
        SysRouteConfEntity sysRouteConfEntity = new SysRouteConfEntity();
        sysRouteConfEntity.setId(id);
        sysRouteConfEntity.setDelFlag(BaseConstant.DEL_FLAG_NORMAL);
        return sysRouteConfDao.selectByPrimaryKey(sysRouteConfEntity);
    }

    @Override
    public List<SysRouteConfEntity> queryAll() {
        return sysRouteConfDao.selectAll();
    }

    @Override
    public void insert(SysRouteConfEntity sysRouteConfEntity) {
        sysRouteConfDao.insertSelective(sysRouteConfEntity);
    }

    @Override
    public void update(SysRouteConfEntity sysRouteConfEntity) {
        sysRouteConfDao.updateByPrimaryKeySelective(sysRouteConfEntity);
    }

    @Override
    public Boolean deleteById(Long id) {
        SysRouteConfEntity sysRouteConfEntity = new SysRouteConfEntity();
        sysRouteConfEntity.setId(id);
        sysRouteConfEntity.setDelFlag(BaseConstant.DEL_FLAG_NORMAL);
        return sysRouteConfDao.deleteByPrimaryKey(sysRouteConfEntity) > 0;
    }
}
