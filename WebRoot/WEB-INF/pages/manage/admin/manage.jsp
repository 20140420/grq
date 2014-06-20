<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 管理员后台默认页面 -->
<s:url action="admin_main" namespace="/admin" var="admin_main"></s:url>
<%@include file="/WEB-INF/pages/manage/admin/mheader.jsp"%>
	<div class="sidebar1">  
		<%@include file="/WEB-INF/pages/manage/admin/msidebar.jsp"%>
    <!-- end .sidebar1 --></div>
    <div class="content">
    <iframe src="${admin_main}" name="mdetail" scrolling="auto" frameborder="0" width="100%" height="500px"></iframe>
    <!-- end .content --></div>
<%@include file="/WEB-INF/pages/manage/mfooter.jsp"%>
  