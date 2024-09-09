<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>Oceanfly社交网站后台管理</title>
		<style type="text/css">
			img {
				width: 100%;
				height: 120px;
			}
		</style>
	</head>

	<body>
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1" class="active"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="../images/logo6.png" alt="">
      
      <div style="position:absolute; z-index:2; right:10px; top:100px">
						<font color="red">Oceanfly后台管理系统</font>&nbsp;&nbsp;&nbsp;
						 <i class="icon-time"></i>&nbsp;&nbsp;<font id="today"></font>
						</div>
    </div>
    <div class="item">
      <img src="../images/logo7.jpg" alt="">
    </div>
  </div>
		<div class="row-fluid">
			<div class="span12">
				<div class="navbar">
					<div class="navbar-inner">
					   <a class="brand" href="adminmain.jsp"><i class="icon-home"></i>&nbsp;首页</a>
						<ul class="nav">
							<li><a href="adminStudent"><i class="icon-user"></i>&nbsp;用户后台管理 </a></li>
							<li><a href="adminBlog"><i class="icon-th-list"></i>&nbsp;日志后台管理</a></li>
							<li><a onclick="check()"><i class="icon-off"></i>&nbsp;退出登录</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
