<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
<link href="${context_path}/css/style.css" rel="stylesheet" type="text/css" />
<style>
<!--
td {
	font-size: 12px;
}
-->
</style>
    <div class="content">
<div class="operateoption">
<s:push value="sharkConfig">
  <s:form action="config_save" namespace="/admin/operate" enctype="multipart/form-data" method="post">
	<table>
    	<tr>
          <td colspan="5" align="left">游戏配置</td>
          <td class="col4">
			<div class="switch demo3">
				<s:checkbox name="isBegin"></s:checkbox>
				<label><i></i></label>
			</div>
		  </td>
        </tr>
        <tr>
          <th colspan="5" align="left">配置设置</th>
          <th><s:submit type="text" value="提交修改"></s:submit></th>
          </tr>
        <tr>
          <td>佣金比率：</td>
          <td class="col4"><s:textfield name="commissionRate"  placeholder="0.10"></s:textfield></td>
          <td>彩金池初值：</td>
          <td class="col4"><s:textfield name="initialDividend"></s:textfield></td>
          <td>最高倍数：</td>
          <td class="col4"><s:textfield name="timesMax"></s:textfield></td>
          </tr>
        <tr>
          <td>观察时长：</td>
          <td class="col4"><s:textfield name="timeObserve"></s:textfield></td>
          <td>下注时长：</td>
          <td class="col4"><s:textfield name="timeBet"></s:textfield></td>
          <td>步长毫秒：</td>
          <td class="col4"><s:textfield name="stepTime"></s:textfield></td>
        </tr>
        <tr>
          <td>展示时长：</td>
          <td class="col4"><s:textfield name="timeDisplay"></s:textfield></td>
          <td>等待时长：</td>
          <td class="col4"><s:textfield name="timeWait"></s:textfield></td>
          <td>押注上限：</td>
          <td class="col4"><s:textfield name="betLimit"></s:textfield></td>
        </tr>
        <tr>
          <td>转盘圈数：</td>
          <td class="col4"><s:textfield name="circleNum"></s:textfield></td>
          <td>查看条数</td>
          <td class="col4"><s:textfield name="prizeRecordNum"></s:textfield></td>
          <td>转盘时长：</td>
          <td class="col4"><s:textfield name="timeCircle"></s:textfield></td>
        </tr>
	</table>
  </s:form>
</s:push>
	<table>
        <tr>
          <th colspan="6" align="left">配置记录</th>
        </tr>
        <tr>
          <td align="center">设定日期</td>
          <td align="center">佣金比率</td>
          <td align="center">最高倍数</td>
          <td align="center">时间周期</td>
          <td align="center">押注上限</td>
          <td align="center">是否开启</td>
        </tr>
    <s:iterator value="pageModel.list">
        <tr>
          <td align="center"><s:date name="createTime" format="yyyy年MM月d日" /></td>
          <td align="center"><s:property value="commissionRate" /></td>
          <td align="center"><s:property value="timesMax" /></td>
          <td align="center"><s:property value="timeCycle" /></td>
          <td align="center"><s:property value="betLimit" /></td>
          <td align="center"><s:property value="isBegin" /></td>
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
    <!-- end .content --></div>
