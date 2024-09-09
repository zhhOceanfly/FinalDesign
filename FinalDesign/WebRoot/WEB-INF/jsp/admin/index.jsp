
<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Notification Message Display</title>
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
        
    <h2>Notification Message Display</h2> 
                    
                    
<table id="rounded-corner" summary="2007 Major IT Companies' Profit">
    <thead>
    	<tr>
        	
            <th scope="col" class="rounded">Notification Title</th>
            <th scope="col" class="rounded">Date</th>
            <th scope="col" class="rounded-q4">Delete</th>
        
        </tr>
    </thead>
       
    <tbody>
		<s:iterator var = "c" value="#session.noticelist">
    	<tr>
            <td> <a style="text-decoration: none" href="${pageContext.request.contextPath}/notice_findByNid?nid=<s:property value="#c.nid" />"><s:property value="#c.title" /></a></td>
             <td><s:property value="#c.date" /></td>
			 <td><a href="${pageContext.request.contextPath}/notice_deleteByNid?nid=<s:property value="#c.nid" />" class="ask"><img src="${pageContext.request.contextPath}/images/trash.png" alt="删除" title="" border="0" /></a></td>
          
        </tr>
			</s:iterator>
    	
    	
        
    </tbody>
</table>

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