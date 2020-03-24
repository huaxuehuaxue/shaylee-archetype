package com.shaylee.common.datasource.utils;

import tk.mybatis.mapper.genid.GenId;

/**
 * Title: BaseMapper单插入ID为NULL解决
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-03-09
 */
public class ShardingKeyGen implements GenId<Long> {
    @Override
    public Long genId(String table, String column) {
        return null;
    }
}
