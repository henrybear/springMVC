package com.henrybear.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.henrybear.bean.User;
import com.henrybear.mapper.UserMapper;
import com.henrybear.service.UserService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional(readOnly=true)
	@Override
	public User login(String loginname, String password) {
		// TODO Auto-generated method stub
		return userMapper.findWithLoginname(loginname, password);
	}

	@Override
	public User findByLoginname(String loginname) {
		// TODO Auto-generated method stub
		return userMapper.findByLoginname(loginname);
	}
	
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(user);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userMapper.getAll();
	}

	@Override
	public List<User> selectWhitParam(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectWhitParam(user);
	}

}
