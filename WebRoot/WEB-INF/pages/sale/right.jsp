<%@ page contentType="text/html; charset=utf-8" language="java"	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/style_index.css" rel="stylesheet" type="text/css" />
<div id="right">
	<!-- 商品排行 -->
	<!-- 人气商品 -->
	<div id="rqpgb">
			<table width="195" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="195" height="31">
						<img src="${context_path}/imgsystem/index_28.gif" width="195" height="29" />
					</td>
				</tr>
				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td valign="top">
						<s:action name="product_findByClick" namespace="/sale" executeResult="true"></s:action>
					</td>
				</tr>
			</table>
	</div>
	<!-- 推荐商品 -->
	<div id="xpss">
			<table width="195" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="195" height="31">
						<img src="${context_path}/imgsystem/index_30.gif" width="195" height="29" />
					</td>
				</tr>
				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td valign="top">
						<s:action name="product_findByCommend" namespace="/sale" executeResult="true"></s:action>
					</td>
				</tr>
			</table>
	</div>
	<!-- 热销商品 -->
	<div id="rxsp">
			<table width="195" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="195" height="31">
						<img src="${context_path}/imgsystem/index_31.gif" width="195" height="29" />
					</td>
				</tr>
				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td valign="top">
						<s:action name="product_findBySellCount" namespace="/sale" executeResult="true"></s:action>
					</td>
				</tr>
			</table>
	</div>
	<!-- <div id="sckf"></div> -->
</div>

