package com.dreamcc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.controller
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/7/29 13:36
 * @Version: V1.0
 */
@Api("aaa")
@RestController
public class DemoController {


	@ApiOperation("aaa")
	@ApiImplicitParams({
			@ApiImplicitParam("aaa")
	})
	@GetMapping("/hello")
	public String helloWorld(){
		return "Hello World";
	}
}
