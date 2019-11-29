package com.dreamcc.gateway.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dreamcc.gateway.model.DynamicVersion;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.gateway.dao
 * @Description: 网关版本号DAO
 * @Author: dreamcc
 * @Date: 2019/8/14 18:56
 * @Version: V1.0
 */
@Mapper
public interface DynamicVersionDAO extends BaseMapper<DynamicVersion> {

	/**
	 * 获取最后一次发布的版本号
	 *
	 * @return
	 */
	Long getLastVersion();
}
