<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jquery text文本框商品数量增加或商品数量减少</title>
<meta name="description" content="jquery text文本框设置左右增加和减少按钮，通过点击按钮text文本框商品数量增加，或text文本框商品数量减少。" />
</head>

<body>

<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/payfor.js"></script>
<link href="<%=basePath%>css/payfor.css" rel="stylesheet" type="text/css" />

	<div class="p_number">
	
		<div style="height:36px;font-size:16px;">商品单价：<strong id="price_item_1">￥350.00</strong></div>
		
		<div class="f_l add_chose">
			<a class="reduce" onClick="setAmount.reduce('#qty_item_1')" href="javascript:void(0)">-</a>
			<input type="text" name="qty_item_1" value="1" id="qty_item_1" onKeyUp="setAmount.modify('#qty_item_1')" class="text" />
			<a class="add" onClick="setAmount.add('#qty_item_1')" href="javascript:void(0)">+</a>
		</div>
		
		<div class="f_l buy">
			总价：<span class="total-font" id="total_item_1">￥89.00</span>
			<input type="hidden" name="total_price" id="total_price" value="" />
			<span class="jifen">购买商品可获得：<b id="total_points">18</b>积分</span>
		</div>
	
	</div>

</body>
</html>
