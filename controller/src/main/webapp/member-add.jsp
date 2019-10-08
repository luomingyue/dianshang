<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>欢迎页面-X-admin2.2</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript" src="./lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>

<body>
	<div class="layui-fluid">
		<div class="layui-row">
			<form class="layui-form" method="post" action="add.zz">

				<div class="layui-form-item">
					<label for="L_username" class="layui-form-label"> <span
						class="x-red">*</span>昵称
					</label>
					<div class="layui-input-inline">
						<input type="hidden" name="id" value="${user.id}"/>
						<input value="${user.username}" type="text" id="L_username" name="username" required=""
							lay-verify="nikename" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_pass" class="layui-form-label"> <span
						class="x-red">*</span>密码
					</label>
					<div class="layui-input-inline">
						<input value="${user.password}" type="password" id="L_pass" name="password" required=""
							lay-verify="pass" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_pass" class="layui-form-label"> <span
						class="x-red">*</span>电话号码
					</label>
					<div class="layui-input-inline">
						<input value="${user.phone}" type="text" id="L_pass" name="phone" required=""
							lay-verify="pass" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_pass" class="layui-form-label"> <span
						class="x-red">*</span>地址
					</label>
					<div class="layui-input-inline">
						<input value="${user.addr}" type="text" id="L_pass" name="addr" required=""
							lay-verify="pass" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					
					<div class="layui-input-inline">
						<input value="${user.rdate}" type="hidden" id="L_pass" name="" required=""
							lay-verify="pass" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"></label>
					<button class="layui-btn" lay-filter="add" lay-submit="">增加</button>
				</div>
			</form>
		</div>
	</div>


</body>

</html>