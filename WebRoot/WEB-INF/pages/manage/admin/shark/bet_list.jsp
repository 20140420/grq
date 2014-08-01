<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/common_admin.jsp"%>
<style>
<!--
td {
	font-size: 12px;
}
-->
</style>
<div id="right">
	<div id="right_top01">
		<table width="693" height="29" border="0">
			<tr>		
				<td align="center">下注者</td>
				<td align="center">下注总数</td>
				<td align="center">单注额度</td>
				<td align="center">总金额</td>
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
				<td align="center">是否统计</td>
			</tr>
		</table>
	</div>
	<div id="right_mid">
		<div id="tiao">
			<table width="693" height="29" border="0">
				<s:iterator value="pageModel.list">
					<tr>
						<td align="center"><s:property value="customer.username" /></td>
						<td align="center"><s:property value="totalBet" /></td>
						<td align="center"><s:property value="single_bet" /></td>
						<td align="center"><s:property value="totalPrice" /></td>
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
						<td align="center"><s:property value="betCount" /></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
<div id="right_foot01">
<s:url action="bet_list" namespace="/admin/operate" var="first">
	<s:param name="pageNo" value="1"></s:param>
</s:url> 
<s:url action="bet_list" namespace="/admin/operate" var="previous">
	<s:param name="pageNo" value="pageModel.pageNo-1"></s:param>
</s:url> 
<s:url action="bet_list" namespace="/admin/operate" var="last">
	<s:param name="pageNo" value="pageModel.bottomPageNo"></s:param>
</s:url> <s:url action="bet_list" namespace="/admin/operate" var="next">
	<s:param name="pageNo" value="pageModel.pageNo+1"></s:param>
</s:url> <s:include value="/WEB-INF/pages/common/page.jsp"></s:include></div>
</div>