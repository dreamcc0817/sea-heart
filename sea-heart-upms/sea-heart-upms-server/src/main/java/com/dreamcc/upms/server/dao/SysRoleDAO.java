package com.dreamcc.upms.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dreamcc.upms.server.entity.SysRole;

import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.dao
 * @Description: 角色相关DAO
 * @Author: dreamcc
 * @Date: 2019/8/2 14:28
 * @Version: V1.0
 */
public interface SysRoleDAO extends BaseMapper<SysRole> {

	/**
	 * 通过用户ID，查询角色信息
	 *
	 * @param userId
	 * @return
	 */
	List<SysRole> listRolesByUserId(Integer userId);
}
