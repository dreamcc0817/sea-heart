package com.dreamcc.gateway.dto;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.model
 * @Description: 路由断言模型
 * @Author: dreamcc
 * @Date: 2019/8/5 13:57
 * @Version: V1.0
 */
@Data
public class GatewayPredicateDefinition {

	/**
	 * 断言对应name
	 */
	private String name;

	/**
	 * 配置的断言规则
	 */
	private Map<String,String> args = new LinkedHashMap<>();

}
