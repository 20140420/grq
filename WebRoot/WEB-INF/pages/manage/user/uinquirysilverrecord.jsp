<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
    <div class="uinquirysilverrecord">
<table border="1">
  <tr>
    <td colspan="8" align="left" scope="row">当日资金明细</td>
  </tr>
  <tr>
    <th scope="col">序号</th>
    <th scope="col">开始时间</th>
    <th scope="col">结束时间</th>
    <th scope="col">可用银币/个</th>
    <th scope="col">可取银币/个</th>
    <th scope="col">银币变动</th>
    <th scope="col">状态</th>
    <th scope="col">说明</th>
  </tr>
  <tr>
    <th scope="row">1</th>
    <td>17：10</td>
    <td>17：15</td>
    <td>2000</td>
    <td>2000</td>
    <td>+2000</td>
    <td>成功</td>
    <td>兑换</td>
    </tr>
  <tr>
    <th scope="row">2</th>
    <td>17：16</td>
    <td>17：21</td>
    <td>1388</td>
    <td>1388</td>
    <td>-612</td>
    <td>成功</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <th scope="row">3</th>
    <td>17：22</td>
    <td>17：27</td>
    <td>3288</td>
    <td>3288</td>
    <td>+1900</td>
    <td>成功</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <th scope="row">4</th>
    <td>17：30</td>
    <td>17：30</td>
    <td>3000</td>
    <td>3000</td>
    <td>-288</td>
    <td>成功</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <th scope="row">5</th>
    <td>18：05</td>
    <td>18：05</td>
    <td>2940</td>
    <td>2940</td>
    <td>-60</td>
    <td>成功</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <th scope="row">6</th>
    <td>18：06</td>
    <td>18：06</td>
    <td>440</td>
    <td>440</td>
    <td>-2500</td>
    <td>成功</td>
    <td>兑现</td>
    </tr>
  <tr>
    <th scope="row">7</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <th scope="row">8</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <th scope="row">9</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <th scope="row">10</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="8" align="right" scope="row">[首页][上一页][下一页][尾页] [1]/[108] 第[  ]页 [跳转]</td>
    </tr>
  </table>
	</div>
  <!-- end .content --></div>
