<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 顾客用户后台页面 -->
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
    <div class="uinquiryaccount">
      <table>
        <tr>
          <td colspan="3" align="left">账户资金</td>
          <td colspan="3" class="col3">最近查询时间：2014-01-02 15:47:11</td>
        </tr>
        <tr>
          <th colspan="6" align="left">银币</th>
        </tr>
        <tr>
          <td>银币余额：</td>
          <td>2000</td>
          <td>可用银币：</td>
          <td>2000</td>
          <td>初始银币：</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>冻结银币：</td>
          <td>&nbsp;</td>
          <td>可取银币：</td>
          <td>&nbsp;</td>
          <td>银币总额：</td>
          <td>2000</td>
        </tr>
        <tr>
          <th colspan="6" align="left">人民币</th>
        </tr>
        <tr>
          <td>人民币余额：</td>
          <td>8388.00</td>
          <td>可用人民币：</td>
          <td>2388.00</td>
          <td>投资人民币：</td>
          <td>6000.00</td>
        </tr>
        <tr>
          <td>冻结人民币：</td>
          <td>800.00</td>
          <td>可取人民币：</td>
          <td>1888.00</td>
          <td>人民币总额：</td>
          <td>8688.00</td>
        </tr>
      </table>
    </div>
<!-- end .content --></div>
<%@include file="/WEB-INF/pages/manage/mfooter.jsp"%>
  