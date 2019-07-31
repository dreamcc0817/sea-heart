package com.dreamcc.upms.client.feign.factory;

import com.dreamcc.upms.client.feign.RemoteLogService;
import com.dreamcc.upms.client.feign.fallback.RemoteLogServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.client.feign.factory
 * @Description: 日志调用工厂类
 * @Author: dreamcc
 * @Date: 2019/7/31 15:12
 * @Version: V1.0
 */
@Component
public class RemoteLogServiceFallbackFactory implements FallbackFactory<RemoteLogService> {
	@Override
	public RemoteLogService create(Throwable cause) {
		RemoteLogServiceFallbackImpl remoteLogServiceFallback = new RemoteLogServiceFallbackImpl();
		remoteLogServiceFallback.setCause(cause);
		return remoteLogServiceFallback;
	}
}
