package com.lettuce.connectionfactory;

import com.lettuce.entity.RedisProperties;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author XieGuoHong
 * @description lettuce连接工厂配置类
 * @date 2020/3/14 11:51 上午
 */
public class LettuceConnectionFactory {

    private RedisProperties redisProperties;

    public LettuceConnectionFactory(RedisProperties redisProperties){
        this.redisProperties =  redisProperties;
    }

    public RedisClient lettuceRedisClient(){
        //创建单机连接的连接信息
        RedisURI redisUri = RedisURI.builder()
            .withHost(redisProperties.getHost())
            .withPort(redisProperties.getPort())
            .withDatabase(redisProperties.getDatabase())
            .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
            .build();

        return RedisClient.create(redisUri);
    }

}
