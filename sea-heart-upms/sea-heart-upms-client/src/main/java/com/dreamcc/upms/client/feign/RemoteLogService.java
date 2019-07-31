package com.dreamcc.upms.client.feign;

import com.dreamcc.common.core.constant.SecurityConstants;
import com.dreamcc.common.core.constant.ServiceNameConstants;
import com.dreamcc.common.core.util.R;
import com.dreamcc.upms.api.entity.SysLog;
import com.dreamcc.upms.client.feign.factory.RemoteLogServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.client.feign
 * @Description: 日志调用
 * @Author: dreamcc
 * @Date: 2019/7/31 15:04
 * @Version: V1.0
 */
@FeignClient(contextId = "remoteLogService", value = ServiceNameConstants.UMPS_SERVICE, fallbackFactory = RemoteLogServiceFallbackFactory.class)
public interface RemoteLogService {

	/**
	 * 保存日志
	 *
	 * @param sysLog 日志实体
	 * @param from   内部调用标志
	 * @return
	 */
	R<Boolean> saveLog(@RequestBody SysLog sysLog, @RequestHeader(SecurityConstants.FROM) String from);
}
