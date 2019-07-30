package com.dreamcc.upms.server.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dreamcc.common.core.util.R;
import com.dreamcc.common.security.util.SecurityUtils;
import com.dreamcc.upms.api.entity.SysUser;
import com.dreamcc.upms.server.service.SysUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

	@ApiImplicitParams({
			@ApiImplicitParam(value = "测试")
	})
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
}
