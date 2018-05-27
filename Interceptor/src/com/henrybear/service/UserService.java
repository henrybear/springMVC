package com.henrybear.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.henrybear.bean.User;

public interface UserService {

	User login(String loginname, String password);
	
	User findByLoginname(@Param("loginname") String loginname);
	
	List<User> getAll();
	
	List<User> selectWhitParam(User user);
	
	int insertUser(User user);
	
	int updateUser(User user);
	
	int deleteUser(User user);
}
