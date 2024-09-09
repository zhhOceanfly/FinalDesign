<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Edit Message Page</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style1.css" />

<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>







</head>
<body>
<div id="main_container">

	<%@include file="head.jsp" %>
    
    <div class="main_content">
    
               
                    
                    
                    
                    
    <div class="center_content">  
     
    <div class="left_content">
    	
    	<div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
               <h4>用户名:<s:property value="#session.exituser.username" />&nbsp&nbsp&nbsp&nbsp&nbsp<a style="text-decoration: none" href="${pageContext.request.contextPath}/admin_exitAdmin.action">退出</a></h4>
                
               <br />            
               <br />     
                </div>
                
              
            </div>	
              <div class="sidebarmenu">
            
              
                 <a class="menuitem" href="${pageContext.request.contextPath}/blog_blogPage.action">我要留言</a>
                <a class="menuitem" href="${pageContext.request.contextPath}/notice_noticeUserPage.action">查看通知消息</a>

       
            </div>
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h3>User help desk</h3>
                
                <p>
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                </p>                
                </div>
                <div class="sidebar_box_bottom"></div>
            </div>
            
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h4>Important notice</h4>
            
                <p>
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                </p>                
                </div>
                <div class="sidebar_box_bottom"></div>
            </div>
    
              
    
    </div>  
    
    
  
    
    <div class="right_content">            
    	<h2>Edit Message Page</h2> 
    	<form action="${pageContext.request.contextPath}/blog_saveBlog.action" method="post">
    	<input type="hidden" name="uid" value="<s:property value="#session.exituser.uid" />" />
    	<h2>请书写留言内容：</h2> 
     <h2><textarea rows="18px" cols="60px" name = "content" ></textarea></h2>
     <h2><input type="submit" value="提交" /></h2>
        </form>            



	
      
     
     </div><!-- end of right content-->
            
                    
  </div>   <!--end of center content -->               
                    
                    
    
    
    <div class="clear"></div>
    </div> <!--end of main content-->
	
    
    <div class="footer">
    
    	<div class="left_footer">Copyright ©2016 BOAN Corporation, All Rights Reserved</a></div>
    
    </div>

</div>		
</body>
</html>