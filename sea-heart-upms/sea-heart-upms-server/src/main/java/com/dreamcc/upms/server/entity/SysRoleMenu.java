package com.dreamcc.upms.server.entity;

import lombok.Data;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.entity
 * @Description: 角色菜单关系表
 * @Author: dreamcc
 * @Date: 2019/8/2 14:21
 * @Version: V1.0
 */
@Data
public class SysRoleMenu {
	/**
	 * 角色ID
	 */
	private Integer roleId;
	/**
	 * 菜单ID
	 */
	private Integer menuId;
}
