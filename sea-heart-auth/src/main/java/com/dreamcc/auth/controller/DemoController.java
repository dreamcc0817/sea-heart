package com.dreamcc.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.auth.controller
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/7/25 15:00
 * @Version: V1.0
 */
@RestController
public class DemoController {
	@GetMapping("/product/{id}")
	public String getProduct(@PathVariable String id) {
		//for debug
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "product id : " + id;
	}

	@GetMapping("/order/{id}")
	public String getOrder(@PathVariable String id) {
		//for debug
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "order id : " + id;
	}

}
