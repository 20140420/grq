<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
<div class="assetsilver">
<form action="#" method="post">
<table>
    <tr>
          <td colspan="6" align="left">银币管理</td>
        </tr>
        <tr>
          <th colspan="6" align="left">银币设置</th>
          </tr>
        <tr>
          <td>限额：</td>
          <td class="col4"><input type="text" placeholder="20000" ></td>
          <td>单笔限额：</td>
          <td class="col4"><input type="text" placeholder="由系统给出" ></td>
          <td>兑换汇率：</td>
          <td class="col4"><input type="text" placeholder="1：10" ></td>
          </tr>
        <tr>
          <td>附加比率：</td>
          <td class="col4"><input type="text" placeholder="10%" ></td>
          <td>&nbsp;</td>
          <td class="col4">&nbsp;</td>
          <td>&nbsp;</td>
          <td class="col4">&nbsp;</td>
        </tr>
        <tr>
          <th colspan="2" align="left">银币记录</th>
          <th colspan="3">账单号：<input type="text" name="textfield" id="textfield">
[搜索]</th>
		  <th>>>详情</th>
        </tr>
        <tr>
          <td>账单号</td>
          <td class="col4">转账日期时间</td>
          <td>转账银币</td>
          <td class="col4">转账出让方</td>
          <td align="center">转账接受方</td>
          <td align="center">转账状态</td>
        </tr>
        <tr>
          <td>b2014010601</td>
          <td class="col4">17：05</td>
          <td>3000</td>
          <td class="col4">丿哥</td>
          <td align="center">小妹</td>
          <td align="center">取消</td>
        </tr>
        <tr>
          <td>b2014010602</td>
          <td class="col4">17：16</td>
          <td>2000</td>
          <td class="col4">丿哥</td>
          <td align="center">小妹</td>
          <td align="center">成交</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td class="col4">&nbsp;</td>
          <td>&nbsp;</td>
          <td class="col4">&nbsp;</td>
          <td align="center">&nbsp;</td>
          <td align="center">&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td class="col4">&nbsp;</td>
          <td>&nbsp;</td>
          <td class="col4">&nbsp;</td>
          <td align="center">&nbsp;</td>
          <td align="center">&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td class="col4">&nbsp;</td>
          <td>&nbsp;</td>
          <td class="col4">&nbsp;</td>
          <td align="center">&nbsp;</td>
          <td align="center">&nbsp;</td>
        </tr>
        <tr>
          <td colspan="6" align="right">[首页][上一页][下一页][尾页] [1]/[108] 第[  ]页 [跳转]</td>
        </tr>
        </table>
</form>
   	  </div>
    <!-- end .content --></div>
