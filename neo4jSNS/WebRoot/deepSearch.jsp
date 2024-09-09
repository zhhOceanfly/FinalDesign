<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>深度搜索</title>
	<link type="text/css" href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
		<link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
		<script src="../bootstrap/js/jQuery.js"></script>
		<script src="../bootstrap/js/bootstrap.js"></script>
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
  <form action="deepSearch" method="post">
	    <h3>深度搜索</h3>
		 <center>
		<table>
		<tr>
			<td>学号：<input type="text" name="id" placeholder="学号...不为空查找指定学生">
			<br />姓名：<input type="text" name="name" placeholder="姓名..."></td>
			<td>年龄：<input type="text" name="age" placeholder="年龄...">
			<br />学院：<input type="text" name="dept" placeholder="学院..."></td>
		    <br />
		 </tr>
		 <tr>
		    <td colspan="2" align="center">
		    深度：
			<select name="deepth" id="deepth" style="width:50px">   
		        <option value="1">1</option>   
		        <option value="2">2</option>   
		        <option value="3">3</option>   
		        <option value="4">4</option>   
		        <option value="5">5</option>       
		      </select>   
		      &nbsp;&nbsp;<i class="icon-search"></i>&nbsp;<button type="submit" class="btn btn-inverse"> 查找</button>
	    </td>
	    </tr>
	    </table>
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
			</tr>
			<c:forEach items="${list}" var="student">
				<tr>
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
						<a href="addFriend?id=${student.stId}" class="btn btn-primary">加为好友</a>
						<font color="red">${error }</font>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
  </body>
</html>
