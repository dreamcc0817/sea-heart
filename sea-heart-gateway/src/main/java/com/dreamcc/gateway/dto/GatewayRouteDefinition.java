package com.dreamcc.gateway.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.model
 * @Description: 路由模型
 * @Author: dreamcc
 * @Date: 2019/8/5 13:49
 * @Version: V1.0
 */
@Data
public class GatewayRouteDefinition {
	/**
	 * 路由ID
	 */
	private Long id;

	/**
	 * 路由断言集合配置
	 */
	private List<GatewayPredicateDefinition> predicates = new ArrayList<>();

	/**
	 * 路由过滤器集合配置
	 */
	private List<GatewayFilterDefinition> filters = new ArrayList<>();

	/**
	 * 路由规则转发的目标URI
	 */
	private String uri;

	/**
	 * 执行路由的顺序
	 */
	private int order;

}
