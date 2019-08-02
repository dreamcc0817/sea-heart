package com.dreamcc.upms.server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamcc.common.core.util.TreeUtil;
import com.dreamcc.common.security.util.SecurityUtils;
import com.dreamcc.upms.server.dao.SysDeptDAO;
import com.dreamcc.upms.server.dto.DeptTree;
import com.dreamcc.upms.server.entity.SysDept;
import com.dreamcc.upms.server.service.SysDeptService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.service.impl
 * @Description: 部门相关Service实现类
 * @Author: dreamcc
 * @Date: 2019/8/1 17:05
 * @Version: V1.0
 */
@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDAO, SysDept> implements SysDeptService {

	/**
	 * 查询部门树
	 *
	 * @return
	 */
	@Override
	public List<DeptTree> listDeptTrees() {
		return getDeptTree(this.list(Wrappers.emptyWrapper()));
	}

	/**
	 * 查询当前用户树
	 *
	 * @return
	 */
	@Override
	public List<DeptTree> listCurrentUserDeptTrees() {
		Integer deptId = SecurityUtils.getUser().getDeptId();
		List<SysDept> descendantIdList = this
				.list(Wrappers.<SysDept>query().lambda().eq(SysDept::getDept_parent_id,deptId));
		return getDeptTree(descendantIdList);
	}


	/**
	 * 构建部门树
	 *
	 * @param depts 部门
	 * @return
	 */
	private List<DeptTree> getDeptTree(List<SysDept> depts) {
		List<DeptTree> treeList = depts.stream()
				.filter(dept -> !dept.getDeptId().equals(dept.getParentId()))
				.map(dept -> {
					DeptTree node = new DeptTree();
					node.setId(dept.getDeptId());
					node.setParentId(dept.getParentId());
					node.setName(dept.getName());
					return node;
				}).collect(Collectors.toList());
		return TreeUtil.buildByLoop(treeList, 0);
	}


}
