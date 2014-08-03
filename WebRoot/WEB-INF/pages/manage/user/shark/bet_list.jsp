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
<div>
    <div>
      <div>　<b>&gt;　历史下注</b></div>
      <div>
        <table width="750" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30" bgcolor="#e7f3c3">
             <table width="750" height="30" border="0" cellpadding="0" cellspacing="0">
              <tr>
				<td align="center">下注者</td>
				<td align="center">下注总数</td>
				<td align="center">奖项</td>
				<td align="center">创建时间</td>
				<td align="center">燕子</td>
				<td align="center">鸽子</td>
				<td align="center">孔雀</td>
				<td align="center">老鹰</td>
				<td align="center">狮子</td>
				<td align="center">熊猫</td>
				<td align="center">猴子</td>
				<td align="center">兔子</td>
				<td align="center">飞禽</td>
				<td align="center">银鲨</td>
				<td align="center">炸弹</td>
				<td align="center">金鲨</td>
				<td align="center">走兽</td>
				<td align="center">下注单号</td>
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
						<td align="center"><s:property value="customer.username" /></td>
						<td align="center"><s:property value="totalBet" /></td>
						<td align="center"><s:property value="prizeItem.getName()"/></td>
						<td align="center"><s:date name="createTime" format="yyyy年MM月d日HH:mm" /></td>
						<td align="center"><s:property value="swallow" /></td>
						<td align="center"><s:property value="pigeon" /></td>
						<td align="center"><s:property value="peafowl" /></td>
						<td align="center"><s:property value="eagle" /></td>
						<td align="center"><s:property value="lion" /></td>
						<td align="center"><s:property value="panda" /></td>
						<td align="center"><s:property value="monkey" /></td>
						<td align="center"><s:property value="rabbit" /></td>
						<td align="center"><s:property value="bird" /></td>
						<td align="center"><s:property value="silver_shark" /></td>
						<td align="center"><s:property value="bomb" /></td>
						<td align="center"><s:property value="gold_shark" /></td>
						<td align="center"><s:property value="beast" /></td>
						<td align="center"><s:property value="panelBetId" /></td>
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
<%@include file="/WEB-INF/pages/manage/mfooter.jsp"%>