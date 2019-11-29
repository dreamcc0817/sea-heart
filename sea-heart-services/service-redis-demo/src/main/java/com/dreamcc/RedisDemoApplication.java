package com.dreamcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/11/8 9:29
 * @Version: V1.0
 */
@SpringBootApplication
@EnableCaching
public class RedisDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class,args);
	}
}
