package com.dreamcc.upms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamcc.upms.server.dao.SysRoleDAO;
import com.dreamcc.upms.server.entity.SysRole;
import com.dreamcc.upms.server.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.service.impl
 * @Description: 角色相关Service
 * @Author: dreamcc
 * @Date: 2019/8/2 14:33
 * @Version: V1.0
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDAO, SysRole> implements SysRoleService {

	@Override
	public List<SysRole> listRolesByUserId(Integer userId) {
		return null;
	}

	@Override
	public Boolean removeRoleById(Integer id) {
		return null;
	}
}
