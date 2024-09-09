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
		<title>Oceanfly Space</title>
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
<div style="line-height:30px; background-color:#310B28; height:300px; width:150px; float:left; padding:30px" >
<p class="bg-danger"><a href="http://222.25.176.4/" target="_blank" style="color:#D035BE; text-decoration: none;">实验选课系统</a><br /></p>
<p class="bg-success"><a href="http://jwxt.xidian.edu.cn" target="_blank" style="color:#D035BE; text-decoration: none;">URP综合教务系统</a><br /></p>
<p class="bg-info"><a href="http://www.three-thinking.com/" target="_blank" style="color:#D035BE; text-decoration: none;">三思首页</a><br /></p>
<p class="bg-warning"><a href="http://jwc.xidian.edu.cn/" target="_blank" style="color:#D035BE; text-decoration: none;">西电教务处系统</a><br /></p>     
<p class="bg-warning"><a href="http://123.xidian.edu.cn/" target="_blank" style="color:#D035BE; text-decoration: none;">西电123导航</a><br /></p>     
<p class="bg-warning"><a href="http://job.xidian.edu.cn/index.html" target="_blank" style="color:#D035BE; text-decoration: none;">西电就业信息网</a><br /></p>     
</div>
    <div id="bigdiv" style="width:60%; float:left; padding:10px">
		<div class="jumbotron">
		    <div class="container" style="padding-left: 40px">
		    	<center style="color:#DDBF5E; text-align:left">
			        <h3 style="color:red">Hello, Oceanfly!</h3>
			        <p>Oceanfly是一个开放的空间，一直伸往未知的领域！</p>
			        <p><a href="pubBlog.jsp" class="btn btn-primary btn-lg" role="button">Write me here &raquo;</a></p>
		        </center>
		    </div>
		</div>
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
			            		<a href="goodBlog?bid=${blog_id}"><i class="icon-thumbs-up"></i></a><i style="color:#DDBF5E">${goodCounts}</i>
			            	</td>
			            	<td align="right"><i class="icon-time"></i><i style="color:#DDBF5E">${publishtime}</i></td>
			            </tr>
			            <!-- <tr><td><i class="icon-user"></i>${friend name}&nbsp;:&nbsp;${comment}</td></tr> -->
			            <tr><td colspan="2">
			            	<form action="comBlog?id=${blog_id}" method="get" style="height:0px">
			            		<i class="icon-pencil"></i><input type="text" name="comtext" value="" placeholder="最多输入30个字..." style="width:500px;font-size:12px"/>
			            		<input type="submit" name="" value="发送" style="font-family: 隶书; font-size: 14pt; background-color:#EFE2DF; border: medium none rgb(128,0,128)"/>
			            	</form>
			            </td></tr>
			        </table>
		        </div>
		        <br/>
		        </c:forEach>
		    </div>
		    <center><a href="showSpace?count=<%= count + 3  %>" class="btn btn-default btn-lg" role="button">View more...</a></center>
		</div>
	</div>
  </body>
</html>
