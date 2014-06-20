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
<s:set value="%{0}" var="sumall"></s:set>
<div>
    <div>
      <div>　<b>&gt;　我的购物车</b></div>
      <div>
        <table width="750" border="0">
          <tr>
            <td width="688" height="25" align="right">
            	总价：<span style="color:red">￥<s:property value="#sumall"/></span>元　&nbsp;</td>
          </tr>
          <tr>
            <td height="30" bgcolor="#e7f3c3">
             <table width="750" height="30" border="0">
              <tr>
                <td width="213" height="30" align="center">商品名称</td>
                <td width="130" align="center">市场价</td>
                <td width="130" align="center">价格</td>
                <td width="104" align="center">数量</td>
                <td width="111" align="center">删除</td>
              </tr>
             </table>
            </td>
          </tr>
          <s:iterator value="#session.cart">
          <s:set value="%{#sumall +productPrice*amount}" var="sumall"/>
          <tr>
            <td>
             <div>
              <table width="750" height="30" border="0">
                <tr>
                  <td width="213" height="30" align="center"><s:property value="productName"/></td>
                  <td width="130" align="center">
                  	<span style="text-decoration: line-through;">￥<s:property value="productMarketprice"/>元</span>
                  </td>
                  <td width="130" align="center">￥<s:property value="productPrice"/>元<br>
					<span style="color:red">为您节省：￥<s:property value="productMarketprice*amount - productPrice*amount"/>元</span>
				  </td>
                  <td width="104" align="center" class="red"><s:property value="amount"/></td>
                  <td width="111" align="center">
                  <s:a action="cart_delete" namespace="/cart">
					<s:param name="productId" value="productId"></s:param>
					<img src="${context_path}/imgsystem/zh03_03.gif" width="52" height="23" />
				  </s:a>
                  </td>
                </tr>               
              </table>
             </div>
            </td>
          </tr>
          </s:iterator>
          <tr>
            <td height="60" align="center" valign="middle">
            <s:a action="cart_clear" namespace="/cart">
			<img src="${context_path}/imgsystem/zh03_07.gif" width="105" height="32" />
			</s:a>
			<s:a action="sale_main" namespace="/sale">
            <img src="${context_path}/imgsystem/zh03_09.gif" width="150" height="32" />
            </s:a>
            <s:a action="order_add" namespace="/order">
            <img src="${context_path}/imgsystem/zh03_11.gif" width="105" height="32" />
            </s:a>
            </td>
          </tr>
        </table>
      </div>
    </div>
</div>
<!-- end .content --></div>
<%@include file="/WEB-INF/pages/manage/mfooter.jsp"%>