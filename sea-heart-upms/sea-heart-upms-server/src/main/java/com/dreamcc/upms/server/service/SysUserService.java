package com.dreamcc.upms.server.service;

import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dreamcc.upms.server.dto.UserDTO;
import com.dreamcc.upms.server.entity.SysUser;
import com.dreamcc.upms.server.vo.UserVO;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server
 * @Description: 用户相关Service
 * @Author: dreamcc
 * @Date: 2019/7/26 10:08
 * @Version: V1.0
 */
public interface SysUserService extends IService<SysUser> {
	/**
	 * 查询用户信息
	 *
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

	/**
	 * 保存用户信息
	 *
	 * @param userDTO 用户DTO对象
	 * @return
	 */
	Boolean saveUser(UserDTO userDTO);
}
