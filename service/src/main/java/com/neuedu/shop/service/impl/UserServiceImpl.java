package com.neuedu.shop.service.impl;

import java.util.List;

import com.neuedu.shop.mapper.UserMapper;
import com.neuedu.shop.pojo.User;
import com.neuedu.shop.service.IUserService;



public class UserServiceImpl implements IUserService {
	UserMapper mapper;
	public UserServiceImpl() {}
	public UserServiceImpl(UserMapper mapper) {
		this.mapper = mapper;
	}
	public List<User> findAll() {
		return mapper.findAll();
	}

	public User findById(int id) {
		return mapper.findById(id);
	}

	public void update(User user) {
		mapper.update(user);

	}

	public void delete(int id) {
		mapper.delete(id);
	}
	public void add(User user) {
		mapper.insert(user);
		
	}
	public void resetUserPwd(int id) {
		mapper.resetUserPwd(id);
		
	}
	

}
