package com.dreamcc.common.core.util;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.core.util
 * @Description: 树工具类
 * @Author: dreamcc
 * @Date: 2019/8/1 17:42
 * @Version: V1.0
 */
@UtilityClass
public class TreeUtil {

	/**
	 * 利用双重循环建立树
	 * @param treeNodes 传入的树节点列表
	 * @param root
	 * @param <T>
	 * @return
	 */
	public <T extends TreeNode> List<T> buildByLoop(List<T> treeNodes, Object root) {
		List<T> trees = new ArrayList<>();
		for (T treeNode : treeNodes) {
			if (root.equals(treeNode.getParentId())) {
				trees.add(treeNode);
			}

			for (T it : treeNodes) {
				if (it.getParentId() == treeNode.getId()) {
					if (treeNode.getChildren() == null) {
						treeNode.setChildren(new ArrayList<>());
					}
					treeNode.add(it);
				}
			}
		}
		return trees;
	}
}
