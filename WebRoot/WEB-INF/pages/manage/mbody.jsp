<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>股如泉网上交易系统</title>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
<script src="${context_path}/js/jquery.js"></script>
<script src="${context_path}/js/manage.js"></script>
</head>
<body>
<div class="container">
  <div class="header">
      <ul class="header-title">
        <li><a href="#">股如泉网上交易系统</a></li>
      </ul>
      <ul class="header-menu">
        <li><a href="#">退出</a></li>
        <li><a href="${context_path}/login.jsp">登入</a></li>
        <li><a href="#">锁屏</a></li>
        <li><a href="#">刷新</a></li>
        <li><a href="#">理财</a></li>
        <li><a href="#">安全</a></li>
        <li><a href="manage.jsp">系统</a></li>
      </ul>
  <!--<a href="#"><img src="" alt="在此处插入徽标" name="Insert_logo" width="180" height="90" id="Insert_logo" style="background-color: #C6D580; display:block;" /></a 
    <!-- end .header --></div>
  <div class="sidebar1">  
<%
   if(2>1)//注意权限为游客时
   {
%>
       <s:action name="sidebar_usidebar" namespace="/pages" executeResult="true"></s:action>
<%
   }else{
%>
       <s:action name="sidebar_msidebar" namespace="/pages" executeResult="true"></s:action>
<%
   }
%> 
    <!-- end .sidebar1 --></div>
    
  