package com.dreamcc.upms.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.api.entity
 * @Description: 角色表
 * @Author: dreamcc
 * @Date: 2019/7/25 17:00
 * @Version: V1.0
 */
@Data
public class SysRole implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "role_id", type = IdType.AUTO)
	private Integer roleId;

	/**
	 * 角色名称
	 */
	@NotBlank(message = "角色名称不能为空")
	private String roleName;

	/**
	 * 角色标识
	 */
	@NotBlank(message = "角色标识不能为空")
	private String roleCode;

	/**
	 * 角色描述
	 */
	@NotBlank(message = "角色描述不能为空")
	private String roleDesc;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 删除标识（0-正常,1-删除）
	 */
	@TableLogic
	private String delFlag;

}
