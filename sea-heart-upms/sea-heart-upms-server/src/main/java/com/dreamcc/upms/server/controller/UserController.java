package com.dreamcc.upms.server.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dreamcc.common.core.util.R;
import com.dreamcc.common.security.annotation.Inner;
import com.dreamcc.common.security.util.SecurityUtils;
import com.dreamcc.upms.api.entity.SysUser;
import com.dreamcc.upms.server.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.controller
 * @Description:
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
}
