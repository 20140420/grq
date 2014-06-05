<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>金鲨银鲨</title>
<link href="${context_path}/css/game.css" rel="stylesheet" type="text/css" />
<script src="${context_path}/js/jquery.js"></script>
</head>
<body>
<div class="noscript">
  <h2 style="color: #ff0000">你的浏览器不支持Javascript！ 本页基于Javascript的Websockets功能不能用。请打开Javascript功能并重载页面！</h2></div>
<div class="container">	
  <div class="header">
	<ul class="header-title">
        <li>【金鲨银鲨-第一桌】</li>
	</ul>
	<%@include file="/WEB-INF/pages/shark/gheader.jsp"%>
  <!-- end .header --></div>
  <!-- left-chat -->
  <div class="sidebar1">
  	<%@include file="/WEB-INF/pages/chat/chattool.jsp"%>
    <!-- end .sidebar1 --></div>
    
  <div class="content">
  	<div class="content-gdial">
  	<s:action name="shark_gdial" namespace="/shark" executeResult="true"></s:action>
    </div>  
      
    <div class="content-gpanel">
    <s:action name="shark_gpanel" namespace="/shark" executeResult="true"></s:action>
    </div>
  <!-- end .content --></div>
<!-- end .container --></div>
<script src="${context_path}/js/shark.js"></script>
</body>
</html>