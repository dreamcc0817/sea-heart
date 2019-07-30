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
 * @Description: 部门表
 * @Author: dreamcc
 * @Date: 2019/7/25 17:27
 * @Version: V1.0
 */
@Data
public class SysDept implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "dept_id", type = IdType.AUTO)
	private Integer deptId;

	/**
	 * 部门名称
	 */
	@NotBlank(message = "部门名称不能为空")
	private String name;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 上级部门ID
	 */
	private Integer parentId;

	/**
	 * 是否删除  -1：已删除  0：正常
	 */
	@TableLogic
	private String delFlag;
}
