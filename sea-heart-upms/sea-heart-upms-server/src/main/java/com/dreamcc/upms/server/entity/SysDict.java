package com.dreamcc.upms.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.entity
 * @Description: 字典表
 * @Author: dreamcc
 * @Date: 2019/7/25 17:31
 * @Version: V1.0
 */
@Data
public class SysDict implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	/**
	 * 数据值
	 */
	@NotBlank(message = "字典项数据值不能为空")
	private String value;
	/**
	 * 标签名
	 */
	@NotBlank(message = "字典项标签不能为空")
	private String label;
	/**
	 * 类型
	 */
	@NotBlank(message = "字典项数据类型不能为空")
	private String type;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 排序（升序）
	 */
	private Integer sort;
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;
	/**
	 * 备注信息
	 */
	private String remarks;
	/**
	 * 删除标记
	 */
	@TableLogic
	private String delFlag;
}
