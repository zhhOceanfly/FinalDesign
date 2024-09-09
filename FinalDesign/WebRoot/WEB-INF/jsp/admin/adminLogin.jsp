<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>班级信息发布系统管理员登录平台</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style1.css" />
</head>
<body>

<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function toSubmit(){
		var myform = document.getElementById("myform");
		myform.submit();
	};
	
</script>
<div id="main_container">
	<div class="logo"><a href="#"><img height="63px" src="${pageContext.request.contextPath}/images/logo1.png" alt="" title="" border="0" /></a></div>
	
</div>
<div class="logo_box">
	<h3>管理员登录平台</h3>
	<form id="myform" action="${pageContext.request.contextPath}/admin_login.action" name="f" method="post">
		<div class="input_outer">
			<span class="u_user"></span>
			<input id="i1" name="adminname" class="text" onFocus=" if(this.value=='输入ID或用户名登录') this.value=''" onBlur="if(this.value=='') this.value='输入ID或用户名登录'" value="输入ID或用户名登录" style="color: #FFFFFF !important" type="text"/>
		</div>
		<div class="input_outer">
			<span class="us_uer"></span>
			<label class="l-login login_password" style="color: rgb(255, 255, 255);display: block;">输入密码</label>
			<input id="i2" name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" onFocus="$('.login_password').hide()" onBlur="if(this.value=='') $('.login_password').show()" value="" type="password"/>
		</div>
			<span><s:actionerror/></span>

		<div class="mb2"><a class="act-but submit" href="javascript:toSubmit()" style="color: #FFFFFF">管理员登录</a></div>
		
	
	</form>

</div>

</body>
</html>