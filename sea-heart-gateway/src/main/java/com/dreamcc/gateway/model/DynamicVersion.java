package com.dreamcc.gateway.model;

import lombok.Data;

import java.util.Date;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.model
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/8/12 19:55
 * @Version: V1.0
 */
@Data
public class DynamicVersion {

	/**
	 * 路由版本ID
	 */
	private Long id;

	/**
	 * 创建时间
	 */
	private Date createTime;
}
