
<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Student Information List</title>
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
        
    <h2>Student Information List</h2> 
    <h2><s:actionmessage /></h2> 
                    
                    
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
    	<s:iterator var="c" value="#session.pageBean.list">
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

	<br />
     <!-- 判断当前页是否是第一页，是则显示首页，上一下（这两个没有超链接），显示下一页超链接访问findByPage方法同时传入的参数是page=当前页数+1，尾页超链接访问findByPage方法同时传入的参数是page=总的页数；
  判断当前页是否是最后一页，是则显示下一页，尾页（这两个没有超链接），显示上一页超链接访问findByPage方法同时传入的参数是page=当前页数-1，首页超链接访问findByPage方法同时传入的参数是page=1； -->
     
        <div class="pagination">
        <s:if test="#session.pageBean.page!=1">
        <a href="${pageContext.request.contextPath}/user_findByPage?page=1">首页</a>
    	<a href="${pageContext.request.contextPath}/user_findByPage?page=<s:property value="#session.pageBean.page-1" />"><< 上一页</a>
    	 
        </s:if>
        <s:if test="#session.pageBean.page == 1">
        		 <a>首页</a>
    			<a><< 上一页</a>
        	</s:if>
        <span class="current"><s:property value="#session.pageBean.page" /></span>--<span class="current"><s:property value="#session.pageBean.totalPage" /></span>
        <s:if test="#session.pageBean.page==#session.pageBean.totalPage">
    	  <a>下一页 >></a>
        <a>>尾页</a>
    	 </s:if>
        <s:if test="#session.pageBean.page!=#session.pageBean.totalPage">
        	
        <a href="${pageContext.request.contextPath}/user_findByPage?page=<s:property value="#session.pageBean.page+1" />">下一页 >></a>
        <a href="${pageContext.request.contextPath}/user_findByPage?page=<s:property value="#session.pageBean.totalPage" />">尾页</a>
        </s:if>
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