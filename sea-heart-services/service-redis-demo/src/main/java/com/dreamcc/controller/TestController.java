package com.dreamcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title: sea-heart
 * @Package: com.dreamcc.controller
 * @Description:
 * @Author: dreamcc
 * @Date: 2019/11/8 9:53
 * @Version: V1.0
 */
@RestController
public class TestController {


	@Autowired
	@Qualifier("myRedisTemplate")
	private RedisTemplate redisTemplate;


	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@GetMapping("/test/redisTemplate")
	public void redisTemplateTest(){

		Set<ZSetOperations.TypedTuple<String>> typedTuples = new HashSet<>();


	}
}
