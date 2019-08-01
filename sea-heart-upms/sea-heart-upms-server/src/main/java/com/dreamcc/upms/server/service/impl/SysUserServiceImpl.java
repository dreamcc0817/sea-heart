package com.dreamcc.upms.server.service.impl;

import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamcc.upms.server.dao.SysUserDAO;
import com.dreamcc.upms.server.dto.UserDTO;
import com.dreamcc.upms.server.entity.SysUser;
import com.dreamcc.upms.server.service.SysUserService;
import com.dreamcc.upms.server.vo.UserVO;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
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

	@Override
	public Boolean saveUser(UserDTO userDTO) {
		return null;
	}

}
