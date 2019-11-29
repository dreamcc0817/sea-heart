package com.dreamcc.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dreamcc.gateway.dto.GatewayRouteDefinition;
import com.dreamcc.gateway.model.GatewayRoutes;

import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.service
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/8/5 15:04
 * @Version: V1.0
 */
public interface IDynamicRouteService extends IService<GatewayRoutes> {

	/**
	 * 返回组装后网关需要的路由信息
	 * @return
	 */
	List<GatewayRouteDefinition> getRouteDefinitions();

}
