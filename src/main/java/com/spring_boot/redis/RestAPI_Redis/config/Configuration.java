package com.spring_boot.redis.RestAPI_Redis.config;


import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@org.springframework.context.annotation.Configuration
public class Configuration {
    //define redis-template for crud operation.

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        //creating an instance of RedisTemplate
        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
        //Setting Redis connection factory.
        redisTemplate.setConnectionFactory(factory);
        //Setting key serialization
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //Setting value serialization
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
}
