package com.dreamcc.upms.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dreamcc.upms.server.entity.SysUser;
import com.dreamcc.upms.server.vo.UserVO;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.dao
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/7/26 10:06
 * @Version: V1.0
 */
public interface SysUserDAO extends BaseMapper<SysUser> {

	/**
	 * 通过ID查询用户信息
	 *
	 * @param id 用户ID
	 * @return
	 */
	UserVO getUserVoById(Integer id);
}
