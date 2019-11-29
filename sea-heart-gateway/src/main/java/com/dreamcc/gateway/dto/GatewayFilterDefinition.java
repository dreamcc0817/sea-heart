package com.dreamcc.gateway.dto;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.model
 * @Description: 过滤器模型
 * @Author: dreamcc
 * @Date: 2019/8/5 13:54
 * @Version: V1.0
 */
@Data
public class GatewayFilterDefinition {
	/**
	 * 过滤器名称
	 */
	private String name;
	/**
	 * 对应路由规则
	 */
	private Map<String, String> args = new LinkedHashMap<>();
}
