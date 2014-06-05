<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
<div class="playeruser">
<table border="1">
  <tr>
    <td colspan="4" align="left" >玩家[+]</td>
    <td colspan="5" align="center" >ID：
      <input type="text" name="textfield" id="textfield">
      [搜索]</td>
  </tr>
  <tr>
    <th scope="col">序号</th>
    <th scope="col">ID</th>
    <th scope="col">昵称</th>
    <th scope="col">注册日期</th>
    <th scope="col">状态</th>
    <th align="center" scope="col">徒弟数量</th>
    <th scope="col">星标用户</th>
    <th scope="col">备注</th>
    <th scope="col">操作</th>
    </tr>
  <tr>
    <th scope="row">1</th>
    <td>10001</td>
    <td>小妹</td>
    <td>2013-05-28</td>
    <td><select name="select3" size="1" class="" id="select3">
      <option value="1" selected>在线</option>
      <option value="2">离线</option>
      <option value="3">忙碌</option>
      <option value="4">稍息</option>
    </select></td>
    <td align="center">108</td>
    <td>是</td>
    <td><span class="col4">
      <input type="text" placeholder="用于系统测试的用户账号" >
    </span></td>
    <td><select name="select2" size="1" class="" id="select2">
      <option value="1" selected>编辑</option>
      <option value="2">删除</option>
      <option value="3">详情</option>
    </select><input type="submit" value="确认"></td>
    </tr>
  <tr>
    <th scope="row">2</th>
    <td>10002</td>
    <td>尼玛</td>
    <td>2014-01-01</td>
    <td><select name="select4" size="1" class="" id="select4">
      <option value="1" selected>在线</option>
      <option value="2">离线</option>
      <option value="3">出差</option>
      <option value="4">休假</option>
    </select></td>
    <td align="center">6</td>
    <td class="col4">否</td>
    <td class="col4"><input type="text" placeholder="用于系统测试的用户账号" ></td>
    <td><select name="select" size="1" class="" id="select">
      <option value="1" selected>编辑</option>
      <option value="2">删除</option>
      <option value="3">详情</option>
    </select><input type="submit" value="确认"></td>
    </tr>
  <tr>
    <th scope="row">3</th>
    <td>10086</td>
    <td>丿哥</td>
    <td>2014-01-01</td>
    <td><select name="select5" size="1" class="" id="select5">
      <option value="1" selected>在线</option>
      <option value="2">离线</option>
      <option value="3">出差</option>
      <option value="4">休假</option>
    </select></td>
    <td align="center">14</td>
    <td><span class="col4">否</span></td>
    <td><span class="col4">
      <input type="text" placeholder="用于系统测试的用户账号" >
    </span></td>
    <td><select name="select6" size="1" class="" id="select6">
      <option value="1" selected>编辑</option>
      <option value="2">删除</option>
      <option value="3">详情</option>
    </select><input type="submit" value="确认"></td>
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
    </tr>
  <tr>
    <td colspan="9" align="right" scope="row">[首页][上一页][下一页][尾页] [1]/[108] 第[  ]页 [跳转]</td>
    </tr>
  </table>
	</div>
    <!-- end .content --></div>
