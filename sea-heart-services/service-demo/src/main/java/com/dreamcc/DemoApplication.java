package com.dreamcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/7/29 13:37
 * @Version: V1.0
 */
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class,args);
	}

	@Configuration
	public class WebMvcConfig implements WebMvcConfigurer{

	}

	@Configuration
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception {
			httpSecurity.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and().authorizeRequests()
					// 所有/trace/user/ 的所有请求 都放行
					.antMatchers("/trace/users/**").permitAll()
					// swagger start
					.antMatchers("/swagger-ui.html").permitAll()
					.antMatchers("/swagger-resources/**").permitAll()
					.antMatchers("/images/**").permitAll()
					.antMatchers("/webjars/**").permitAll()
					.antMatchers("/v2/api-docs").permitAll()
					.antMatchers("/configuration/ui").permitAll()
					.antMatchers("/configuration/security").permitAll()
					// swagger end
					// 所有请求都需要认证
					.anyRequest().authenticated();
			httpSecurity.headers().cacheControl();
			httpSecurity.csrf().disable();
		}
	}

}
