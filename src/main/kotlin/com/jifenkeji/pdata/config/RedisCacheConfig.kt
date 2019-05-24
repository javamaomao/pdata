package com.gloyray.mgr.config

import org.springframework.cache.annotation.CachingConfigurerSupport
import org.springframework.context.annotation.Configuration

/**
 *
 * redis缓存配置
 * Created by zhezhiyong@163.com on 2017/9/21.
 */
@Configuration
//@EnableCaching
class RedisConfig : CachingConfigurerSupport() {
//
//    @Bean
//    fun KeyGenerator(): KeyGenerator {
//        return KeyGenerator { target, method, params ->
//            val sb = StringBuilder()
//            sb.append(target.javaClass.name)
//            sb.append(method.name)
//            for (obj in params) {
//                sb.append(obj.toString())
//            }
//            sb.toString
//        }
//    }
/*
    //缓存管理器
    @Bean
    fun cacheManager(connectionFactory: RedisConnectionFactory): CacheManager {
        //Admin信息缓存配置
        val AdminCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(10)).disableCachingNullValues().prefixKeysWith("Admin")
        val redisCacheConfigurationMap = HashMap<String, RedisCacheConfiguration>()
        redisCacheConfigurationMap.put("Admin", AdminCacheConfiguration)
        //初始化一个RedisCacheWriter
        val redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory)


        //        设置CacheManager的值序列化方式为JdkSerializationRedisSerializer,但其实RedisCacheConfiguration默认就是使用StringRedisSerializer序列化key，JdkSerializationRedisSerializer序列化value,所以以下注释代码为默认实现
        //        ClassLoader loader = this.getClass().getClassLoader();
        //        JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer(loader);
        //        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(jdkSerializer);
        //        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);

        val defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()

        //设置默认超过期时间是30秒
        defaultCacheConfig.entryTtl(Duration.ofDays(1))
        //初始化RedisCacheManager
        return RedisCacheManager(redisCacheWriter, defaultCacheConfig, redisCacheConfigurationMap)
    }
    */
//
//    @Bean
//    fun redisTemplate(factory: RedisConnectionFactory): RedisTemplate<String, String> {
//        val template = StringRedisTemplate(factory)
//        val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer(Any::class.java)
//        val om = ObjectMapper()
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
//        jackson2JsonRedisSerializer.setObjectMapper(om)
//        template.valueSerializer = jackson2JsonRedisSerializer
//        template.afterPropertiesSet()
//        return template
//    }
}