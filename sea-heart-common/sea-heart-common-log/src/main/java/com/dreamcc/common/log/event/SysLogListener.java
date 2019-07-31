package com.dreamcc.common.log.event;

import com.dreamcc.common.core.constant.SecurityConstants;
import com.dreamcc.upms.api.entity.SysLog;
import com.dreamcc.upms.client.feign.RemoteLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.log.event
 * @Description: 异步监听日志事件
 * @Author: dreamcc
 * @Date: 2019/7/31 15:27
 * @Version: V1.0
 */
@Slf4j
@AllArgsConstructor
public class SysLogListener {

	private RemoteLogService remoteLogService;

	/**
	 * 监听日志事件，调用远程服务保存日志
	 *
	 * @param event
	 */
	@Async
	@Order
	@EventListener(SysLogEvent.class)
	public void saveSysLog(SysLogEvent event) {
		SysLog sysLog = (SysLog) event.getSource();
		remoteLogService.saveLog(sysLog, SecurityConstants.FROM_IN);
	}
}
