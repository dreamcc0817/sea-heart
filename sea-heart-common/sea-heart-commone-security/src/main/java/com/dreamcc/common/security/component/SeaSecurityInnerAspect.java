package com.dreamcc.common.security.component;

import cn.hutool.core.util.StrUtil;
import com.dreamcc.common.core.constant.SecurityConstants;
import com.dreamcc.common.security.annotation.Inner;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.security.component
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/7/30 16:52
 * @Version: V1.0
 */
@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class SeaSecurityInnerAspect {

	private HttpServletRequest request;

	@SneakyThrows
	@Around("@annotation(inner)")
	public Object around(ProceedingJoinPoint point, Inner inner){
		String header = request.getHeader(SecurityConstants.FROM);
		if(inner.value() && !StrUtil.equals(SecurityConstants.FROM_IN,header)){
			log.warn("访问接口 {} 没有权限", point.getSignature().getName());
			throw new AccessDeniedException("Access is denied");
		}
		return point.proceed();
	}
}
