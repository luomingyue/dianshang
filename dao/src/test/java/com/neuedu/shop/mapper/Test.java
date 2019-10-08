package com.neuedu.shop.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.shop.pojo.Admin;
import com.neuedu.shop.util.MybatisUtil;

public class Test {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, Exception {
		String t = "java.util.Random";
		System.out.println(Class.forName(t));
		System.out.println(new Test().getClass().newInstance());
		System.out.println(int.class.getFields());
	}
}
