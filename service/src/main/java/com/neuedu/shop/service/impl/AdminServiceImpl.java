package com.neuedu.shop.service.impl;

import java.util.List;

import com.neuedu.shop.mapper.AdminMapper;
import com.neuedu.shop.pojo.Admin;
import com.neuedu.shop.service.AdminService;
import com.neuedu.shop.util.ServiceUtil;



public class AdminServiceImpl implements AdminService {
	AdminMapper mapper;
	public AdminServiceImpl() {}
	public AdminServiceImpl(AdminMapper mapper) {
		this.mapper = mapper;
	}
	public List<Admin> findAll() {
		return mapper.findAll();
	}
	public Admin findById(int id) {
		
		return mapper.findById(id);
	}
	public void update(Admin admin) {
		mapper.update(admin);
		
	}
	public void delete(int id) {
		mapper.delete(id);
		
	}
	public Admin login(String aname, String apwd) {
		Admin admin = mapper.findByName(aname);
		if(admin != null) {
			if(admin.getAdminPassword().equals(ServiceUtil.getMD5String(apwd))) {
				return admin;
			}else {
				return null;
			}
		}
		return null;
	}
	public void add(Admin admin) {
		mapper.insert(admin);
		
	}
	public Admin findByName(String name) {
		return mapper.findByName(name);
	}
	

}
