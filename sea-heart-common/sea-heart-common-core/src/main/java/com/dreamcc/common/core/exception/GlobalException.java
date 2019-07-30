package com.dreamcc.common.core.exception;

import com.dreamcc.common.core.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.common.core.exception
 * @Description: 全局异常
 * @Author: dreamcc
 * @Date: 2019/7/26 9:26
 * @Version: V1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

	/**
	 * 全局异常
	 *
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public R exception(Exception e) {
		log.error("全局异常信息 ex={}", e.getMessage(), e);
		return new R<>(e);
	}
}
