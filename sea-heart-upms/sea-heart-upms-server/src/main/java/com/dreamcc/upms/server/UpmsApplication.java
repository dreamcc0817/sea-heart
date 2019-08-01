package com.dreamcc.upms.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/7/29 10:19
 * @Version: V1.0
 */
@SpringBootApplication
@MapperScan("com.dreamcc.upms.server.dao")
public class UpmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(UpmsApplication.class,args);
	}

	@Configuration
	class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
					.anyRequest().permitAll();
		}
	}
}
