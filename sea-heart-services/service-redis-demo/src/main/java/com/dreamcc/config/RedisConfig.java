package com.dreamcc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.config
 * @Description: Redis配置类
 * @Author: dreamcc
 * @Date: 2019/11/8 9:30
 * @Version: V1.0
 */
@Configuration
public class RedisConfig {

	private RedisConnectionFactory connectionFactory;

	@Bean("redisConnectionFactory")
	public RedisConnectionFactory initRedisConnectionFactory(){
		if(this.connectionFactory != null){
			return this.connectionFactory;
		}
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		//最大空闲数
		poolConfig.setMaxIdle(30);
		//最大连接数
		poolConfig.setMaxTotal(50);
		//最大等待毫秒数
		poolConfig.setMaxWaitMillis(2000);
		//创建Jedis连接工厂
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
		//获取Redis配置
		RedisStandaloneConfiguration standaloneConfiguration = connectionFactory.getStandaloneConfiguration();
		standaloneConfiguration.setHostName("localhost");
		standaloneConfiguration.setPort(6379);
		this.connectionFactory = connectionFactory;
		return connectionFactory;
	}

	@Bean("myRedisTemplate")
	public RedisTemplate<Object,Object> initRedisTemplate(){
		RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(initRedisConnectionFactory());
		return redisTemplate;
	}
}
