package com.dreamcc.upms.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dreamcc.upms.server.entity.SysRole;

import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.service
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/8/2 14:33
 * @Version: V1.0
 */
public interface SysRoleService extends IService<SysRole> {

	/**
	 * 通过用户ID，查询角色信息
	 *
	 * @param userId 用户ID
	 * @return
	 */
	List<SysRole> listRolesByUserId(Integer userId);

	/**
	 * 通过角色ID，删除角色
	 *
	 * @param id
	 * @return
	 */
	Boolean removeRoleById(Integer id);
}
