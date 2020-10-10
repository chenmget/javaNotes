package com.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-30 14:42
 **/
@Configuration
public class RedissonConfig {

    //单节点
    @Bean
    public RedissonClient redissonSingleClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
