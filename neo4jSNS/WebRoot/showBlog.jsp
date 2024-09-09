<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<title>Oceanfly Blog</title>
		<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
		<link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
		<script src="../bootstrap/js/jQuery.js"></script>
		<script src="../bootstrap/js/bootstrap.js"></script>
   <style type="text/css">
.col-md-10{
	background-color:#F85C1E; 
	width:600px; 
	margin: 0px auto; 
	padding: 10px;
}
</style>
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
			        <h3 style="color:red">Hello, <% request.getAttribute("name"); %>!</h3>
			        <p>也许，在你的生命里，我只是个意外，而在我这里，你是最大的奇迹！</p>
		        </center>
		    </div>
		</div>
		<div class="container">
		    <div class="row">
		        <div class="col-md-10" >
		        <table class="table table-condensed" style="width:100%">
		            <caption style="color:red"><i class="icon-user"></i>${friend name}</caption>
		            <tr><td colspan="2">
		            	<p style="color:#000"><i class="icon-tag"></i>${blog}&nbsp;Includes over 250 glyphs in font format from the Glyphicon Halflings set. Glyphicons Halflings are normally not available for free, but their creator has made them available for Bootstrap free of cost. As a thank you, we only ask that you include a link back to Glyphicons whenever possible.</p>
		            </td></tr>
		            <tr>
		            	<td align="left">
		            		<i class="icon-thumbs-up"></i><i style="color:#DDBF5E">${goodCounts}</i>
		            	</td>
		            	<td align="right"><i class="icon-time"></i><i style="color:#DDBF5E">${publishtime}</i></td>
		            </tr>
		            <!-- <tr><td><i class="icon-user"></i>${friend name}&nbsp;:&nbsp;${comment}</td></tr> -->
		            <tr><td colspan="2">
		            	<form action="comBlog" method="post" style="height:0px">
		            		<i class="icon-pencil"></i><input type="text" name="" value="" style="width:500px;font-size:12px"/>
		            		<input type="submit" name="" value="发送" style="font-family: 隶书; font-size: 14pt; background-color:#EFE2DF; border: medium none rgb(128,0,128)"/>
		            	</form>
		            </td></tr>
		            <c:forEach items="${list}" var="comment">
					<tr style="border:1px solid #000">
						<td colspan="2">
							<p style="color:#000">
								<i class="icon-time"></i><i style="color:#DDBF5E">${publishtime}</i>
								<i class="icon-user"></i>&nbsp;:&nbsp;<c:out value="${comment.comTitle}" />
							</p>
						</td>
					</tr>
					</c:forEach>
		        </table>
		        </div>
		        <br/>
		    </div>
		</div>
	</div>
  </body>
</html>
