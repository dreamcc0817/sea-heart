package com.dreamcc.gateway.controller;

import com.dreamcc.common.core.constant.GatewayConstants;
import com.dreamcc.common.core.util.R;
import com.dreamcc.gateway.model.DynamicVersion;
import com.dreamcc.gateway.service.IDynamicVersionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.controller
 * @Description: 网关版本Controller
 * @Author: dreamcc
 * @Date: 2019/8/14 18:54
 * @Version: V1.0
 */
@Slf4j
@RestController
@RequestMapping("/version")
public class DynamicVersionController {

	@Autowired
	private IDynamicVersionService dynamicVersionService;
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * 新增版本信息
	 *
	 * @return
	 */
	@GetMapping("/add")
	public R add() {
		DynamicVersion version = new DynamicVersion();
		Boolean result = dynamicVersionService.save(version);
		return new R<>(result);
	}

	/**
	 * 获取最后一次发布的版本号
	 *
	 * @return
	 */
	@GetMapping("/lastVersion")
	public R getLastVersion() {
		Long versionId = 0L;
		String result = redisTemplate.opsForValue().get(GatewayConstants.GATEWAY_VERSION);
		if(!StringUtils.isEmpty(result)){
			System.out.println("返回 redis 中的版本信息......");
			versionId = Long.valueOf(result);
		}else{
			System.out.println("返回 mysql 中的版本信息......");
			versionId = dynamicVersionService.getLastVersion();
			redisTemplate.opsForValue().set(GatewayConstants.GATEWAY_VERSION , String.valueOf(versionId));
		}
		return new R<>(versionId.toString());
	}
}
