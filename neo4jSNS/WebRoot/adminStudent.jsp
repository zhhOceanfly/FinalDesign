<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!
	private static final int pageSize = 5;
 %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	int pageCounts = (int)session.getAttribute("pageCounts");
	int pageNum = (int)request.getAttribute("page");
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理用户</title>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
	<style type="text/css">
body {
	margin: 0 auto;
	padding: 25px;
}
input[type="text"]{
              height: auto;
	          margin-bottom: 15px;
	          padding: 3px 9px;
            }
center, td, tr {
	color: #DDBF5E;
}
h3 {
	color: red;
}
	</style>
  </head>
  
  <body>
  <form action="adminStudent" method="post">
	    <br /><h3>Student</h3><br /><br />
		<center>
		       学号：<input type="text" name="searchSId" placeholder="学号...空时查找所有用户">
		    <i class="icon-search"></i>&nbsp;<button type="submit" class="btn btn-inverse"> 查找</button>
	    </center>
  </form>
  <div class="table-responsive">
		<table  class="table table-hover table-condensed">
		    <tr style="background: #310B28;">
				<td align="center">
					<strong>学号</strong>
				</td>
				<td align="center">
					<strong>姓名</strong>
				</td>
				<td align="center">
					<strong>性别</strong>
				</td>
				<td align="center">
					<strong>年龄</strong>
				</td>
				<td align="center">
					<strong>电话</strong>
				</td>
				<td align="center">
					<strong>系别</strong>
				</td>
				<td align="center">
					<strong>地址</strong>
				</td>
				<td align="center" >
					<strong>权限</strong>
				</td>
				<td align="center" >
					<strong>注册时间</strong>
				</td>
			</tr>
			<c:forEach items="${list}" var="student">
				<tr class="warning">
					<td>
						<c:out value="${student.stId}" />
					</td>
					<td>
						<c:out value="${student.stName}" />
					</td>
					<td>
						<c:out value="${student.stSex}" />
					</td>
					<td>
						<c:out value="${student.stAge}" />
					</td>
					<td>
						<c:out value="${student.stTel}" />
					</td>
					<td>
						<c:out value="${student.stDept}" />
					</td>
					<td>
						<c:out value="${student.stAddress}" />
					</td>
					<td>
						<a href="deleteStudent?sid=${student.stId}" class="btn btn-danger">删除</a>
					</td>
					<td>
						<c:out value="${student.stRegTime}" />regTime
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
		<br/><br/>
		<nav aria-label="Page navigation">
			  <ul class="pagination">
			    <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			    <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
			    <li class="disabled"><a href="#">2 <span class="sr-only">(current)</span></a></li>
			    <li class="disabled"><a href="#">3 <span class="sr-only">(current)</span></a></li>
			    <li class="disabled"><a href="#">4 <span class="sr-only">(current)</span></a></li>
			    <li class="disabled"><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
			  </ul>
		</nav>
  </body>
</html>
