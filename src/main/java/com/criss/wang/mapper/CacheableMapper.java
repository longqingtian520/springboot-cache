package com.criss.wang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.criss.wang.entity.User;

@Mapper
public interface CacheableMapper {

	@Select("select * from testdb1 where name = #{username}")
	User getUserByUsername(String username);

	@Update("update testdb1 set age = #{user.age} where name = #{username}")
	void updateUser(@Param("username") String username, @Param("user") User user);

}
