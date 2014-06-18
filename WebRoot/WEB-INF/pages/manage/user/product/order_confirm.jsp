<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
<style>
<!--
td {
	font-size: 12px;
}
-->
</style>
<div class="content">
<div >
    <div >
      <div >　<b>&gt;　订单确认</b></div>
      <div >
      <s:form action="order_save" namespace="/order">
      	<s:hidden name="name"></s:hidden>
		<s:hidden name="address"></s:hidden>
		<s:hidden name="mobile"></s:hidden>
		<s:hidden name="paymentWay"></s:hidden>
		<s:set value="%{0}" var="sumall"></s:set>
      <table width="750" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30" bgcolor="#e7f3c3">
            <table width="750" height="30" border="0" cellpadding="0" cellspacing="0" class="green">
              <tr>
                <td width="213" height="30" align="center">商品名称</td>
                <td width="130" align="center">市场价</td>
                <td width="130" align="center">价格</td>
                <td width="104" align="center">数量</td>
              </tr>
            </table></td>
          </tr>
          <s:iterator value="#session.cart">
          <s:set value="%{#sumall +productPrice*amount}" var="sumall"/>
          <tr>
            <td><div >
              <table width="750" height="30" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="213" height="30" align="center"><s:property value="productName"/></td>
                  <td width="130" align="center"><span style="text-decoration: line-through;">
                  ￥<s:property value="productMarketprice"/>元</span>
                  </td>
                  <td width="130" align="center">￥<s:property value="productPrice"/>元<br>
			为您节省：￥<s:property value="productMarketprice*amount - productPrice*amount"/>元</td>
                  <td width="104" align="center" class="red"><s:property value="amount"/></td>
                </tr>
              </table>
            </div></td>
          </tr>
           </s:iterator>
           <tr>
            <td width="750" height="25" align="right">
            	总价：<span style="color:red">￥<s:property value="#sumall"/></span>元　&nbsp;</td>
          </tr>
          <tr>
            <td width="750" height="25"><div ><b>我的信息</b></div></td>
          </tr>
          <tr>
            <td height="60" align="center" valign="middle">
   <table width="100%">
	<tr>
		<td align="right" width="90">收货人姓名：</td>
		<td align="left"><s:property value="name"/></td>
	</tr>
	<tr>
		<td align="right" width="90">收货人地址：</td>
		<td align="left"><s:property value="address"/></td>
	</tr>
	<tr>
		<td align="right" width="90">收货人电话：</td>
		<td align="left"><s:property value="mobile"/></td>
	</tr>
	<tr>
		<td align="right" width="90">货款支付方式：</td>
		<td align="left"><s:property value="paymentWay"/></td>
	</tr>
</table>
            </td>
          </tr>
          <tr>
          	<td colspan="2" align="center">
          	<s:submit value="付　款" type="image" src="%{context_path}/imgsystem/zh03_12.gif"></s:submit>
          	</td>
          </tr>
        </table>
      </s:form>
    </div>
    </div>
</div>
<!-- end .content --></div>