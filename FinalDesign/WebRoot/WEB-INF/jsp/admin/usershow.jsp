
<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IN ADMIN PANEL | Collect from INDEZINER</title>
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
    <br />
    
    <div class="right_content">            
        
    <h2>Student Information Display<s:actionerror /></h2> 
<!--判断session中的list中是否有值，如果没有值则不现实表格  -->
<s:if test="#session.userlist[0]!=null">                
                    
<table id="rounded-corner" summary="2007 Major IT Companies' Profit">
    <thead>
    	<tr>
            <th scope="col" class="rounded">姓名</th>
            <th scope="col" class="rounded">学号</th>
            <th scope="col" class="rounded">性别</th>
            <th scope="col" class="rounded">电话</th>
            <th scope="col" class="rounded">Edit</th>
            <th scope="col" class="rounded-q4">Delete</th>
        </tr>
    </thead>
       
    <tbody>
    	<s:iterator var="c" value="#session.userlist">
    	<tr>
            <td><s:property value="#c.username"/></td>
            <td><s:property value="#c.stuid" /></td>
            <td><s:property value="#c.gender" /></td>
            <td><s:property value="#c.phone" /></td>
			
            <td><a href="${pageContext.request.contextPath}/user_findByUid?uid=<s:property value="#c.uid" />"><img src="${pageContext.request.contextPath}/images/user_edit.png" alt="编辑" title="" border="0" /></a></td>
            <td><a href="${pageContext.request.contextPath}/user_deleteByUid?uid=<s:property value="#c.uid" />" class="ask"><img src="${pageContext.request.contextPath}/images/trash.png" alt="删除" title="" border="0" /></a></td>
        </tr>
        </s:iterator>
    	
        
    </tbody>
</table>
</s:if>    
	<br />
     
        
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