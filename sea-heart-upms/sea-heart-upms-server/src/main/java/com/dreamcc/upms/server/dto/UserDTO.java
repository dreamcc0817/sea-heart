package com.dreamcc.upms.server.dto;

import com.dreamcc.upms.server.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.dto
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/8/1 14:18
 * @Version: V1.0
 */
@Data
public class UserDTO extends SysUser {
	/**
	 * 角色ID
	 */
	private List<Integer> role;

	private Integer deptId;

	/**
	 * 新密码
	 */
	private String newpassword;
}