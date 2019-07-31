package com.dreamcc.upms.server.service;

import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dreamcc.upms.api.entity.SysUser;
import com.dreamcc.upms.api.vo.UserVO;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/7/26 10:08
 * @Version: V1.0
 */
public interface SysUserService extends IService<SysUser> {
	/**
	 * 查询用户信息
	 * @param sysUser 用户
	 * @return
	 */
	UserInfo getUserInfo(SysUser sysUser);

	/**
	 * 通过ID查询用户信息
	 *
	 * @param id 用户ID
	 * @return 用户信息
	 */
	UserVO getUserVoById(Integer id);
}
