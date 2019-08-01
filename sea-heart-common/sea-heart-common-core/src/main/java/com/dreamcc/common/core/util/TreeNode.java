package com.dreamcc.common.core.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.dto
 * @Description: 树
 * @Author: dreamcc
 * @Date: 2019/8/1 17:31
 * @Version: V1.0
 */
@Data
public class TreeNode {
	protected int id;
	protected int parentId;
	protected List<TreeNode> children = new ArrayList<>();

	public void add(TreeNode node) {
		children.add(node);
	}
}