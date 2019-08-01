package com.dreamcc.upms.server.dto;

import com.dreamcc.common.core.util.TreeNode;
import lombok.Data;


/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.dto
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/8/1 17:30
 * @Version: V1.0
 */
@Data
public class DeptTree extends TreeNode {
	/**
	 * 部门名称
	 */
	private String name;
}
