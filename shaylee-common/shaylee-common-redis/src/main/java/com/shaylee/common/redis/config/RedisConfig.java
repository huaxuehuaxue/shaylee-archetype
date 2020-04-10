package com.shaylee.common.redis.config;

import com.shaylee.common.redis.constant.CacheTime;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

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
        return new RedisExtCacheManager(RedisCacheWriter.nonLockingRedisCacheWriter(factory), defaultCacheConfig);
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
}
