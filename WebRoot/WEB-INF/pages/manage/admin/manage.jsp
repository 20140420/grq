<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 后台默认页面 -->
<s:url action="manage_main" namespace="/manage" var="manage_main"></s:url>
<%@include file="/WEB-INF/pages/manage/admin/mheader.jsp"%>
	<div class="sidebar1">  
		<%@include file="/WEB-INF/pages/manage/admin/msidebar.jsp"%>
    <!-- end .sidebar1 --></div>
    <div class="content">
    	<!-- 注意区别不同用户类型 -->
		<s:if test="#session.admin != null">
			[欢迎：<span style="color:red;"> <s:property value="#session.admin.username"/></span>]
		</s:if>
		<s:else>
			[<span style="font-weight:bold;"><s:a action="admin_login" namespace="/admin">请登入</s:a></span>]
		</s:else>
		通知公告
    <iframe src="${manage_main}" name="mdetail" scrolling="auto" frameborder="0" width="100%" height="500px"></iframe>
    <!-- end .content --></div>
<%@include file="/WEB-INF/pages/manage/mfooter.jsp"%>
  