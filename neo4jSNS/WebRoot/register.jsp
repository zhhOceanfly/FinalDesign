<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.dw.model.*,java.net.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>注册Oceanfly社交网站</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery/jquery-1.5.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/register.js"></script>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	function loadImage() {
		document.getElementById("randImage").src = "${pageContext.request.contextPath}/image.jsp?"
				+ Math.random(); //Math.random()方法非常重要，它使每次的请求都不同以便重新发送。如果每次的请求都一样，那么不会重新生成页面
	}
</script>
<style type="text/css">
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,p,blockquote,th,td
	{
	margin: 0;
	padding: 0;
}
body {
	padding-bottom: 40px;
	background: url(../images/bg.jpg) no-repeat center top #310b28;
	margin:0 auto;
	color: #0e4354;
}
#main_container{
	margin:0 auto;
	width:900px;
	padding:0px 0 0px 0;
}
#div1 {
	margin: 0 auto;
	padding: 0;
	width: 80%;
    border-top: 1px solid red;
    
}
.logo{
	float:left;
	padding:35px 0 0 0;
}
.form-signin {
	max-width: 500px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 15px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}

h1 {
	color: #fff;
	background: #06b;
	padding: 10px;
	font-size: 200%;
	text-align: center;
}
h4 {
	padding: 10px;
	text-align: center;
}
button {
	height: 30px;
	width: 80px;
}
a {
	text-align: center;
	color: #0e4354;
	text-decoration: underline;
}
.labelError{line-height: 9px; font-size: 10pt; color: #f40000; border: 1px #ffb8b8 solid; padding: 8px 8px 8px 35px; background: url(/StudentManagerWeb/images/error.png) no-repeat; background-color: #fef2f2;}
</style>
</head>
<body>
<div id="main_container">
		<div class="logo"><a href="#"><img height="63px" src="../images/logo1.png" alt="" title="" border="0" /></a></div>
	</div>
	<br /><br /><br /><br /><br /><br /><br />
<div>
		<form class="form-signin" action="register" method="post" onSubmit="return check()">
			<h2 class="form-signin-heading">欢迎使用Oceanfly社交网站</h2>
			<hr>
		    <table>
		            <tr>
	                     <td ></td>	            
		                 <td><font color="red">${error }</font></td>
		                 <td></td>	  	  
		            </tr>
		            
		     		<tr>
	                     <td align="right">学号：</td>            
		                 <td><input type="text" name="userid" id="userid" class="input" value=""></td>
		                 <td><label class="labelError" id="useridError"></label></td>	  	  
		            </tr>
		            
		            <tr>
	                     <td align="right">姓名：</td>	            
		                 <td><input type="text" name="username" id="username" class="input" value=""></td>
		                 <td><label class="labelError" id="usernameError"></label></td>	  	  
		            </tr>
		            
		             <tr>
	                     <td align="right">密码：</td>	            
		                 <td><input type="password" name="password" id="password" class="input" value=""></td>
		                 <td><label class="labelError" id="passwordError"></label></td>	  	  
		            </tr>
		            
		            <tr>
	                     <td align="right">验证码：</td>	            
		                 <td><input type="text" name="imageValue" size="50px" id="imageValue" class="input" value="${verifyCode }"></td>
		                 <td><label class="labelError" id="imageValueError"></label></td>	  	  
		            </tr>
		            
		             <tr>
	                     <td ></td>	            
		                 <td>
		                  <img onClick="javascript:loadImage();"  title="换一张试试" id="randImage" 
				          src="${pageContext.request.contextPath}/image.jsp" width="100" height="2" border="1" align="absmiddle"></td>
		                 <td> </td>	  	  
		            </tr>
		             
		             <tr>
	                     <td ></td>	            
		                 <td><button type="submit"  class="btn btn-primary">register</button> <input type="reset" class="btn btn-primary" style="height:30px;width:80px" value="rewrite"/></td>
		                 <td></td>	  	  
		            </tr>
		    </table>
		</form>
	</div>

</body>
</html>
