package com.dreamcc.gateway.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamcc.gateway.dao.GatewayRoutesDAO;
import com.dreamcc.gateway.dto.GatewayRouteDefinition;
import com.dreamcc.gateway.model.GatewayRoutes;
import com.dreamcc.gateway.service.IDynamicRouteService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.service
 * @Description: 动态路由实现类
 * @Author: dreamcc
 * @Date: 2019/8/5 14:16
 * @Version: V1.0
 */
@Service("dynamicRouteService")
public class DynamicRouteServiceImpl extends ServiceImpl<GatewayRoutesDAO,GatewayRoutes> implements IDynamicRouteService {

	@Override
	public List<GatewayRouteDefinition> getRouteDefinitions() {
		List<GatewayRouteDefinition> routeDefinitions = new ArrayList<>();
		GatewayRoutes route = new GatewayRoutes();
		route.setIsDel(false);
		route.setIsEnable(false);
		List<GatewayRoutes> routes = list(Wrappers.lambdaQuery(route));
		for (GatewayRoutes gatewayRoutes : routes) {
			GatewayRouteDefinition routeDefinition = new GatewayRouteDefinition();
			BeanUtils.copyProperties(gatewayRoutes,routeDefinition);
			routeDefinitions.add(routeDefinition);
		}
		return routeDefinitions;
	}
}
