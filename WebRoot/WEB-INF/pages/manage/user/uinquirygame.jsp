<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
<div class="uinquirygame">
<table border="1">
  <tr>
    <td colspan="5" align="left" scope="row">当日游戏</td>
    <td colspan="3" align="left" scope="row">当日游戏场数</td>
    <td colspan="3" align="left" scope="row">游戏总场数</td>
  </tr>
  <tr>
    <th scope="col">序号</th>
    <th scope="col">开始时间</th>
    <th scope="col">结束时间</th>
    <th scope="col">可用银币/个</th>
    <th scope="col">中奖奖项 </th>
    <th scope="col">倍数</th>
    <th scope="col">押注/个</th>
    <th scope="col">总押注/个</th>
    <th scope="col">收益</th>
    <th scope="col">状态</th>
    <th scope="col">说明</th>
  </tr>
  <tr>
    <th scope="row">1</th>
    <td>16：30</td>
    <td>16：30</td>
    <td>2000</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
    <td>+2000</td>
    <td>成功</td>
    <td>兑换</td>
  </tr>
  <tr>
    <th scope="row">2</th>
    <td>17：04</td>
    <td>17：09</td>
    <td>1388</td>
    <td>猴子</td>
    <td>8</td>
    <td>50</td>
    <td>1012</td>
    <td>-612</td>
    <td>成功</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <th scope="row">3</th>
    <td>17：10</td>
    <td>17：15</td>
    <td>3288</td>
    <td>老鹰</td>
    <td>24</td>
    <td>100</td>
    <td>500</td>
    <td>+1900</td>
    <td>成功</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <th scope="row">4</th>
    <td>17：16</td>
    <td>17：21</td>
    <td>3000</td>
    <td>熊猫</td>
    <td>12</td>
    <td>0</td>
    <td>288</td>
    <td>-288</td>
    <td>成功</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <th scope="row">5</th>
    <td>17：22</td>
    <td>17：27</td>
    <td>2940</td>
    <td>兔子</td>
    <td>6</td>
    <td>40</td>
    <td>300</td>
    <td>-60</td>
    <td>成功</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <th scope="row">6</th>
    <td>17：30</td>
    <td>17：30</td>
    <td>440</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
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
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="11" align="right" scope="row">[首页][上一页][下一页][尾页] [1]/[108] 第[  ]页 [跳转]</td>
    </tr>
  </table>
	</div>
  <!-- end .content --></div>
