package com.dreamcc.common.log.aspect;

import com.dreamcc.common.core.util.SpringContextHolder;
import com.dreamcc.common.log.annotation.SysLog;
import com.dreamcc.common.log.event.SysLogEvent;
import com.dreamcc.common.log.util.SysLogUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.log.aspect
 * @Description: 操作日志使用Spring event 异步入库
 * @Author: dreamcc
 * @Date: 2019/7/31 15:35
 * @Version: V1.0
 */
@Aspect
@Slf4j
public class SysLogAspect {

	@Around("@annotation(sysLog)")
	@SneakyThrows
	public Object around(ProceedingJoinPoint point,SysLog sysLog){
		String className = point.getTarget().getClass().getName();
		String methodName = point.getSignature().getName();
		log.debug("[类名]:{},[方法]:{}", className, methodName);

		com.dreamcc.upms.api.entity.SysLog logVo = SysLogUtils.getSysLog();
		logVo.setTitle(sysLog.value());
		Long startTime = System.currentTimeMillis();
		Object obj = point.proceed();
		Long endTime = System.currentTimeMillis();
		logVo.setTime(endTime - startTime);
		SpringContextHolder.publishEvent(new SysLogEvent(logVo));
		return obj;
	}
}
