package com.dreamcc.gateway.model;

import com.alibaba.fastjson.JSON;
import com.dreamcc.gateway.dto.GatewayFilterDefinition;
import com.dreamcc.gateway.dto.GatewayPredicateDefinition;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.model
 * @Description: 路由实体类
 * @Author: dreamcc
 * @Date: 2019/8/12 20:01
 * @Version: V1.0
 */
public class GatewayRoutes {
	/**
	 * 路由ID
	 */
	@Setter
	@Getter
	private Long id;

	/**
	 * 转发目标路由URI
	 */
	@Setter
	@Getter
	private String routeUri;

	/**
	 * 路由执行顺序
	 */
	@Setter
	@Getter
	private Integer routeOrder;

	/**
	 * 断言字符串集合
	 */
	private String predicates;

	/**
	 * 过滤器集合
	 */
	private String filters;

	/**
	 * 是否启用
	 */
	@Setter
	@Getter
	private Boolean isEnable;

	/**
	 * 是否删除
	 */
	@Setter
	@Getter
	private Boolean isDel;

	/**
	 * 创建时间
	 */
	@Setter
	@Getter
	private Date createTime;

	/**
	 * 创建人
	 */
	@Setter
	@Getter
	private String username;

	/**
	 * 更新时间
	 */
	@Setter
	@Getter
	private Date updateTime;

	/**
	 * 修改人
	 */
	@Setter
	@Getter
	private Date modifier;

	/**
	 * 获取断言集合
	 * @return
	 */
	public List<GatewayPredicateDefinition> getPredicateDefinition(){
		if(!StringUtils.isEmpty(this.predicates)){
			return JSON.parseArray(this.predicates , GatewayPredicateDefinition.class);
		}
		return null;
	}

	/**
	 * 获取过滤器集合
	 * @return
	 */
	public List<GatewayFilterDefinition> getFilterDefinition(){
		if(!StringUtils.isEmpty(this.filters)){
			return JSON.parseArray(this.filters , GatewayFilterDefinition.class);
		}
		return null;
	}
}
