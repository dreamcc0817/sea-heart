package com.dreamcc.common.security.service;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.security
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/7/30 16:17
 * @Version: V1.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysUserDetailsServiceImpl implements UserDetailsService {

	private final CacheManager cacheManager;

	/**
	 * 用户密码登录
	 *
	 * @param username 用户名
	 * @return
	 */
	@Override
	@SneakyThrows
	public UserDetails loadUserByUsername(String username) {
		Cache cache = cacheManager.getCache("user_details");
		if (cache != null && cache.get(username) != null) {
			return (SeaUser) cache.get(username).get();
		}
		return null;
	}
}
