package com.dreamcc.common.core.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.core.util
 * @Description: spring工具类
 * @Author: dreamcc
 * @Date: 2019/7/31 16:00
 * @Version: V1.0
 */
@Slf4j
@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext = null;

	/**
	 * 获取applicationContext对象
	 *
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 实现DisposableBean接口, 在Context关闭时清理静态变量.
	 */
	@Override
	@SneakyThrows
	public void destroy() {
		SpringContextHolder.clearHolder();
	}

	/**
	 * 将context注入到静态变量中
	 *
	 * @param applicationContext
	 */
	@Override
	@SneakyThrows
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext;
	}

	/**
	 * 从applicationContext获取bean,并自动转型
	 *
	 * @param name bean的name
	 * @param <T>  所赋值对象
	 * @return
	 */
	public static <T> T getBean(String name) {
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 从applicationContext获取bean,并自动转型
	 *
	 * @param requiredType 要求对象类型
	 * @param <T>          所赋值对象
	 * @return
	 */
	public static <T> T getBean(Class<T> requiredType) {
		return applicationContext.getBean(requiredType);
	}

	/**
	 * 清除SpringContextHolder中的ApplicationContext为Null.
	 */
	public static void clearHolder() {
		if (log.isDebugEnabled()) {
			log.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
		}
		applicationContext = null;
	}

	/**
	 * 发布事件
	 *
	 * @param event
	 */
	public static void publishEvent(ApplicationEvent event) {
		if (applicationContext == null) {
			return;
		}
		applicationContext.publishEvent(event);
	}
}
