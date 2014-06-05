<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
<div class="ubankcard">
<form action="#" method="post" enctype="multipart/form-data">
<table>
        <tr>
          <td colspan="2" align="left">关联银行</td>
        </tr>
        <tr>
          <th colspan="2" align="left">银行</th>
          </tr>
        <tr>
          <td>银行名称</td>
          <td class="col5"><input type="text" placeholder="中国建设银行" ></td>
          </tr>
        <tr>
          <td>银行帐号：</td>
          <td class="col5"><input type="text" placeholder="6210 8115 9450 0363 650" ></td>
          </tr>
        <tr>
          <td>持卡人：</td>
          <td class="col5"><input type="text" placeholder="姜泉" ></td>
          </tr>
        <tr>
          <td colspan="2" align="right"><input type="submit" value="更改"></td>
          </tr>
        </table>
</form>
<form action="#" method="post" enctype="multipart/form-data">
<table>
        <tr>
          <th colspan="2" align="left">第三方</th>
          </tr>
        <tr>
          <td>名称</td>
          <td class="col5"><input type="text" placeholder="支付宝" ></td>
          </tr>
        <tr>
          <td>帐号：</td>
          <td class="col5"><input type="text" placeholder="开发中......" ></td>
          </tr>
        <tr>
          <td>持卡人：</td>
          <td class="col5"><input type="text" placeholder="开发中......" ></td>
          </tr>
        <tr>
          <td colspan="2" align="right"><input type="submit" value="更改"></td>
          </tr>
        </table>
</form>
</div>
    <!-- end .content --></div>
