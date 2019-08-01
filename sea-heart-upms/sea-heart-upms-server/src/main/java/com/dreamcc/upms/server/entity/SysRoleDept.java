package com.dreamcc.upms.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.entity
 * @Description: 角色部门关系表
 * @Author: dreamcc
 * @Date: 2019/7/25 17:48
 * @Version: V1.0
 */
@Data
public class SysRoleDept implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	/**
	 * 角色ID
	 */
	private Integer roleId;
	/**
	 * 部门ID
	 */
	private Integer deptId;
}
