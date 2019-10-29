package com.ptw.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptw.redis.RedisCacheHelper;
import com.ptw.utils.PTWResult;
@RestController
public class RedisController {
	@Autowired
	private RedisCacheHelper redisUtils;
	@RequestMapping("/redis/get")
	public PTWResult get(String key) {
		Object object = redisUtils.get(key);
		if(object!=null) return PTWResult.ok(object.toString());
		else return PTWResult.ok("");
	}
	@RequestMapping("/redis/set")
	public PTWResult set(String key,String value) {
		redisUtils.set(key, value);
		return PTWResult.ok();
	}
}
