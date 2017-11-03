package com.example.springboot;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

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
    public EhCacheManagerFactoryBean ehcache(){
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }

    @Bean
    public EhCacheCacheManager cacheManager(CacheManager cm){
        return new EhCacheCacheManager(cm);
    }
}
