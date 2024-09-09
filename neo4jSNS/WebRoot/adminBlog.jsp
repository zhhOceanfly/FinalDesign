<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!
	int count = 3;
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  		<base href="<%=basePath%>">
		<title>管理博客</title>
		<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
		<link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
		<script src="../bootstrap/js/jQuery.js"></script>
		<script src="../bootstrap/js/bootstrap.js"></script>
   <style type="text/css">
.col-md-10{
	background-color: #F85C1E; 
	width: 600px; 
	margin: 0px auto; 
	padding: 10px;
}
</style>
<script type="text/javascript">
	
</script>
  </head>
  <body>
	<form action="adminBlog" method="post" style="padding:25px">
	    <h3 style="color:red">Blog</h3>
		<center style="color:#DDBF5E">
		       发布人：<input type="text" name="searchBId" placeholder="学号...空时查找所有日志">
		    <i class="icon-search"></i>&nbsp;<button type="submit" class="btn btn-inverse"> 查找</button>
	    </center>
  </form>
	<div class="container">
	    <div class="row">
	    <c:forEach items="${list}" var="blog">
	        <div class="col-md-10" >
		        <table class="table table-condensed" style="width:100%">
		            <caption style="color:red"><i class="icon-user"></i>${friend name}</caption>
		            <tr><td colspan="2">
		            	<p style="color:#000"><i class="icon-tag"></i>${blog}&nbsp;Includes over 250 glyphs in font format from the Glyphicon Halflings set. Glyphicons Halflings are normally not available for free, but their creator has made them available for Bootstrap free of cost. As a thank you, we only ask that you include a link back to Glyphicons whenever possible.</p>
		            </td></tr>
		            <tr>
		            	<td align="left">
		            		<a href="showBlog?bid=${blog_id}"><i class="icon-th-list"></i>&nbsp;&nbsp;</a>
		            		<a href="goodBlog?bid=${blog_id}&count=<%= count %>"><i class="icon-thumbs-up"></i></a><i style="color:#DDBF5E">${goodCounts}</i>
		            	</td>
		            	<td align="right"><i class="icon-time"></i><i style="color:#DDBF5E">${publishtime}</i></td>
		            </tr>
		            <tr>
		            	<td colspan="2">
		            		<center><a href="deleteBlog?bid=${blog-id}" ><button type="submit" class="btn btn-inverse">删除博客</button></a></center>
		            	</td>
		            </tr>
		        </table>
	        </div>
	        </c:forEach>
	    </div>
	    <br />
	    <center><a href="showSpace?count=<%= count + 3  %>" class="btn btn-default btn-lg" role="button">View more...</a></center>
	</div>
  </body>
</html>
