package com.dreamcc.upms.server.service.impl;

import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamcc.common.core.constant.CommonConstants;
import com.dreamcc.upms.server.dao.SysUserDAO;
import com.dreamcc.upms.server.dto.UserDTO;
import com.dreamcc.upms.server.entity.SysUser;
import com.dreamcc.upms.server.entity.SysUserRole;
import com.dreamcc.upms.server.service.SysUserRoleService;
import com.dreamcc.upms.server.service.SysUserService;
import com.dreamcc.upms.server.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.service.impl
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/7/26 10:08
 * @Version: V1.0
 */
@Slf4j
@Service("userService")
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserDAO, SysUser> implements SysUserService {

	@Autowired
	private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

	@Autowired
	private final SysUserRoleService sysUserRoleService;

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

	/**
	 * 保存用户信息
	 *
	 * @param userDTO 用户DTO对象
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean saveUser(UserDTO userDTO) {
		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(userDTO, sysUser);
		sysUser.setDelFlag(CommonConstants.STATUS_NORMAL);
		sysUser.setPassword(ENCODER.encode(userDTO.getPassword()));
		baseMapper.insert(sysUser);
		List<SysUserRole> userRoleList = userDTO.getRole()
				.stream().map(roleId -> {
					SysUserRole userRole = new SysUserRole();
					userRole.setUserId(sysUser.getUserId());
					userRole.setRoleId(roleId);
					return userRole;
				}).collect(Collectors.toList());
		return sysUserRoleService.saveBatch(userRoleList);
	}

}
