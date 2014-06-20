<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 顾客后台默认页面 -->
<s:url action="customer_main" namespace="/customer" var="customer_main"></s:url>
<%@include file="/WEB-INF/pages/manage/user/mheader.jsp"%>
	<div class="sidebar1">
		<%@include file="/WEB-INF/pages/manage/user/usidebar.jsp"%>
    <!-- end .sidebar1 --></div>
    <div class="content">
    <iframe src="${customer_main}" name="mdetail" scrolling="auto" frameborder="0" width="100%" height="500px"></iframe>
    <!-- end .content --></div>
<%@include file="/WEB-INF/pages/manage/mfooter.jsp"%>
  