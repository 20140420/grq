<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>游戏一个周期</title>
<meta name="description" content="描述功能" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/shark_cycle.js"></script>
<link href="<%=basePath%>css/shark_cycle.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="colockbox" id="demo01">
	<span class="day">-</span>
	<span class="hour">-</span>
	<span class="minute">-</span>
	<span class="second">-</span>
</div>

<div class="colockbox" id="demo02">
	<span class="hour">-</span>
	<span class="minute">-</span>
	<span class="second">-</span>
</div>

<div class="colockbox" id="demo03">
	<span class="second">-</span>
</div>

<div class="colockbox" id="demo04">
	<span class="second">-</span>
</div>

</body>
</html>
