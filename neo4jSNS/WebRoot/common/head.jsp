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
		<title>Oceanfly社交网站主页</title>
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
						欢迎：
						<font color="red">Oceanfly</font>&nbsp;&nbsp;&nbsp;
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
					   <a class="brand" href="main.jsp"><i class="icon-home"></i>&nbsp;首页</a>
						<ul class="nav">
							<li><a href="showMe"><i class="icon-user"></i>&nbsp;个人展示 </a></li>
							<li><a href="showAllFriends"><i class="icon-heart"></i>&nbsp;我的好友</a></li>
							<li><a href="showPhoto"><i class="icon-picture"></i>&nbsp;云相册</a></li>
							<li><a href="deepSearch"><i class="icon-search"></i>&nbsp;深度搜索</a></li>
							<!-- <li><a href="pre?method=preupdatetepwd"><i class="icon-cog"></i>&nbsp;修改密码</a></li> -->
							<li><a onclick="check()"><i class="icon-off"></i>&nbsp;退出登录</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
