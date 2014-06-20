<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 后台默认页面 -->
<s:url action="manage_main" namespace="/manage" var="manage_main"></s:url>
<%@include file="/WEB-INF/pages/manage/user/mheader.jsp"%>
	<div class="sidebar1">
		<%@include file="/WEB-INF/pages/manage/user/usidebar.jsp"%>
    <!-- end .sidebar1 --></div>
<style>
</style>
<div class="content">
      <div align="center">
      	<br>
        <h3>对不起，本订单中并未添加任何商品信息！</h3>
      </div>
<!-- end .content --></div>
<%@include file="/WEB-INF/pages/manage/mfooter.jsp"%>