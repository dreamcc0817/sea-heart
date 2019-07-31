package com.dreamcc.common.log.event;

import com.dreamcc.upms.api.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.log.event
 * @Description: 系统事件日志
 * @Author: dreamcc
 * @Date: 2019/7/31 15:25
 * @Version: V1.0
 */
public class SysLogEvent extends ApplicationEvent {
	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public SysLogEvent(SysLog source) {
		super(source);
	}
}
