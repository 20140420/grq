<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
    <div class="ugiro">
    <form action="#" method="post">
		<table align="center">
            <tr>
                <th colspan="2" align="center">转入转出</th>
            </tr>
            <tr>
				<td class="col1">来源：</td>
				<td align="center">
				  <select name="select" size="1" class="" id="select">
				    <option value="1">绑定银行到系统平台</option>
				    <option value="2">系统平台到绑定银行</option>
                  </select>
			  </td>
            </tr>

			<tr>
			  <td rowspan="2" class="col1">汇率：</td>
			  <td align="center" class="col2"><input type="text" placeholder="绑定银行" value="绑定银行">：<input type="text" placeholder="系统平台" value="系统平台"></td>
		  </tr>
			<tr>
				<td align="center" class="col2"><input type="text" placeholder="1" value="1">：<input type="text" placeholder="1" value="1"></td>
            </tr>
			<tr>
			  <td rowspan="2" class="col1">金额：</td>
			  <td align="center" class="col2"><input type="text" placeholder="绑定银行" value="绑定银行">
			    -&gt;
			      <input type="text" placeholder="系统平台" value="系统平台">			  </td>
		  </tr>
			<tr>
			  <td align="center" class="col3"><input type="text" placeholder="100">
		      -&gt; 
	            <input type="text" placeholder="100">			  </td>
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
