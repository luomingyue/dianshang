<%@page import="com.neuedu.shop.pojo.Admin"%>
<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Admin admin = (Admin) session.getAttribute("admin");
	if(admin == null){
		response.sendRedirect("login.jsp");
		return;
	}
%>