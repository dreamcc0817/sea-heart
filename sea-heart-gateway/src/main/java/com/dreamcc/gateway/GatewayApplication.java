package com.dreamcc.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway
 * @Description: 网关启动类
 * @Author: dreamcc
 * @Date: 2019/7/24 14:48
 * @Version: V1.0
 */
@SpringBootApplication
@MapperScan("com.dreamcc.gateway.dao")
public class GatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
