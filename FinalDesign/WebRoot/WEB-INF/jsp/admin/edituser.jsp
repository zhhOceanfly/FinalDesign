
<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Edit Student Information</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>





</head>
<body>
<div id="main_container">

	<div class="header">
   <%@ include file="../head.jsp" %>
    </div>
    
    <div class="main_content">
    
                    
    <div class="center_content">  
    
    
    
    <div class="left_content">
    
    		<%@include file="left.jsp" %>
              
    
    </div>  
    <br/>
    <div class="right_content">            
     <h2>Edit Student Information</h2>
     
         <div class="form">
         <form action="${pageContext.request.contextPath}/user_updateUser.action" method="post" class="niceform">
         
                <fieldset>
                 	<dl>
                        <dt><label for="email">uid:</label></dt>
                        <dd><input type="text" name="uid" id="" size="20" value="<s:property value="model.uid"/>"/></dd>
                    </dl>
                    <dl>
                        <dt><label for="email">姓名:</label></dt>
                        <dd><input type="text" name="username" id="" size="20" value="<s:property value="model.username"/>" /></dd>
                    </dl>
                     <dl>
                        <dt><label for="password">性别:</label></dt>
                        <dd><input type="text" name="gender" id="" size="20" value="<s:property value="model.gender"/>" /></dd>
                    </dl>
                    <dl>
                        <dt><label for="password">学号:</label></dt>
                        <dd><input type="text" name="stuid" id="" size="25" value="<s:property value="model.stuid"/>" /></dd>
                    </dl>
                    <dl>
                        <dt><label for="password">电话:</label></dt>
                        <dd><input type="text" name="phone" id="" size="25" value="<s:property value="model.phone"/>" /></dd>
                    </dl>
                     <dl class="submit">
                    <input type="submit" name="submit" id="submit" value="Submit" />
                     </dl>
                     
                     
                    
                </fieldset>
                
         </form>
         </div>  
      
     
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