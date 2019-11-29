package com.dreamcc.upms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamcc.upms.server.dao.SysUserRoleDAO;
import com.dreamcc.upms.server.entity.SysUserRole;
import com.dreamcc.upms.server.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.service.impl
 * @Description: 用户角色相关Service实现类
 * @Author: dreamcc
 * @Date: 2019/8/2 15:25
 * @Version: V1.0
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDAO,SysUserRole> implements SysUserRoleService {
}
