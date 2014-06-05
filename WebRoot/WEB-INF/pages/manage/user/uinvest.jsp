<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
	<div class="uinvest">
    <form action="#" method="post">
		<table align="center">
            <tr>
                <th colspan="2" align="center">固定收益投资</th>
            </tr>
            <tr>
				<td class="col1">定额：</td>
				<td align="center">
				  <select name="select" size="1" class="" id="select">
				    <option value="1">0至小于1万</option>
				    <option value="2" selected="selected">1万至小于10万</option>
				    <option value="2">10万以上</option>
                  </select>
			  </td>
            </tr>

			<tr>
			  <td class="col1">定期：</td>
			  <td align="center" class="col2">
				  <select name="select" size="1" class="" id="select">
				    <option value="1">半年</option>
				    <option value="2" selected="selected">一年</option>
                  </select>
              </td>
		  </tr>
			<tr>
			  <td class="col1">收益率：</td>
				<td align="center" class="col2"><input type="text" placeholder="5.5" value="5.5"></td>
            </tr>
			<tr>
			  <td class="col1">金额：</td>
			  <td align="center" class="col3">￥<input type="text" placeholder="6000"></td>
		    </tr>
			<tr>
			  <td class="col1">资金密码：</td>
			  <td align="center"><input type="text" placeholder="请输入6~8位独立密码"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交">
				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    <input name="重置" type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
    </div>
    <!-- end .content --></div>
