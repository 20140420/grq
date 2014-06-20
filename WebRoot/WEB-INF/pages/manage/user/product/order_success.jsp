<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 后台默认页面 -->
<s:url action="manage_main" namespace="/manage" var="manage_main"></s:url>
<%@include file="/WEB-INF/pages/manage/user/mheader.jsp"%>
	<div class="sidebar1">
		<%@include file="/WEB-INF/pages/manage/user/usidebar.jsp"%>
    <!-- end .sidebar1 --></div>

<div class="content">
付款完成，请等待商家发货！
<p>
	由于在线支付需要提供银行卡号，与银行的接口相连接，此处模拟支付完成。
</p>
<!-- end .content --></div>
<%@include file="/WEB-INF/pages/manage/mfooter.jsp"%>