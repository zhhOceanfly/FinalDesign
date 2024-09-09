<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h4>管理员:<s:property value="#session.exitadmin.adminname" /> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <a style="text-decoration: none" href="${pageContext.request.contextPath}/admin_exitAdmin.action">退出</a></h4>
                
               <br />            
               <br />     
                </div>
                
              
          </div>	
    
    		<div class="sidebar_search">
            <form action="${pageContext.request.contextPath}/user_findByStuid" method="post">
            <input type="text" name="stuid" class="search_input" value="请输入学号进行查询" onclick="this.value=''" />
            <input type="image" class="search_submit" src="${pageContext.request.contextPath}/images/search.png" />
            </form>            
            </div>
    		<div class="sidebar_search">
            <form action="${pageContext.request.contextPath}/user_findByUsername" method="post">
            <input type="text" name="username" class="search_input" value="请输入姓名进行查询" onclick="this.value=''" />
            <input type="image" class="search_submit" src="${pageContext.request.contextPath}/images/search.png" />
            </form>            
            </div>
    
            <div class="sidebarmenu">
            
              
                <a class="menuitem" href="${pageContext.request.contextPath}/notice_noticeAdminPage.action">查看通知消息</a>
                <a class="menuitem" href="${pageContext.request.contextPath}/user_findByPage?page=1">显示学生信息</a>
                <a class="menuitem" href="${pageContext.request.contextPath}/user_addUserPage.action">添加学生信息</a>
                <a class="menuitem" href="${pageContext.request.contextPath}/admin_pubInfoPage.action">发布通知消息</a>
                <a class="menuitem" href="${pageContext.request.contextPath}/blog_findAllBlog.action">查看留言信息</a>
       
            </div>
            
            
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h3>User help desk</h3>
                
                <p>
<!-- Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. -->
<a href="http://222.25.176.4/" style="text-decoration: none;">实验选课系统</a><br />
<a href="http://www.three-thinking.com/index.asp?GOTOswglnow=1" style="text-decoration: none;">学生事务管理系统	</a><br />
<a href="http://www.three-thinking.com/" style="text-decoration: none;">计算机学院三思首页</a><br />
<a href="http://jwc.xidian.edu.cn/" style="text-decoration: none;">西电教务处系统</a><br />
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
    