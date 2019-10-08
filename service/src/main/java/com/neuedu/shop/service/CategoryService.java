package com.neuedu.shop.service;

import java.util.List;

import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.pojo.CategoryBean;

public interface CategoryService {
	void insertRoot(CategoryBean catbean);
	void insertChild(String name,String descr,int pid);
	List<Category> findAll();
	List<Category> findToTree();
	void delete(int id,int pid);
}
