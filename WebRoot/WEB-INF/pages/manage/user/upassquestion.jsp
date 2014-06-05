<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
<div class="upassquestion">
  <form action="#" method="post">
  <table>
    <tr>
          <td colspan="3" align="left">账户密保</td>
        </tr>
        <tr>
          <th colspan="3" align="left">密码</th>
          </tr>
        <tr>
          <td>登入密码：</td>
          <td class="col4"><input type="password" placeholder="登入时" ></td>
          <td align="center"><input  type="submit" value="修改"></td>
          </tr>
        <tr>
          <td>交易密码：</td>
          <td class="col4"><input type="password" placeholder="银币交易时" ></td>
          <td align="center"><input  type="submit" value="修改"></td>
          </tr>
        <tr>
          <td>资金密码：</td>
          <td class="col4"><input type="password" placeholder="用于资金保护" ></td>
          <td align="center"><input  type="submit" value="修改"></td>
          </tr>
        </table>
</form>
  <form action="#" method="post">
  <table>
        <tr>
          <th colspan="3" align="left">问题口令密保</th>
          </tr>
        <tr>
          <td>问题一：</td>
          <td class="col4"><input type="text" placeholder="" ></td>
          <td align="center"><input  type="submit" value="设置"></td>
          </tr>
        <tr>
          <td>答案一：</td>
          <td class="col4"><input type="text" placeholder="" ></td>
          <td align="center"><input  type="submit" value="设置"></td>
          </tr>
        <tr>
          <td>问题二：</td>
          <td class="col4"><input type="text" placeholder="" ></td>
          <td align="center"><input  type="submit" value="设置"></td>
          </tr>
        <tr>
          <td>答案二：</td>
          <td class="col4"><input type="text" placeholder="" ></td>
          <td align="center"><input  type="submit" value="设置"></td>
          </tr>
        <tr>
          <td>问题三：</td>
          <td class="col4"><input type="text" placeholder="" ></td>
          <td align="center"><input  type="submit" value="设置"></td>
          </tr>
        <tr>
          <td>答案三：</td>
          <td class="col4"><input type="text" placeholder="" ></td>
          <td align="center"><input  type="submit" value="设置"></td>
        </tr>
        </table>
</form>
<form action="#" method="post" enctype="multipart/form-data">
<table>
        <tr>
          <th colspan="3" align="left">邮箱绑定密保</th>
          </tr>
        <tr>
          <td>邮箱：</td>
          <td class="col4"><input type="text" placeholder="初值关联注册登记的" ></td>
          <td align="center"><input type="submit" value="更改"></td>
          </tr>
        </table>
</form>
<form action="#" method="post" enctype="multipart/form-data">
<table>
        <tr>
          <th colspan="3" align="left">手机绑定密保</th>
          </tr>
        <tr>
          <td>手机：</td>
          <td class="col4"><input type="text" placeholder="初值关联注册登记的" ></td>
          <td align="center"><input type="submit" value="更改"></td>
          </tr>
        </table>
</form>
   	  </div>
    <!-- end .content --></div>
