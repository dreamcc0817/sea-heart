package com.dreamcc.upms.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dreamcc.upms.server.dto.DeptTree;
import com.dreamcc.upms.server.entity.SysDept;

import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.service
 * @Description: 部门相关Service
 * @Author: dreamcc
 * @Date: 2019/8/1 17:03
 * @Version: V1.0
 */
public interface SysDeptService extends IService<SysDept> {

	/**
	 * 查询部门树
	 *
	 * @return
	 */
	List<DeptTree> listDeptTrees();

	/**
	 * 查询用户部门树
	 *
	 * @return
	 */
	List<DeptTree> listCurrentUserDeptTrees();
}
