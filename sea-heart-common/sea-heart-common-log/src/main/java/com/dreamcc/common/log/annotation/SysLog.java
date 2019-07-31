package com.dreamcc.common.log.annotation;

import java.lang.annotation.*;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.log.annotation
 * @Description: 操作日志注解
 * @Author: dreamcc
 * @Date: 2019/7/31 15:38
 * @Version: V1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	/**
	 * 描述
	 *
	 * @return
	 */
	String value();
}
