package com.dreamcc.upms.server.service.impl;

import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamcc.upms.api.entity.SysUser;
import com.dreamcc.upms.api.vo.UserVO;
import com.dreamcc.upms.server.dao.SysUserDAO;
import com.dreamcc.upms.server.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.service.impl
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/7/26 10:08
 * @Version: V1.0
 */
@Service("userService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDAO, SysUser> implements SysUserService {
	@Override
	public UserInfo getUserInfo(SysUser sysUser) {
		return null;
	}

	/**
	 * 通过用户ID查询用户信息
	 *
	 * @param id 用户ID
	 * @return
	 */
	@Override
	public UserVO getUserVoById(Integer id) {
		return baseMapper.getUserVoById(id);
	}

}
