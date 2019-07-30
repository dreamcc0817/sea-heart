package com.dreamcc.common.security.util;

import cn.hutool.core.util.StrUtil;
import com.dreamcc.common.core.constant.SecurityConstants;
import com.dreamcc.common.security.service.SeaUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.core.security
 * @Description: 安全工具类
 * @Author: dreamcc
 * @Date: 2019/7/26 14:03
 * @Version: V1.0
 */
@UtilityClass
public class SecurityUtils {
	/**
	 * 获取Authentication
	 */
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取用户
	 *
	 * @return
	 */
	public SeaUser getUser(Authentication authentication) {
		Object principal = getAuthentication();
		if (principal instanceof SeaUser) {
			return (SeaUser) principal;
		}
		return null;
	}

	/**
	 * 获取用户
	 */
	public SeaUser getUser() {
		Authentication authentication = getAuthentication();
		if (authentication == null) {
			return null;
		}
		return getUser(authentication);
	}


	/**
	 * 获取用户角色信息
	 *
	 * @return
	 */
	public List<Integer> getRoles() {
		Authentication authentication = getAuthentication();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		List<Integer> roleIds = new ArrayList<>();
		authorities.stream()
				.filter(granted -> StrUtil.startWith(granted.getAuthority(), SecurityConstants.ROLE))
				.forEach(granted -> {
					String id = StrUtil.removePrefix(granted.getAuthority(), SecurityConstants.ROLE);
					roleIds.add(Integer.parseInt(id));
				});
		return roleIds;
	}
}