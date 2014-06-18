<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="footer-inner">
	<ul>
		<li><s:a action="bocai_aboutbc" namespace="/bocai">关于我们</s:a></li>
		<li class="split">|</li>
		<li><s:a action="bocai_joinbc" namespace="/bocai">联系我们</s:a></li>
		<li class="split">|</li>
		<li><s:a action="admin_login" namespace="/admin">平台管理</s:a></li>
	</ul>
	<ul>Powered by 股如泉<br/>
		Copyright@2012-2013 伯才. All Rights Reserved
	</ul>
</div>