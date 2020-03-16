package com.lettuce.biz;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.stereotype.Component;

/**
 * @author XieGuoHong
 * @description 访问Redis数据模版
 * @date 2020/3/14 4:40 下午
 */
@Component
public class XghRedisTemplate {

    private StatefulRedisConnection<String,String> statefulRedisConnection;

    private RedisCommands<String,String> redisCommands;

    public XghRedisTemplate(RedisClient lettuceRedisClient){
        this.statefulRedisConnection = lettuceRedisClient.connect();
        this.redisCommands = this.statefulRedisConnection.sync();
    }

    public String setValue(String key, String value){
        return this.redisCommands.set(key,value);
    }

    public String getValue(String key){
        return (String)this.redisCommands.get(key);
    }

}
