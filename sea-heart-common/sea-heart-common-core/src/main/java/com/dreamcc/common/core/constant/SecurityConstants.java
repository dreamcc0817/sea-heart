package com.dreamcc.common.core.constant;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.core.constant
 * @Description: 安全相关字段常量
 * @Author: dreamcc
 * @Date: 2019/7/26 14:27
 * @Version: V1.0
 */
public interface SecurityConstants {
	/**
	 * 角色前缀
	 */
	String ROLE = "ROLE_";

	/**
	 * 前缀
	 */
	String PROJECT_PREFIX = "sea-heart_";

	/**
	 * oauth 相关前缀
	 */
	String OAUTH_PREFIX = "oauth:";

	/**
	 * 标志
	 */
	String FROM = "from";

	/**
	 * 内部
	 */
	String FROM_IN = "Y";

	/***
	 * 资源服务器默认bean名称
	 */
	String RESOURCE_SERVER_CONFIGURER = "resourceServerConfigurerAdapter";
}
