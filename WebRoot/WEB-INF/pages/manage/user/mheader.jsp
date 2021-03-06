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
        <li><s:a action="customer_logout" namespace="/customer">退出</s:a></li>
        <li>
			<s:if test="#session.customer != null">
			<span style="font-weight:bold;"><s:a action="usidebar_uprofile" namespace="/user">[<s:property value="#session.customer.username"/>]</s:a></span>
			</s:if>
			<s:else>
			<span style="font-weight:bold;"><s:a action="customer_login" namespace="/customer">[请登入]</s:a></span>
			</s:else>
		</li>
        <li><a href="#">锁屏</a></li>
        <li><a href="#">刷新</a></li>
        <li><s:a action="usidebar_uinvest" namespace="/user">理财</s:a></li>
        <li><s:a action="usidebar_upassquestion" namespace="/user">安全</s:a></li>
        <li><s:a action="customer_manage" namespace="/customer">系统</s:a></li>
      </ul>
  <!--<a href="#"><img src="" alt="在此处插入徽标" name="Insert_logo" width="180" height="90" id="Insert_logo" style="background-color: #C6D580; display:block;" /></a 
    <!-- end .header --></div>
    
  