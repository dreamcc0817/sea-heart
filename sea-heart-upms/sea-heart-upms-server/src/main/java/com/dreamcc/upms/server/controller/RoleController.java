package com.dreamcc.upms.server.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dreamcc.common.core.util.R;
import com.dreamcc.common.log.annotation.SysLog;
import com.dreamcc.upms.server.entity.SysRole;
import com.dreamcc.upms.server.service.SysRoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.controller
 * @Description: 角色相关Controller
 * @Author: dreamcc
 * @Date: 2019/8/2 14:23
 * @Version: V1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController {


	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 通过ID查询角色信息
	 *
	 * @param id ID
	 * @return
	 */
	@GetMapping("/{id}")
	public R getById(@PathVariable Integer id) {
		return new R<>(sysRoleService.getById(id));
	}

	/**
	 * 获取角色列表
	 *
	 * @return 角色列表
	 */
	@GetMapping("/list")
	public R listRoles() {
		return new R<>(sysRoleService.list(Wrappers.emptyWrapper()));
	}

	/**
	 * 分页查询角色信息
	 *
	 * @param page 分页对象
	 * @return 分页对象
	 */
	@GetMapping("/page")
	public R getRolePage(Page page) {
		return new R<>(sysRoleService.page(page, Wrappers.emptyWrapper()));
	}

	/**
	 * 添加角色
	 *
	 * @param sysRole 角色信息
	 * @return
	 */
	@SysLog("添加角色")
	@PostMapping("/addRole")
	@PreAuthorize("@permission.hasPermission('sys_role_add')")
	public R save(@Valid @RequestBody SysRole sysRole) {
		return new R<>(sysRoleService.save(sysRole));
	}

	/**
	 * 修改角色
	 *
	 * @param sysRole 角色信息
	 * @return
	 */
	@SysLog("修改角色")
	@PutMapping("/update")
	@PreAuthorize("@permission.hasPermission('sys_role_edit')")
	public R update(@Valid @RequestBody SysRole sysRole) {
		return new R<>(sysRoleService.updateById(sysRole));
	}

	/**
	 * 删除角色
	 * 暂不关菜单相关
	 *
	 * @param id
	 * @return
	 */
	@SysLog("删除角色")
	@DeleteMapping("/deleteRole/{id}")
	@PreAuthorize("@permission.hasPermission('sys_role_del')")
	public R removeById(@PathVariable Integer id) {
		return new R<>(sysRoleService.removeById(id));
	}
}
