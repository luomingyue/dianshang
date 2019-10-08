package com.neuedu.shop.service;

import java.util.List;

import com.neuedu.shop.pojo.User;



public interface IUserService {
	void add(User user);
	List<User> findAll();
	User findById(int id);
	void update(User user);
	void delete(int id);
	void resetUserPwd(int id);
}
