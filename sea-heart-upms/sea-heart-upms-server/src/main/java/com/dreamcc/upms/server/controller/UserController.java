package com.dreamcc.upms.server.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dreamcc.common.core.util.R;
import com.dreamcc.common.log.annotation.SysLog;
import com.dreamcc.common.security.annotation.Inner;
import com.dreamcc.common.security.util.SecurityUtils;
import com.dreamcc.upms.server.dto.UserDTO;
import com.dreamcc.upms.server.entity.SysUser;
import com.dreamcc.upms.server.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.controller
 * @Description: 用户相关Controller
 * @Author: dreamcc
 * @Date: 2019/7/26 10:05
 * @Version: V1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

	private final SysUserService userService;

	/**
	 * 获取当前用户信息
	 *
	 * @return
	 */
	@GetMapping("/info")
	public R info() {
		String username = SecurityUtils.getUser().getUsername();
		SysUser user = userService.getOne(Wrappers.<SysUser>query()
				.lambda().eq(SysUser::getUsername, username));
		if (user == null) {
			return new R<>(Boolean.FALSE, "获取当前用户信息失败");
		}
		return new R<>(userService.getUserInfo(user));
	}

	/**
	 * 根据用户名获取信息
	 *
	 * @param username 用户名
	 * @return
	 */
	@Inner
	@GetMapping("/info/{username}")
	public R info(@PathVariable String username) {
		SysUser user = userService.getOne(Wrappers.<SysUser>query()
				.lambda().eq(SysUser::getUsername, username));
		if (user == null) {
			return new R<>(Boolean.FALSE, String.format("用户信息为空 %s", username));
		}
		return new R<>(userService.getUserInfo(user));
	}

	/**
	 * 通过ID查询用户信息
	 *
	 * @param id ID
	 * @return 用户信息
	 */
	@GetMapping("/{id}")
	public R user(@PathVariable Integer id) {
		return new R<>(userService.getUserVoById(id));
	}

	/**
	 * 删除用户信息
	 *
	 * @param id 用户id
	 * @return
	 */
	@SysLog("删除用户信息")
	@DeleteMapping("/{id}")
	@PreAuthorize("@permission.hasPermission('sys_user_del')")
	public R userDel(@PathVariable Integer id) {
		SysUser sysUser = userService.getById(id);
		return new R<>(userService.removeById(sysUser));
	}

	/**
	 * 添加用户
	 *
	 * @param userDTO 用户信息
	 * @return
	 */
	public R addUser(@RequestBody UserDTO userDTO) {
		return new R<>(userService.saveUser(userDTO));
	}
}
