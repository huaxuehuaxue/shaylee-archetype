package com.shaylee.common.redis.config;

import com.shaylee.common.redis.constant.CacheTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.convert.DurationStyle;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Title: Redis配置类
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-03-01
 */
@EnableCaching
@Configuration
public class RedisConfig {

    @Resource
    private RedisConnectionFactory factory;

    /**
     *  设置 redis 数据默认过期时间
     *  设置 @Cacheable 序列化方式
     *  Cacheable拦截器 org.springframework.cache.interceptor.CacheInterceptor
     */
    @Bean
    public CacheManager cacheManager() {
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
                .entryTtl(Duration.ofSeconds(CacheTime.HOUR_HALF_EXPIRE));
        return new RedisExtendCacheManager(RedisCacheWriter.nonLockingRedisCacheWriter(factory), defaultCacheConfig);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        redisTemplate.setHashKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

    /**
     * Spring Cache 扩展缓存注解支持失效时间TTL
     *
     * @author Adrian
     * <p>
     * cachename = xx#ttl
     */
    public static class RedisExtendCacheManager extends RedisCacheManager {
        private static final String SPLIT_FLAG = "#";
        private static final int CACHE_LENGTH = 2;

        public RedisExtendCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration) {
            super(cacheWriter, defaultCacheConfiguration);
        }

        @Override
        protected RedisCache createRedisCache(String name, @Nullable RedisCacheConfiguration cacheConfig) {
            if (StringUtils.isBlank(name) || !name.contains(SPLIT_FLAG)) {
                return super.createRedisCache(name, cacheConfig);
            }

            String[] cacheArray = name.split(SPLIT_FLAG);
            if (cacheArray.length < CACHE_LENGTH) {
                return super.createRedisCache(name, cacheConfig);
            }

            if (cacheConfig != null) {
                // 解析TTL，注意单位我此处用的是秒，而非毫秒
                Duration duration = DurationStyle.detectAndParse(cacheArray[1], ChronoUnit.SECONDS);
                cacheConfig = cacheConfig.entryTtl(duration);
            }
            return super.createRedisCache(name, cacheConfig);
        }
    }

}
