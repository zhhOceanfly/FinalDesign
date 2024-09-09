<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>JSP Declarations</TITLE>
<BODY>
<H1>JSP Declarations</H1>

<%!
 int count = 0;      //声明在<%！>内的变量    
  void method(){}    
%>

<%
  int i= 0;             //声明在<% >内的变量
%>

<H1>

count:<%= ++count %></H1>
<br/>

<H1>i:<%= ++i %></H1>    

</BODY>
</HTML>
