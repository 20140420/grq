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
<div>
    <div>
      <div>　<b>&gt;　我的订单</b></div>
      <div>
        <table width="750" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30" bgcolor="#e7f3c3">
             <table width="750" height="30" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="158" height="30" align="center">订单号码</td>
                <td width="90" align="center">订单总金额</td>
                <td width="66" align="center">收货人</td>
                <td width="119" align="center">收货地址</td>
                <td width="74" align="center">支付方式</td>
				<td width="112" align="center">创建时间</td>
				<td width="69" align="center">订单状态</td>
              </tr>
             </table>
            </td>
          </tr>
          <s:iterator value="pageModel.list">
          <tr>
            <td>
             <div>
              <table width="750" height="60" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="158" height="30" align="center"><s:property value="orderId"/></td>
                  <td width="90" align="center"><s:property value="totalPrice"/></td>
                  <td width="66" align="center"><s:property value="name"/></td>
                  <td width="119" align="center"><s:property value="address"/></td>
                  <td width="74" align="center"><s:property value="paymentWay.getName()"/></td>
                  <td width="112" align="center"><p><s:date name="createTime" format="yyyy年MM月d日 HH:mm"/></p>
                  </td>
                  <td width="69" align="center"><s:property value="orderState.getName()"/></td>
                </tr>
              </table>
             </div>
            </td>
          </tr>
		  </s:iterator>
		  <tr>
		  	<td colspan="7" align="right" >
	<s:url var="first">
		<s:param name="pageNo" value="1"></s:param>
	</s:url>
	<s:url var="previous">
		<s:param name="pageNo" value="pageModel.pageNo-1"></s:param>
	</s:url>
	<s:url var="last">
		<s:param name="pageNo" value="pageModel.bottomPageNo"></s:param>
	</s:url>
	<s:url var="next">
		<s:param name="pageNo" value="pageModel.pageNo+1"></s:param>
	</s:url>
	<s:include value="/WEB-INF/pages/common/page.jsp"></s:include>
		  	</td>
		  </tr>
        </table>
      </div>
    </div>
</div>

<!-- end .content --></div>