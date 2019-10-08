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
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.shop.mapper.AdminMapper;
import com.neuedu.shop.pojo.Admin;
import com.neuedu.shop.service.AdminService;
import com.neuedu.shop.service.impl.AdminServiceImpl;
import com.neuedu.shop.util.MybatisUtil;
import com.neuedu.shop.util.ServiceUtil;




@WebServlet("*.admin")
public class DataServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3047856645369288619L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceUtil.setEncoding(req, resp);

		String url = req.getRequestURI().toString();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));

		SqlSession sqlSession = MybatisUtil.getSqlSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		AdminService adminService = new AdminServiceImpl(adminMapper);
		PrintWriter out = resp.getWriter();
		if ("/findAll".equals(path)) {
			List<Admin> admins = adminMapper.findAll();
		
			req.setAttribute("admins", admins);
		
			RequestDispatcher rd = req.getRequestDispatcher("admin-list.jsp");
		
			rd.forward(req, resp);

		} else if ("/register".equals(path)) {
			String aname = req.getParameter("adminName");
			String apwd = req.getParameter("adminPassword");
			Admin admin = new Admin();
			admin.setAdminName(aname);
			admin.setAdminPassword(apwd);
			adminMapper.insert(admin);
			sqlSession.commit();

			resp.sendRedirect("login.jsp");
		} else if ("/load".equals(path)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Admin admin = adminService.findById(id);
			req.setAttribute("admin", admin);
			req.getRequestDispatcher("load_admin.jsp").forward(req, resp);

		} else if ("/update".equals(path)) {
			int id = Integer.parseInt(req.getParameter("id"));
			String aname = req.getParameter("adminName");
			String apwd = req.getParameter("adminPassword");
			Admin admin = adminService.findById(id);
			admin.setAdminName(aname);
			admin.setAdminPassword(apwd);
			adminService.update(admin);
			sqlSession.commit();
			resp.sendRedirect("findAll.admin");
		} else if("/add".equals(path)) {
			String aname = req.getParameter("adminName");
			String apwd = req.getParameter("adminPassword");
			Admin admin = new Admin();
			admin.setAdminName(aname);
			admin.setAdminPassword(apwd);
			adminService.add(admin);
			sqlSession.commit();
			resp.sendRedirect("findAll.admin");
		}
		else if ("/delete".equals(path)) {
			int id = Integer.parseInt(req.getParameter("id"));
			adminService.delete(id);
			sqlSession.commit();
			resp.sendRedirect("findAll.admin");
		}else if("/login".equals(path)) {
			String aname = req.getParameter("adminName");
			String apwd = req.getParameter("adminPassword");
			String code = req.getParameter("code");
			Admin admin = adminService.login(aname, apwd);
			if(admin != null) {
				HttpSession session = req.getSession();
				String checkcode = (String) session.getAttribute("code");
				if(checkcode.equals(code)) {
				session.setAttribute("admin", admin);
				resp.sendRedirect("index.jsp");
				}else {
					req.setAttribute("code_msg", "验证码错误");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			}else {
				req.setAttribute("msg", "登陆失败");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}else if("/logout".equals(path)) {
			req.getSession().invalidate();
			resp.sendRedirect("login.jsp");
		}else if("/checkAname".equals(path)) {
			String adminName = req.getParameter("adminName");
			Admin admin = adminService.findByName(adminName);
			if(admin != null) {
				out.print("用户已存在");
			}else {
				out.print("可以注册");
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
