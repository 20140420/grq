<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/common_admin.jsp"%>
<s:form action="order_list" namespace="/admin/product">
	<div id="right">
	<div id="right_top"><img
		src="${context_path}/imgsystem/blue.gif" width="16" height="16" /> <span
		class="word01">订单查询</span></div>
	<div id="right_mid">
	<div id="tiao">
	<table width="685" height="24" border="0">
		<tr>
			<td width="105" height="22" bgcolor="#c6e8ff" align="right">订单号：</td>
			<td><s:textfield name="orderId"></s:textfield></td>
		</tr>
		<tr>
			<td width="105" height="22" bgcolor="#c6e8ff" align="right">订单状态：</td>
			<td><s:radio name="orderState"
				list="@com.grq.model.customizeenum.OrderState@getValues()"
				value="@com.grq.model.customizeenum.OrderState@getValues()[0]"></s:radio></td>
		</tr>
		<tr>
			<td width="105" height="22" bgcolor="#c6e8ff" align="right">会员名：</td>
			<td><s:textfield name="customer.username"></s:textfield></td>
		</tr>
		<tr>
			<td width="105" height="22" bgcolor="#c6e8ff" align="right">收款人：</td>
			<td><s:textfield name="name"></s:textfield></td>
		</tr>
	</table>
	</div>
	</div>
	<div id="right_foot"><s:submit type="image"
		src="%{context_path}/imgsystem/ht_02_18.gif"></s:submit></div>
	</div>
</s:form>