package com.shaylee.common.redis.constant;

/**
 * Title: 缓存时间
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-04-06
 */
public interface CacheTime {

    /**  默认过期时长为24小时，单位：秒 */
    long DEFAULT_EXPIRE = 60 * 60 * 24L;
    /**  过期时长为0.5小时，单位：秒 */
    long HOUR_HALF_EXPIRE = 30 * 60L;
    /**  过期时长为1小时，单位：秒 */
    long HOUR_ONE_EXPIRE = 60 * 60L;
    /**  过期时长为6小时，单位：秒 */
    long HOUR_SIX_EXPIRE = 60 * 60 * 6L;
    /**  不设置过期时长 */
    long NOT_EXPIRE = -1L;
}
