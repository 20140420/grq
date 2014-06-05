<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
<div class="assetinvest">
<table border="1">
  <tr>
    <td colspan="3" align="left" >投资管理</td>
    <td colspan="8" align="center" >ID：
      <input type="text" name="textfield" id="textfield">
      [搜索]</td>
  </tr>
  <tr>
    <th scope="col">序号</th>
    <th scope="col">ID</th>
    <th scope="col">昵称</th>
    <th scope="col">定额</th>
    <th scope="col">定期</th>
    <th align="center" scope="col">收益率</th>
    <th scope="col">金额</th>
    <th scope="col">开始时间</th>
    <th scope="col">结束时间</th>
    <th scope="col">状态</th>
    <th scope="col">操作</th>
    </tr>
  <tr>
    <th scope="row">1</th>
    <td>10001</td>
    <td>小妹</td>
    <td>1万至小于10万</td>
    <td>一年</td>
    <td>5.5</td>
    <td>16000</td>
    <td>2012-06-20</td>
    <td>2013-06-20</td>
    <td>已结</td>
    <td><input type="submit" value="解约"></td>
    </tr>
  <tr>
    <th scope="row">2</th>
    <td>10002</td>
    <td>尼玛</td>
    <td>0至小于1万</td>
    <td>一年</td>
    <td>5</td>
    <td>6000</td>
    <td>2013-04-25</td>
    <td>2014-01-02</td>
    <td>违约</td>
    <td><input type="submit" value="解约"></td>
    </tr>
  <tr>
    <th scope="row">3</th>
    <td>10086</td>
    <td>丿哥</td>
    <td>10万以上</td>
    <td>一年</td>
    <td>6</td>
    <td>100000</td>
    <td>2013-06-28</td>
    <td>至今</td>
    <td>投资中</td>
    <td><input type="submit" value="解约"></td>
    </tr>
  <tr>
    <th scope="row">4</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <th scope="row">5</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <th scope="row">6</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="center">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <th scope="row">7</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td align="center">&nbsp;</td>
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
    <td align="center">&nbsp;</td>
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
    <td align="center">&nbsp;</td>
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
    <td align="center">&nbsp;</td>
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
