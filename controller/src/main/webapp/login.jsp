<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html  class="x-admin-sm">
<head>
	<meta charset="UTF-8">
	<title>后台登录-X-admin2.2</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/login.css">
	  <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    	.error{
    		color:red;
    	}
    </style>
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">x-admin2.0-管理登录</div>
        <div id="darkbannerwrap"></div>
        
        <form action="login.admin" method="post" class="layui-form" >
            <input name="adminName" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" ><span class="error">${msg}</span>
            <hr class="hr15">
            <input name="adminPassword" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input name="code" style=" display:inline-block ;width:200px" lay-verify="required" placeholder=""  type="text" class="layui-input">
            <a id="changeCode" href="javascript:;"><img src="code.code" id="img"></a>
            <hr class="hr15">
            <span class="error">${code_msg }</span>
            <script type="text/javascript">
            	$(function(){
            		$("#changeCode").click(function(){
            			$("#img").attr("src","code.code?code="+new Date().getTime());
            		});
            	});
            </script>
            <input value="登录"  lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
           <a href="admin_register.jsp"> <input value="注册"  style="width:100%;" href="admin_register" type="button" ></a>
            <hr class="hr20" >
        </form>
    </div>

   
    <!-- 底部结束 -->
    <script>
    //百度统计可去掉
    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
      var s = document.getElementsByTagName("script")[0]; 
      s.parentNode.insertBefore(hm, s);
    })();
    </script>
</body>
</html>