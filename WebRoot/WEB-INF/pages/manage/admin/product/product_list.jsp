<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<script src="${context_path}/js/public.js" type="text/javascript"></script>
<link href="${context_path}/css/style_ht.css" rel="stylesheet" type="text/css" />
<style>
<!--
td{font-size: 12px;}
-->
</style>
<div id="right">
<div id="right_top01">
<table width="693" height="29" border="0" class="word01">
	<tr>
		<td width="37" height="27" align="center">ID</td>
		<td width="120" align="center">商品名称</td>
		<td width="78" align="center">所属类别</td>
		<td width="79" align="center">采购价格</td>
		<td width="79" align="center">销售价格</td>
		<td width="79" align="center">是否推荐</td>
		<td width="79" align="center">适应性别</td>
		<td width="52" align="center">编辑</td>
		<td width="52" align="center">删除</td>
	</tr>
</table>
</div>
<div id="right_mid">
<div id="tiao">
<table width="693" height="29" border="0">
	<s:iterator value="pageModel.list">
		<tr>
			<td width="37" height="27" align="center"><s:property value="id" /></td>
			<td width="120" align="center"><s:a action="product_edit"
				namespace="/admin/product">
				<s:param name="id" value="id"></s:param>
				<s:property value="name" />
			</s:a></td>
			<td width="78" align="center"><s:property value="category.name" />
			</td>
			<td width="79" align="center"><s:property value="baseprice" /></td>
			<td width="79" align="center"><s:property value="sellprice" /></td>
			<td width="79" align="center"><s:property value="commend" /></td>
			<td width="79" align="center"><s:property
				value="sexrequest.name" /></td>
			<td width="52" align="center"><s:a action="product_edit"
				namespace="/admin/product">
				<s:param name="id" value="id"></s:param>
				<img src="${context_path}/css/images/rz_15.gif" width="21"
					height="16" />
			</s:a></td>
			<td width="52" align="center"><s:a action="product_del"
				namespace="/admin/product">
				<s:param name="id" value="id"></s:param>
				<img src="${context_path}/css/images/rz_17.gif" width="15"
					height="16" />
			</s:a></td>
		</tr>
	</s:iterator>
</table>
</div>
</div>
<div id="right_foot01"><s:url var="first" action="product_list" namespace="/admin/product">
	<s:param name="pageNo" value="1"></s:param>
</s:url> <s:url var="previous" action="product_list" namespace="/admin/product">
	<s:param name="pageNo" value="pageModel.pageNo-1"></s:param>
</s:url> <s:url var="last" action="product_list" namespace="/admin/product">
	<s:param name="pageNo" value="pageModel.bottomPageNo"></s:param>
</s:url> <s:url var="next" action="product_list" namespace="/admin/product">
	<s:param name="pageNo" value="pageModel.pageNo+1"></s:param>
</s:url> 
<div style="text-align: right; margin-top: 20px;margin-right: 20px;">
	<s:if test="pageModel.pageNo > 1">
		<a href="${first}">首页</a>　<a href="${previous}">上一页</a>
	</s:if>
	<s:else>
		首页　上一页
	</s:else>
	<SPAN style="color: red;">
		　[<s:property value="pageModel.pageNo"/>]　
	</SPAN>
	<s:if test="pageModel.pageNo < pageModel.bottomPageNo">
		<a href="${next}">下一页</a>　<a href="${last}">尾页</a>
	</s:if>
	<s:else>
		下一页　尾页
	</s:else>
</div>
</div>
</div>
