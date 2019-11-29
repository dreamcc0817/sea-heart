package com.dreamcc.gateway.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dreamcc.gateway.model.GatewayRoutes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.dao
 * @Description: 路由信息DAO
 * @Author: dreamcc
 * @Date: 2019/8/14 18:58
 * @Version: V1.0
 */
@Mapper
public interface GatewayRoutesDAO extends BaseMapper<GatewayRoutes> {

	/**
	 * 获取路由信息
	 *
	 * @param route 路由信息
	 * @return
	 */
	List<GatewayRoutes> getRoutes(GatewayRoutes route);
}
