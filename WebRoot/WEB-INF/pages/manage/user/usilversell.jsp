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
    	<div class="usilversell">
    <form action="#" method="post">
		<table align="center">
            <tr>
                	<th colspan="3" align="center">银币卖出</th>
            </tr>
            <tr>
			  <td class="col1">对象：</td>
				<td align="right" valign="middle">
				  <select name="select" size="1" class="" id="select">
				    <option value="1" selected="selected">系统</option>
				    <option value="2">师徒</option>
				    <option value="3">其他</option>
		        </select>
			  </td>
              <td class="col4"><input type="text" placeholder="显示用户昵称"></td>
			</tr>

			<tr>
			  <td rowspan="2" class="col1">比率：</td>
			  <td colspan="2" align="center" class="col2"><input type="text" placeholder="人民币" value="人民币">：<input type="text" placeholder="银币" value="银币"></td>
		  </tr>
			<tr>
				<td colspan="2" align="center" class="col2"><input type="text" placeholder="1" value="1">：<input type="text" placeholder="10" value="10"></td>
          </tr>
			<tr>
			  <td class="col1">附加扣除：</td>
			  <td colspan="2" align="center" class="col3"><input type="text" placeholder="-10">%</td>
		    </tr>
			<tr>
			  <td rowspan="2" class="col1">交易量：</td>
			  <td colspan="2" align="center" class="col2"><input type="text" placeholder="银币" value="银币">-&gt;<input type="text" placeholder="人民币" value="人民币"></td>
		  </tr>
			<tr>
			  <td colspan="2" align="center" class="col3"><input type="text" placeholder="110">-&gt;<input type="text" placeholder="99"></td>
	      </tr>
			<tr>
			  <td class="col1">交易密码：</td>
			  <td colspan="2" align="center"><input type="text" placeholder="请输入6~8交易密码"></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit" value="提交">
				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    <input name="重置" type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
    </div>
    <!-- end .content --></div>
<%@include file="/WEB-INF/pages/manage/mfooter.jsp"%>