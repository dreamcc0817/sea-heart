package com.dreamcc.upms.client.feign.fallback;

import com.dreamcc.common.core.util.R;
import com.dreamcc.upms.api.entity.SysLog;
import com.dreamcc.upms.client.feign.RemoteLogService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.upms.client.feign.fallback
 * @Description: 远程调用日志回调实现类
 * @Author: dreamcc
 * @Date: 2019/7/31 15:17
 * @Version: V1.0
 */
@Slf4j
@Component
public class RemoteLogServiceFallbackImpl implements RemoteLogService {

	@Setter
	private Throwable cause;

	/**
	 * 保存日志
	 *
	 * @param sysLog 日志实体
	 * @param from   内部调用标志
	 * @return
	 */
	@Override
	public R<Boolean> saveLog(SysLog sysLog, String from) {
		log.error("feign 插入日志失败",cause);
		return null;
	}
}
