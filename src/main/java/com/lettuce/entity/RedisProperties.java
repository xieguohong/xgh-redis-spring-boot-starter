package com.lettuce.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author XieGuoHong
 * @description redis属性基础配置
 * @date 2020/3/14 2:51 下午
 */
@Data
@ConfigurationProperties(prefix = "spring.xgh.redis")
public class RedisProperties {
    private int database = 0;
    private String url;
    private String host = "localhost";
    private String password;
    private int port = 6379;
}
