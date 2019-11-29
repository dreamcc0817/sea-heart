package com.dreamcc.gateway.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamcc.common.core.constant.GatewayConstants;
import com.dreamcc.gateway.dao.DynamicVersionDAO;
import com.dreamcc.gateway.model.DynamicVersion;
import com.dreamcc.gateway.service.IDynamicRouteService;
import com.dreamcc.gateway.service.IDynamicVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.service.impl
 * @Description: 路由版本ServiceImpl
 * @Author: dreamcc
 * @Date: 2019/8/14 19:49
 * @Version: V1.0
 */
@Service("dynamicVersionService")
public class DynamicVersionServiceImpl extends ServiceImpl<DynamicVersionDAO, DynamicVersion> implements IDynamicVersionService {

	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private IDynamicRouteService dynamicRouteService;

	@Override
	public boolean save(DynamicVersion version) {
		version.setCreateTime(new Date());
		redisTemplate.opsForValue().set(GatewayConstants.GATEWAY_VERSION, StrUtil.toString(version.getId()));
		redisTemplate.opsForValue().set(GatewayConstants.GATEWAY_ROUTE, JSON.toJSONString(dynamicRouteService.getRouteDefinitions()));
		return super.save(version);
	}

	/**
	 * 获取最后一次发布的版本号
	 *
	 * @return
	 */
	@Override
	public Long getLastVersion() {
		return null;
	}
}
