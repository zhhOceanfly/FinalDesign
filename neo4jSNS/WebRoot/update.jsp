<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dw.model.*,java.net.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑资料</title>
	<link type="text/css" href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
		<link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
		<script src="../bootstrap/js/jQuery.js"></script>
		<script src="../bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/updatepassword.js"></script>
<style type="text/css">
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,p,blockquote,th,td
	{
	margin: 0;
	padding: 0;
}
h3, h2, hr {
	color: red;
}
p, td, tr {
	color: #DDBF5E;
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
.jumbotron {
	padding-top: 5px;
	height: 150px;
	background-color: #310B28;
}
.labelError1{line-height: 9px; font-size: 10pt; color: #f40000; border: 1px #ffb8b8 solid; padding: 8px 8px 8px 35px; background: url(/StudentManagerWeb/images/error.png) no-repeat; background-color: #fef2f2;}
</style>
</head>
<body>
   <div class="jumbotron">
		<div class="container">
			<br /><br />
		    <h2>Hello, Oceanfly</h2>
		    <p>世上万物都是千变万化的，变化是大自然永恒的真理！</p>
		</div>
	</div>
	<hr />
	<div class="container">
	    <div class="row">
	        <div class="col-md-5">
	         <h3>个人信息</h3>
		     <form action="pre?method=updateMessage" class="form-signin"  method="post"  onsubmit="return check();">
	 			<table >
	               <tr>
	                <td >性别:</td>
	                <td  ><input type="radio" name="sex" id="sex" class="input" checked="checked">男
	                	<input type="radio" name="sex" id="sex" class="input" >女</td>
	               </tr>
	                <tr>
	                <td >年龄:</td>
	                <td  ><input type="text" name="age" id="age" class="input" placeholder='<c:out value="${student.stAge}"/>' ></td>
	               </tr>
	               <tr>
	                <td >电话号码:</td>
	                <td  ><input type="text" name="tel" id="tel" class="input" placeholder='<c:out value="${student.stTel}"/>' ></td>
	               </tr>
	               <tr>
	                <td >学院:</td>
	                <td  ><input type="text" name="dept" id="dept" class="input" placeholder='<c:out value="${student.stDept}"/>' ></td>
	               </tr>
	               <tr>
	                <td >地址:</td>
	                <td  ><input type="text" name="addr" id="addr" class="input" placeholder='<c:out value="${student.stAddress}"/>' ></td>
	               </tr>
	               <tr>
	                <td >身份证号:</td>
	                <td  ><input type="text" name="idcard" id="idcard" class="input" placeholder='<c:out value="${student.stIdCard}"/>' ></td>
	               </tr>
	               <tr>
	                 <td></td>
	                 <td><button class="btn btn-primary" type="submit">修改</button>
	                      <input type="reset" class="btn btn-success" value="清 除">
	                 </td>
	                 <td></td>
	               </tr>
	            </table>
	         	<font color="red">${error }</font>
	   		</form>
	      </div>
	      <div class="col-md-5">
	          <h3>修改密码</h3>
	          <form action="pre?method=updatePassword" class="form-signin"  method="post"  onsubmit="return check();">
	 			<table >
	               <tr>
	                <td >新密码:</td>
	                <td  ><input type="password" name="newpassword" id="newpassword" class="input"></td>
	                <td><label class="labelError1" id="newpasswordError"> </label></td>
	               </tr>
	               <tr>
	                <td >确定新密码:</td>
	                <td ><input type="password" name="repassword" id="repassword" class="input"></td>
	                <td ><label class="labelError1" id="repasswordError"> </label></td>
	                </tr>
	               <tr>
	                 <td></td>
	                 <td><button class="btn btn-primary" type="submit">修改</button>
	                      <input type="reset" class="btn btn-success" value="清 除">
	                 </td>
	                 <td></td>
	               </tr>
	            </table>
         		<font color="red">${error1 }</font>
    		</form>       	
	        </div>
	    </div>
	 </div>
</body>
</html>