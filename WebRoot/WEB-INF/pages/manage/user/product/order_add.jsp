<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 后台默认页面 -->
<s:url action="manage_main" namespace="/manage" var="manage_main"></s:url>
<%@include file="/WEB-INF/pages/manage/user/mheader.jsp"%>
	<div class="sidebar1">
		<%@include file="/WEB-INF/pages/manage/user/usidebar.jsp"%>
    <!-- end .sidebar1 --></div>
<style>
<!--
td {
	font-size: 12px;
}
-->
</style>
<div class="content">
<div >
     <s:form action="order_confirm" namespace="/order">
    <div >
      <div >　<b>&gt;　下单结账</b></div>
      <div >
     
        <table width="750" height="35" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="116" align="right" valign="middle">收货人姓名：</td>
            <td width="572" align="left" valign="middle">
            <s:textfield name="name" cssClass="bian" size="40"></s:textfield>
            </td>
          </tr>
        </table>
      </div>
	  <div >
	    <table width="750" height="70" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="116" align="right" valign="middle">收货人地址：</td>
            <td width="572" align="left" valign="middle">
            <s:textarea name="address" cssClass="bian" cols="50" rows="3"></s:textarea>
            </td>
          </tr>
        </table>
	  </div>
	  <div >
	    <table width="750" height="35" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="116" align="right" valign="middle">收货人电话：</td>
            <td width="572" align="left" valign="middle">
            <s:textfield name="mobile" cssClass="bian" size="40"></s:textfield>
            </td>
          </tr>
        </table>
	  </div>
	  <div>
	    <table width="750" height="140" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="116" height="35" align="right" valign="middle">支付方式：</td>
            <td width="572" align="left" valign="middle">
            <p>
				<input type="radio" name="paymentWay" value="网银支付" checked="checked">网银支付
			</p>
			<p>
				<input type="radio" name="paymentWay" value="支付宝">支付宝
			</p>
			<p>
				<input type="radio" name="paymentWay" value="货到付款">货到付款
			</p>
			<p>
				<input type="radio" name="paymentWay" value="邮局汇款">邮局汇款
				收款人地址：吉林省长春市xxx大厦xxx室  收款人姓名：xxx  收款人邮编：xxxx
			</p>
			</td>
          </tr>
        </table>
	  </div>
	  <div>
	    <table width="750" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="688" align="center">
            <s:submit type="image" src="%{context_path}/imgsystem/zh03_12.gif"></s:submit>
           </td>
          </tr>
        </table>
        
	  </div>
    </div>
 </s:form>
</div>
<!-- end .content --></div>
<%@include file="/WEB-INF/pages/manage/mfooter.jsp"%>