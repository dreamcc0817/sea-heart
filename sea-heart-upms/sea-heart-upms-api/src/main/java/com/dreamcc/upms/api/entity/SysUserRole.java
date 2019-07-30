package com.dreamcc.upms.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.api.entity
 * @Description: 用户角色关系表
 * @Author: dreamcc
 * @Date: 2019/7/25 17:46
 * @Version: V1.0
 */
@Data
public class SysUserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 角色ID
	 */
	private Integer roleId;
}
