package com.neuedu.shop.service.impl;

import java.util.List;

import com.neuedu.shop.mapper.CategoryMapper;
import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.pojo.CategoryBean;
import com.neuedu.shop.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryMapper mapper;
	public CategoryServiceImpl() {}
	public CategoryServiceImpl(CategoryMapper mapper) {
		this.mapper = mapper;
	}
	public void insertRoot(String name, String descr) {
		mapper.insertRoot(new CategoryBean(name,descr));

	}

	public void insertChild(String name, String descr, int pid) {
		// TODO Auto-generated method stub

	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Category> findToTree() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id, int pid) {
		// TODO Auto-generated method stub

	}
	public void insertRoot(CategoryBean catbean) {
		// TODO Auto-generated method stub
		
	}

}
