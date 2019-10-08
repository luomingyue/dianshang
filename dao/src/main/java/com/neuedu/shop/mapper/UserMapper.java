package com.neuedu.shop.mapper;

import java.util.List;

import com.neuedu.shop.pojo.User;



public interface UserMapper {
	List<User> findAll();
	
	User findById(int id);
	
	void insert(User user);
	
	void update(User user);
	
	void delete(int id);
	void resetUserPwd(int id);
}
