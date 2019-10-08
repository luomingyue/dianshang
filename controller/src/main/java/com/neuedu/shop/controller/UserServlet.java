package com.neuedu.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.shop.mapper.UserMapper;
import com.neuedu.shop.pojo.User;
import com.neuedu.shop.service.IUserService;
import com.neuedu.shop.service.impl.UserServiceImpl;
import com.neuedu.shop.util.MybatisUtil;
import com.neuedu.shop.util.ServiceUtil;



@WebServlet("*.zz")
public class UserServlet extends HttpServlet{

	private static final long serialVersionUID = -7888089347449321517L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceUtil.setEncoding(req, resp);

		String url = req.getRequestURI().toString();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));

		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		IUserService userService = new UserServiceImpl(userMapper);
		
		if ("/findAll".equals(path)) {
			List<User> users = userService.findAll();
			// ���ݰ�
			req.setAttribute("users", users);
			// ��ȡת����
			RequestDispatcher rd = req.getRequestDispatcher("member-list.jsp");
			// ת��
			rd.forward(req, resp);
		}
//		else if ("/register".equals(path)) {
//			String aname = req.getParameter("aname");
//			String apwd = req.getParameter("apwd");
//			Admin admin = new Admin();
//			admin.setAname(aname);
//			admin.setApwd(apwd);
//			adminMapper.insert(admin);
//			sqlSession.commit();
////			out.print("<a href='findAll.do'>��ѯ����</a>");
//			resp.sendRedirect("findAll.do");
		 else if ("/load".equals(path)) {
			int id = Integer.parseInt(req.getParameter("id"));
			User user = userService.findById(id);
			req.setAttribute("user", user);
			req.getRequestDispatcher("member-edit.jsp").forward(req, resp);

		} 
		 else if ("/update".equals(path)) {
			int id = Integer.parseInt(req.getParameter("id"));
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String phone = req.getParameter("phone");
			String addr = req.getParameter("addr");
			User user = userService.findById(id);
			user.setUsername(username);
			user.setPassword(password);
			user.setPhone(phone);
			user.setAddr(addr);
			userService.update(user);
			sqlSession.commit();
			resp.sendRedirect("findAll.zz");
		} 
		 else if("/add".equals(path)) {
			 	String username = req.getParameter("username");
				String password = req.getParameter("password");
				String phone = req.getParameter("phone");
				String addr = req.getParameter("addr");
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setPhone(phone);
				user.setAddr(addr);
				userService.add(user);
				sqlSession.commit();
				resp.sendRedirect("findAll.zz");
		 }
		else if ("/delete".equals(path)) {
			int id = Integer.parseInt(req.getParameter("id"));
			userService.delete(id);
			sqlSession.commit();
			resp.sendRedirect("findAll.zz");
		}else if("/resetUserPwd".equals(path)) {
			int id = Integer.parseInt(req.getParameter("id"));
			System.out.println(id);
			userService.resetUserPwd(id);
			sqlSession.commit();
			resp.sendRedirect("findAll.zz");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
