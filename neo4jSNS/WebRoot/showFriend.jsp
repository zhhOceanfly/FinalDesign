<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.dw.dao.impl.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>好友主页</title>
	<link type="text/css" href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
		<link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
		<script src="../bootstrap/js/jQuery.js"></script>
		<script src="../bootstrap/js/bootstrap.js"></script>
		
	<style type="text/css">
p {
	color: #DDBF5E;
}
tr, td {
	color: #4EC42C;
}
h3, h2, hr {
	color: red;
}
.jumbotron {
	padding-top: 5px;
	padding-bottom: 0px;
	background-color: #310B28;
}
	</style>
  </head>
  <body>
	<div class="jumbotron">
	    <div class="container">
	        <h3>Hello, Oceanfly!</h3>
	        <p>this is your information.<br/>
	        if you want to communicate with more people.</p>
	    </div>
    </div>
    <hr />
    <div class="container">
	    <div class="row">
	        <div class="col-md-3">
	            <h3>Friends</h3>
	            <p>list your recent three friends here.</p>
	            <table  class="table table-hover table-condensed">
	            	<tr>
						<td align="center">
							<strong>学号</strong>
						</td>
						<td align="center">
							<strong>姓名</strong>
						</td>
					</tr>
					<c:forEach items="${set}" var="student">
					<tr>
						<td>
							<c:out value="${student.stId}" />
						</td>
						<td>
							<c:out value="${student.stName}" />
						</td>
					</tr>
					</c:forEach>
	            </table>
	            <p><a class="btn btn-default btn-lg" role="button">View more &raquo;</a></p>
	        </div>
	        <div class="col-md-4">
	            <h3>Album</h3>
	            <p>list your recent three photo here.</p>
	            <p><a class="btn btn-default btn-lg" role="button">View more &raquo;</a></p>
	        </div>
	        <div class="col-md-5">
	            <h3>Blog</h3>
	            <p>list your recent five blog here.</p>
	            
	            <p><a class="btn btn-default btn-lg" role="button">View more &raquo;</a></p>
	        </div>
	    </div>
	 </div>
  </body>
</html>