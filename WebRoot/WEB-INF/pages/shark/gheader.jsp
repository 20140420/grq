<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<s:url action="manage_manage" namespace="/pages" var="manage_manage"></s:url>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>

<div>
	<ul class="header-menu">
	 <li><s:a action="indexweb" namespace="/" target="_blank">主页</s:a></li>
	 <li><a href="${manage_manage}" target="_blank">资金</a></li>
	 <li><s:a action="invest_ranking" namespace="/invest" target="_blank">排名</s:a></li>
	 <li><s:a action="shark_grule" namespace="/shark" target="_blank">规则</s:a></li>
	</ul>
<!-- end .header--></div>
