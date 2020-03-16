package com.lettuce.autoconfig;

import com.lettuce.connectionfactory.LettuceConnectionFactory;
import com.lettuce.entity.RedisProperties;
import com.lettuce.biz.XghRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author XieGuoHong
 * @description
 * @date 2020/3/14 4:56 下午
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
@ConditionalOnClass(LettuceConnectionFactory.class)
@ConditionalOnProperty(prefix = "spring.xgh.redis", value = "enabled", matchIfMissing = true)
public class AutoConfigurationConnectionFactory {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    @ConditionalOnClass(LettuceConnectionFactory.class)
    public LettuceConnectionFactory getLettuceConnectionFactory(){
        return new LettuceConnectionFactory(redisProperties);
    }

    @Bean
    public XghRedisTemplate getXghRedisTemplate(){
        return new XghRedisTemplate(getLettuceConnectionFactory().lettuceRedisClient());
    }
}
