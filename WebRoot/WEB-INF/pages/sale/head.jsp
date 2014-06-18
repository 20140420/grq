<%@ page contentType="text/html; charset=utf-8" language="java"	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/style_index.css" rel="stylesheet" type="text/css" />
<style>
<!--
td {
	font-size: 12px;
}
-->
</style>
<div id="box">
	<div id="dark">
		<s:a action="cart_list" namespace="/cart"><img src="${context_path}/imgsystem/index_03.gif" width="28" height="14" /> 我的购物车</s:a> | <s:a action="order_findByCustomer" namespace="/order">我的订单</s:a>　
		<s:if test="#session.customer != null">
			欢迎 <s:property value="#session.customer.username"/><s:a action="customer_logout" namespace="/customer">[退出]</s:a>
		</s:if>
		<s:else>
			[<s:a action="customer_reg" namespace="/customer">注册</s:a>]
			|[<s:a action="customer_login" namespace="/customer">登入</s:a>]
		</s:else>
	</div>
	<div id="logo">
		<s:form action="product_findByName" method="post" namespace="/sale">
			<div id="sou">
				<s:textfield name="name"></s:textfield><br>
				<div style="margin-top: 5px;">
					<b>热搜商品：</b>
					<s:a action="product_getByCategoryId" namespace="/sale">
						<s:param name="category.id" value="'330'"></s:param>
						软件
					</s:a>
				</div>
			</div>
			<div id="sou_zi">
				<s:submit type="image" src="%{context_path}/imgsystem/index_09.gif" value="搜索"></s:submit>
			</div>
		</s:form>
		<div id="sou_zi01">
		高级搜索<br />
		使用帮助</div>
	</div>
	<div id="menu">
		<s:a action="indexweb" namespace="/">
			<img src="${context_path}/imgsystem/index_12.gif" width="92" height="33" />
		</s:a>
		<s:a action="product_findNewProduct" namespace="/sale">
			<img src="${context_path}/imgsystem/index_13.gif" width="100" height="33" />
		</s:a>
		<s:a action="product_findSellProduct" namespace="/sale">
			<img src="${context_path}/imgsystem/index_14.gif" width="99" height="33" />
		</s:a>
		<s:a action="product_findCommendProduct" namespace="/sale">
			<img src="${context_path}/imgsystem/index_15.gif" width="98" height="33" />
		</s:a>
		<s:a action="product_findEnjoyProduct" namespace="/sale">
			<img src="${context_path}/imgsystem/index_16.gif" width="100" height="33" />
		</s:a>
			<img src="${context_path}/imgsystem/index_19.gif" width="144" height="33" id="z300" />
	</div>
</div>

