package com.dreamcc.common.security.service;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.core.security
 * @Description: 扩展用户信息
 * @Author: dreamcc
 * @Date: 2019/7/26 14:07
 * @Version: V1.0
 */
public class SeaUser extends User {

	/**
	 * 用户ID
	 */
	@Getter
	private Integer id;

	/**
	 * 部门ID
	 */
	@Getter
	private Integer deptId;

	public SeaUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.id = id;
		this.deptId = deptId;
	}
}
