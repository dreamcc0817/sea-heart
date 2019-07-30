package com.dreamcc.common.core.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.core.config
 * @Description: myBatis-Plus插件配置
 * @Author: dreamcc
 * @Date: 2019/7/26 9:12
 * @Version: V1.0
 */
@Configuration
public class MyBatisPlusConfig {

	/**
	 * 分页插件
	 * paginationInterceptor.setLimit(你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制);
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		return paginationInterceptor;
	}
}
