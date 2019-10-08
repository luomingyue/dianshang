package com.neuedu.shop.mapper;

import java.util.List;

import com.neuedu.shop.pojo.Category;
import com.neuedu.shop.pojo.CategoryBean;

public interface CategoryMapper {
	void insertRoot(CategoryBean catbean);
	void insertChild(String name,String descr,int pid);
	List<Category> findAll();
	List<Category> findToTree();
	void delete(int id,int pid);
}
