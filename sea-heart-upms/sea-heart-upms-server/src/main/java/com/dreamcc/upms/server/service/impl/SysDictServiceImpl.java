package com.dreamcc.upms.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamcc.upms.server.dao.SysDictDAO;
import com.dreamcc.upms.server.entity.SysDict;
import com.dreamcc.upms.server.service.SysDictService;
import org.springframework.stereotype.Service;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.server.service.impl
 * @Description: 字典相关Service实现类
 * @Author: dreamcc
 * @Date: 2019/8/1 15:30
 * @Version: V1.0
 */
@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDAO,SysDict> implements SysDictService {
}
