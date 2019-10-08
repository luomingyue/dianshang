package com.neuedu.shop.controller;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.shop.mapper.CategoryMapper;
import com.neuedu.shop.pojo.CategoryBean;
import com.neuedu.shop.util.MybatisUtil;

public class Test {

	public static void main(String[] args) {
		SqlSession session  = MybatisUtil.getSqlSession();
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);
		mapper.insertRoot(new CategoryBean("电器","70周年"));
		session.commit();

	}

}
