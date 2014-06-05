<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
<div class="adminuser">
<table border="1">
  <tr>
    <td colspan="4" align="left" >管理员[+]</td>
    <td colspan="4" align="center" >ID：
      <input type="text" name="textfield" id="textfield">
      [搜索]</td>
  </tr>
  <tr>
    <th scope="col">序号</th>
    <th scope="col">ID</th>
    <th scope="col">昵称</th>
    <th scope="col">入职日期</th>
    <th scope="col">状态</th>
    <th scope="col">权限</th>
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
      <option value="3">出差</option>
      <option value="4">休假</option>
    </select></td>
    <td>all</td>
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
    <td class="col4">11,12,13,22</td>
    <td class="col4"><input type="text" placeholder="用于系统测试的用户账号" ></td>
    <td><select name="select" size="1" class="" id="select">
      <option value="1" selected>编辑</option>
      <option value="2">删除</option>
      <option value="3">详情</option>
    </select><input type="submit" value="确认"></td>
    </tr>
  <tr>
    <th scope="row">3</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    </tr>
  <tr>
    <th scope="row">4</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
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

  