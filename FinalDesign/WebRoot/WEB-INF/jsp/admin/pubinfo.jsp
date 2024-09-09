
<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Release Notification Message</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/ckeditor/samples/sample.css">




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
    
        
    <h2>Release Notification Message</h2> 
    <form action="${pageContext.request.contextPath}/notice_saveNotice.action" method="post">
   		<input type="hidden" name="aid" value="<s:property value="#session.exitadmin.aid"/>"/>
    	
    <h2>请输入标题:</h2> 
    <input name="title" size="50px" />
    <br /> <br /> <br /> 
     <h2>请编辑正文:</h2> 
	  	<textarea class="ckeditor" name="content"></textarea>
	  	<br />
	  	<input type="submit" value="提交"/>
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