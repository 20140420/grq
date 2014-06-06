<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@include file="/WEB-INF/pages/manage/mheader.jsp"%>
	<div class="sidebar1">  
       <s:action name="manage_sidebar" namespace="/manage" executeResult="true"></s:action>
    <!-- end .sidebar1 --></div>
    <div class="content">
    欢迎！admin
    <iframe src="${usidebar_uinquiryaccount}" name="mdetail" scrolling="auto" frameborder="0" width="100%" height="500px"></iframe>
    <!-- end .content --></div>
<%@include file="/WEB-INF/pages/manage/mfooter.jsp"%>
  