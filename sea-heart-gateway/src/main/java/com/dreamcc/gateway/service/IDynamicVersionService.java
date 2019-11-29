package com.dreamcc.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dreamcc.gateway.model.DynamicVersion;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.service
 * @Description: 路由版本信息Service
 * @Author: dreamcc
 * @Date: 2019/8/14 19:07
 * @Version: V1.0
 */
public interface IDynamicVersionService extends IService<DynamicVersion> {

	/**
	 * 获取最后一次发布的版本号
	 *
	 * @return
	 */
	Long getLastVersion();

}
