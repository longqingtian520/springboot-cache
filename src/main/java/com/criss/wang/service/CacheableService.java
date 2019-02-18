package com.criss.wang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.criss.wang.entity.User;
import com.criss.wang.mapper.CacheableMapper;

@Service
public class CacheableService {

	/**
	 总结：@CachePut和@Cacheable这两个标签可以结合使用，当需要根据请求改变值的时候，利用@CachePut将值改变并写入到缓存中，
	 	  而@Cacheable标签除了第一次之外，一直是取的缓存的值。
		  注意结合使用时需要注意两点：
		 1、必须是同一个缓存实例。
		 2、key值必须是相同的。
	 */

	@Autowired
	private CacheableMapper cacheableMapper;

	@Cacheable(value = "userCache", key = "#username", condition = "#username.length()==7")
	public User cacheableMethod(String username) {
		System.out.println("查询数据库");
		return cacheableMapper.getUserByUsername(username);
	}

	@CachePut(value = "userCache", key = "#username")
	public User cachePutMethod(String username, User user) {
		System.out.println("更新数据库");
		cacheableMapper.updateUser(username, user);
		return user;
	}

	// 注意：清除操作默认是在对应方法成功执行之后触发的，即方法如果因为抛出异常而未能成功返回时也不会触发清除操作。
	@CacheEvict(value = "userCache", key = "#username", beforeInvocation=true)
	public void cacheEvictMethod(String username) {
		System.out.println("删除Cache中username对应的缓存");
	}
}
