package com.dreamcc.upms.server.controller;

import com.dreamcc.common.core.util.R;
import com.dreamcc.common.log.annotation.SysLog;
import com.dreamcc.upms.server.entity.SysDept;
import com.dreamcc.upms.server.service.SysDeptService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.controller
 * @Description: 部门相关Controller
 * @Author: dreamcc
 * @Date: 2019/8/1 17:01
 * @Version: V1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private SysDeptService sysDeptService;

	/**
	 * 通过ID查询部门信息
	 *
	 * @param id ID
	 * @return SysDept
	 */
	@GetMapping("/{id}")
	public R getById(@PathVariable Integer id) {
		return new R<>(sysDeptService.getById(id));
	}

	/**
	 * 返回菜单树
	 *
	 * @return
	 */
	@GetMapping("/tree")
	public R listDeptTrees() {
		return new R<>(sysDeptService.listDeptTrees());
	}

	/**
	 * 返回当前用户树形菜单集合
	 *
	 * @return 树形菜单
	 */
	@GetMapping("/user-tree")
	public R listCurrentUserDeptTrees() {
		return new R<>(sysDeptService.listCurrentUserDeptTrees());
	}

	/**
	 * 添加部门
	 *
	 * @param sysDept
	 * @return
	 */
	@SysLog("添加部门")
	@PostMapping("/addDept")
	@PreAuthorize("@permission.hasPermission('sys_dept_add')")
	public R save(@Valid @RequestBody SysDept sysDept) {
		return new R<>(sysDeptService.save(sysDept));
	}

	/**
	 * 编辑
	 *
	 * @param sysDept 实体
	 * @return
	 */
	@SysLog("编辑部门")
	@PutMapping("/updateDept")
	@PreAuthorize("@permission.hasPermission('sys_dept_edit')")
	public R update(@Valid @RequestBody SysDept sysDept) {
		sysDept.setUpdateTime(LocalDateTime.now());
		return new R<>(sysDeptService.updateById(sysDept));
	}

	/**
	 * 删除
	 *
	 * @param id ID
	 * @return success/false
	 */
	@SysLog("删除部门")
	@DeleteMapping("/deleteDept/{id}")
	@PreAuthorize("@permission.hasPermission('sys_dept_del')")
	public R removeById(@PathVariable Integer id) {
		return new R<>(sysDeptService.removeById(id));
	}
}
