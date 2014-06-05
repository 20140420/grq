<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
<div class="operatesales">
<table border="1">
  <tr>
    <td colspan="4" align="left" >活动[+]</td>
    <td colspan="4" align="center" >编号：
      <input type="text" name="textfield" id="textfield">
      [搜索]</td>
  </tr>
  <tr>
    <th scope="col">序号</th>
    <th scope="col">编号</th>
    <th scope="col">题目</th>
    <th scope="col">日期</th>
    <th scope="col">来源</th>
    <th scope="col">状态</th>
    <th scope="col">留言/阅读</th>
    <th scope="col">操作</th>
    </tr>
  <tr>
    <th scope="row">1</th>
    <td>10001</td>
    <td>好消息！玩游戏，送溜冰鞋！</td>
    <td>2013-05-28</td>
    <td>原创</td>
    <td><select name="select3" size="1" class="" id="select3">
      <option value="1" selected>有效</option>
      <option value="2">过期</option>
      <option value="3">撤销</option>
    </select></td>
    <td>3/108</td>
    <td><select name="select2" size="1" class="" id="select2">
      <option value="1" selected>编辑</option>
      <option value="2">删除</option>
      <option value="3">详情</option>
    </select><input type="submit" value="确认"></td>
    </tr>
  <tr>
    <th scope="row">2</th>
    <td>10002</td>
    <td>我是一直小小鸟</td>
    <td>2014-01-01</td>
    <td>互联网</td>
    <td><select name="select4" size="1" class="" id="select4">
      <option value="1" selected>有效</option>
      <option value="2">过期</option>
      <option value="3">撤销</option>
    </select></td>
    <td class="col4">0/20</td>
    <td><select name="select" size="1" class="" id="select">
      <option value="1" selected>编辑</option>
      <option value="2">删除</option>
      <option value="3">详情</option>
    </select><input type="submit" value="确认"></td>
    </tr>
  <tr>
    <th scope="row">3</th>
    <td>10086</td>
    <td>充值就送</td>
    <td>2014-01-01</td>
    <td>原创</td>
    <td><select name="select5" size="1" class="" id="select5">
      <option value="1" selected>有效</option>
      <option value="2">过期</option>
      <option value="3">撤销</option>
    </select></td>
    <td><span class="col4">5/202</span></td>
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
