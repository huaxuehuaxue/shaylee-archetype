package com.shaylee.business.gateway.manager.service.impl;

import com.shaylee.business.gateway.manager.dao.SysRouteConfDao;
import com.shaylee.business.gateway.manager.entity.SysRouteConfEntity;
import com.shaylee.business.gateway.manager.service.SysRouteConfService;
import com.shaylee.common.core.base.constant.BaseConstant;
import com.shaylee.common.datasource.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
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
public class SysRouteConfServiceImpl extends BaseServiceImpl<SysRouteConfDao, SysRouteConfEntity> implements SysRouteConfService {

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
    @Cacheable(value = "sys:route:conf#30", key = "'queryAll'")
    public List<SysRouteConfEntity> queryAll() {
        return sysRouteConfDao.selectAll();
    }

//    @Override
//    public void insert(SysRouteConfEntity sysRouteConfEntity) {
//        sysRouteConfDao.insertSelective(sysRouteConfEntity);
//    }

    @Override
    public void batchInsert(List<SysRouteConfEntity> sysRouteConfEntityList) {
        // TODO 优化
        for (SysRouteConfEntity sysRouteConfEntity : sysRouteConfEntityList) {
            sysRouteConfDao.insertSelective(sysRouteConfEntity);
        }
    }

    @Override
    public void update(SysRouteConfEntity sysRouteConfEntity) {
        sysRouteConfDao.updateByPrimaryKeySelective(sysRouteConfEntity);
    }

    @Override
    public void deleteById(Long id) {
        SysRouteConfEntity sysRouteConfEntity = new SysRouteConfEntity();
        sysRouteConfEntity.setId(id);
        sysRouteConfEntity.setDelFlag(BaseConstant.DEL_FLAG_NORMAL);
        sysRouteConfEntity = sysRouteConfDao.selectOne(sysRouteConfEntity);
        if (sysRouteConfEntity != null) {
            SysRouteConfEntity temp = new SysRouteConfEntity();
            temp.setId(sysRouteConfEntity.getId());
            temp.setDelFlag(BaseConstant.DEL_FLAG_DELETE);
            sysRouteConfDao.updateByPrimaryKeySelective(temp);
        }
    }

    @Override
    public void deleteByRouteId(String routeId) {
        SysRouteConfEntity sysRouteConfEntity = new SysRouteConfEntity();
        sysRouteConfEntity.setRouteId(routeId);
        sysRouteConfEntity.setDelFlag(BaseConstant.DEL_FLAG_NORMAL);
        sysRouteConfEntity = sysRouteConfDao.selectOne(sysRouteConfEntity);
        if (sysRouteConfEntity != null) {
            SysRouteConfEntity temp = new SysRouteConfEntity();
            temp.setId(sysRouteConfEntity.getId());
            temp.setDelFlag(BaseConstant.DEL_FLAG_DELETE);
            sysRouteConfDao.updateByPrimaryKeySelective(temp);
        }
    }
}
