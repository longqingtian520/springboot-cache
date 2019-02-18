package com.criss.wang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.criss.wang.entity.User;
import com.criss.wang.service.CacheableService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CacheController {

	@Autowired
	private CacheableService cacheableService;

	@Autowired
	private ObjectMapper objectMapper;

	@RequestMapping(value = "/cacheable", method = RequestMethod.GET)
	public String cacheableValue(@RequestParam(value = "username", required = false) String username)
			throws JsonProcessingException {
		User user = cacheableService.cacheableMethod(username);
		return objectMapper.writeValueAsString(user);
	}

	@RequestMapping(value = "/cachePut/{username}", method = RequestMethod.PUT)
	public String cacheablePutValue(@PathVariable(value = "username", required = false) String username,
			@RequestBody User user) {
		cacheableService.cachePutMethod(username, user);
		return "success";
	}

	@RequestMapping(value = "/cacheEvict/{username}", method = RequestMethod.DELETE)
	public String cacheEvictValue(@PathVariable(value = "username", required = false)String username) {
		cacheableService.cacheEvictMethod(username);
		return "success";
	}


}
