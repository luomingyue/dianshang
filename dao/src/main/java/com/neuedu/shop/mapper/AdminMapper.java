package com.neuedu.shop.mapper;



import java.util.List;

import com.neuedu.shop.pojo.Admin;

public interface AdminMapper {
	List<Admin> findAll();
	
	Admin findById(int id);
	
	void insert(Admin admin);
	
	void update(Admin admin);
	
	void delete(int id);
	Admin findByName(String aname);
	
}
