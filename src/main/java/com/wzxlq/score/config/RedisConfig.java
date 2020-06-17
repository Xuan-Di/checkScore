package com.wzxlq.score.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;


@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    //缓存管理器
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory factory) {
//        RedisCacheManager cacheManager = RedisCacheManager.builder(factory).build();
//        return cacheManager;
//    }
    @Bean
    CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        /* 默认配置， 默认超时时间为120s */
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration
                .ofSeconds(120L)).disableCachingNullValues();
        RedisCacheManager cacheManager = RedisCacheManager.builder(RedisCacheWriter.lockingRedisCacheWriter
                (connectionFactory)).cacheDefaults(defaultCacheConfig).transactionAware().build();
        return cacheManager;
    }
    //自定义缓存key生成策略
    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, java.lang.reflect.Method method, Object... params) {
                StringBuffer sb = new StringBuffer();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for(Object obj:params){
                    sb.append(obj.toString());
                }
                System.out.println("调用Redis生成key："+sb.toString());
                return sb.toString();
            }
        };
    }
}
