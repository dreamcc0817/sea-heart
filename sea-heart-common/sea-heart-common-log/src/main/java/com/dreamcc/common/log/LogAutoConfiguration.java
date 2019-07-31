package com.dreamcc.common.log;

import com.dreamcc.common.log.aspect.SysLogAspect;
import com.dreamcc.common.log.event.SysLogListener;
import com.dreamcc.upms.client.feign.RemoteLogService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.log
 * @Description: 自动配置类
 * @Author: dreamcc
 * @Date: 2019/7/31 14:51
 * @Version: V1.0
 */
@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {

	/**
	 * 日志远程调用
	 */
	private RemoteLogService remoteLogService;

	/**
	 * 注册日志监听
	 *
	 * @return
	 */
	@Bean
	public SysLogListener sysLogListener() {
		return new SysLogListener(remoteLogService);
	}

	/**
	 * 注册日志切面
	 *
	 * @return
	 */
	@Bean
	public SysLogAspect sysLogAspect() {
		return new SysLogAspect();
	}

}
