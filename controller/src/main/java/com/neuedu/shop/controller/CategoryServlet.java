package com.neuedu.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.shop.mapper.CategoryMapper;
import com.neuedu.shop.pojo.User;
import com.neuedu.shop.service.CategoryService;
import com.neuedu.shop.service.impl.CategoryServiceImpl;
import com.neuedu.shop.util.MybatisUtil;
import com.neuedu.shop.util.ServiceUtil;



@WebServlet("*.cat")
public class CategoryServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7827168745053647596L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceUtil.setEncoding(req, resp);

		String url = req.getRequestURI().toString();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));

		SqlSession sqlSession = MybatisUtil.getSqlSession();
		CategoryMapper cMapper = sqlSession.getMapper(CategoryMapper.class);
		CategoryService cService = new CategoryServiceImpl(cMapper);
		PrintWriter writer = resp.getWriter();
		 if("/add".equals(path)) {
			 
		 }
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
