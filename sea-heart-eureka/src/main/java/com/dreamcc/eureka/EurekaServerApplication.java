package com.dreamcc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.eureka
 * @Description: eureka服务启动类
 * @Author: dreamcc
 * @Date: 2019/7/25 10:05
 * @Version: V1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
