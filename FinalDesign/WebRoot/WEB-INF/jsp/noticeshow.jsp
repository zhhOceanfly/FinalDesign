<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IN ADMIN PANEL | Collect from INDEZINER</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style1.css" />

<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>







</head>
<body>
<div id="main_container">

	<%@ include file="head.jsp" %>
    
    <div class="main_content">
        
      
                    <div class="menu">
                    <ul>
                    	
						 <li><a class="current" href="#"  onclick ="javascript:history.go(-1);">返回</a></li>
                    </ul>
                    </div> 
                    
                    
                    
                    
    <div class="center_content">  
     
    
    
  
    
    <h2> <s:property value="model.content" escape="false" /></h2>
    <div class="right_content">            
        
                    
 

	
      
     
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