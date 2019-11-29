package com.dreamcc.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.dreamcc.common.core.constant.GatewayConstants;
import com.dreamcc.common.core.util.R;
import com.dreamcc.gateway.model.GatewayRoutes;
import com.dreamcc.gateway.service.IDynamicRouteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.controller
 * @Description: Rest接口，通过这些接口实现动态路由功能
 * @Author: dreamcc
 * @Date: 2019/8/5 15:14
 * @Version: V1.0
 */
@Slf4j
@RestController
@RequestMapping("/route")
public class GatewayRouteController {

	@Autowired
	private IDynamicRouteService dynamicRouteService;
	@Autowired
	private StringRedisTemplate redisTemplate;

	@GetMapping("/routes")
	public R getRouteDefinitions() {
		String result = redisTemplate.opsForValue().get(GatewayConstants.GATEWAY_ROUTE);
		if(!StringUtils.isEmpty(result)){
			log.info("返回 redis 中的路由信息......");
		}else{
			log.info("返回 mysql 中的路由信息......");
			result = JSON.toJSONString(dynamicRouteService.getRouteDefinitions());
			//再set到redis
			redisTemplate.opsForValue().set(GatewayConstants.GATEWAY_ROUTE , result);
		}
		return new R<>(result);
	}

	/**
	 * 增加路由
	 *
	 * @param route 路由信息
	 * @return
	 */
	@PostMapping("/add")
	public R add(GatewayRoutes route) {
		Boolean result = dynamicRouteService.save(route);
		return new R<>(result);
	}
}
