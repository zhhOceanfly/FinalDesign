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
			        <p>我们渴望说话，却不在乎是否有人倾听!&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--记录你的日志</p>
			        <p><font color="red">${error }</font></p>
			        <p>
			        	<form action="pubBlog" method="post" style="height:0px">
			        		<i class="icon-pencil"></i><textarea type="text" name="blogtext" style="width:60%;height:200px;font-size:12px" placeholder="record here..."></textarea>
			        		<input type="submit" name="" value="发表" style="font-family: 隶书; font-size: 14pt; background-color:#EFE2DF; border: medium none rgb(128,0,128)"/>
			        	</form>
			        </p>
		        </center>
		    </div>
		</div>
	</div>
  </body>
</html>
