package com.example.springboot;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;

/**
 * @Cacheable 先缓存中查找方法的返回值，有直接返回，没有调用方法，存入缓存
 * @CachePut 始终调用方法把方法返回值放入缓存
 * @CacheEvict 清除缓存
 */

/**
 * 缓存配置
 *
 * @author hp
 * @data 2017/11/3
 */
@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public EhCacheManagerFactoryBean enCache() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxWaitMillis(10000);
        return jedisPoolConfig;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("192.168.0.100");
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setPassword("root");
        jedisConnectionFactory.afterPropertiesSet();
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public CompositeCacheManager cacheManager(net.sf.ehcache.CacheManager enCache,
                                              RedisTemplate<String, Object> redisTemplate) {
        CompositeCacheManager compositeCacheManager = new CompositeCacheManager();
        ArrayList<CacheManager> cacheManagers = new ArrayList<>();
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setDefaultExpiration(60 * 10);
        cacheManagers.add(redisCacheManager);
        cacheManagers.add(new EhCacheCacheManager(enCache));
        compositeCacheManager.setCacheManagers(cacheManagers);

        return compositeCacheManager;
    }
}
