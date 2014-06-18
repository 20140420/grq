<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />

<div class="content">
付款完成，请等待商家发货！
<p>
	由于在线支付需要提供银行卡号，与银行的接口相连接，此处模拟支付完成。
</p>
<!-- end .content --></div>