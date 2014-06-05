<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>金鲨银鲨游戏规则</title>
<link href="${context_path}/css/game.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
  <div class="header">
	<ul class="header-title">
        <li>金鲨银鲨游戏规则</li>
	</ul>
	<%@include file="/WEB-INF/pages/shark/gheader.jsp"%> 
  <!-- end .header --></div>
  <div class="sidebar1">      
	<%@include file="/WEB-INF/pages/chat/chattool.jsp"%>  
    <!-- end .sidebar1 --></div>
  <div class="content">
<div class="grule">
<table cellspacing="0">
	<tr>
		<th>燕子</th>
		<th>鸽子</th>
		<th>孔雀</th>
		<th>老鹰</th>
		<th>狮子</th>
		<th>熊猫</th>
		<th>猴子</th>
		<th>兔子</th>
	</tr>
	<tr>
		<td>3</td>
		<td>12</td>
		<td>24</td>
		<td>24</td>
		<td>24</td>
		<td>24</td>
		<td>12</td>
		<td>3</td>
	</tr>
	<tr>
		<td>4</td>
		<td>6</td>
		<td>24</td>
		<td>24</td>
		<td>24</td>
		<td>24</td>
		<td>6</td>
		<td>4</td>
	</tr>
	<tr>
		<td>4</td>
		<td>8</td>
		<td>12</td>
		<td>24</td>
		<td>24</td>
		<td>12</td>
		<td>8</td>
		<td>4</td>
	</tr>
	<tr>
		<td>6</td>
		<td>6</td>
		<td>8</td>
		<td>24</td>
		<td>24</td>
		<td>8</td>
		<td>6</td>
		<td>6</td>
	</tr>
	<tr>
		<td>6</td>
		<td>6</td>
		<td>12</td>
		<td>12</td>
		<td>12</td>
		<td>12</td>
		<td>6</td>
		<td>6</td>
	</tr>
	<tr>
		<td>6</td>
		<td>8</td>
		<td>8</td>
		<td>12</td>
		<td>12</td>
		<td>8</td>
		<td>8</td>
		<td>6</td>
	</tr>
	<tr>
		<td colspan="8">银鲨	24倍+再转一次	</td>
	</tr>
	<tr>
		<td colspan="8">金沙	24倍+再转一次+1~75倍彩金</td>
	</tr>
	<tr>
		<td colspan="8">地雷	不定倍，押中时，其他按键筹码按比例分配给[地雷]押注者；无押注则重转</td>
	</tr>

</table>
</div> 
    <!-- end .content --></div>
  <!--<div class="footer">
    <p>此 .footer 包含声明 position:relative，以便为 .footer 指定 Internet Explorer 6 hasLayout，并使其以正确方式清除。如果您不需要支持 IE6，则可以将其删除。</p>
  </div> end .footer -->
<!-- end .container --></div>
</body>
</html>