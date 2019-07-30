package com.dreamcc.common.security.annotation;

import java.lang.annotation.*;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.security
 * @Description: 服务调用不鉴权注解
 * @Author: dreamcc
 * @Date: 2019/7/30 16:44
 * @Version: V1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Inner {

	/**
	 * 是否AOP统一处理
	 *
	 * @return
	 */
	boolean value() default true;

}
