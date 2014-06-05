<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>银币实时价</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<%=basePath%>css/charts.css" type="text/css" rel="stylesheet" />
	<script type='text/javascript' src="http://a.tbcdn.cn/s/kissy/1.3.0/kissy-min.js"></script><!--必须联网-->
	<script type='text/javascript' src="<%=basePath%>js/charts.js" charset="utf-8"></script>
  </head>
  
  <body>
    <div id="demo1"></div>
  </body>
</html>
