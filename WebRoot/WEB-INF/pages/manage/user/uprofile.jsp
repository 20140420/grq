<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
    	<div class="uprofile">
<form action="#" method="post">
<table>
    <tr>
          <td colspan="6" align="left">个人资料</td>
        </tr>
        <tr>
          <th colspan="6" align="left">基本资料</th>
          </tr>
        <tr>
          <td>ID：</td>
          <td class="col4"><input type="text" placeholder="系统生产的ID" ></td>
          <td>昵称：</td>
          <td class="col4"><input type="text" placeholder="个人与团队" >          </td>
          <td>邮箱：</td>
          <td class="col4"><input type="text" placeholder="595121869@qq.com" ></td>
        </tr>
        <tr>
          <td>手机：</td>
          <td class="col4"><input type="text" placeholder="13216680533" ></td>
          <td>师傅：</td>
          <td class="col4"><input type="text" placeholder="由系统给出" ></td>
          <td>徒弟数量：</td>
          <td class="col4"><input type="text" placeholder="由系统给出" ></td>
        </tr>
        <tr>
          <td>注册时间：</td>
          <td class="col4"><input type="text" placeholder="由系统给出" ></td>
          <td>最近登入：</td>
          <td class="col4"><input type="text" placeholder="由系统给出" ></td>
          <td>在线时长：</td>
          <td class="col4"><input type="text" placeholder="由系统给出" ></td>
        </tr>
        </table>
</form>
<form action="#" method="post" enctype="multipart/form-data">
<table>
        <tr>
          <th colspan="5" align="left">详细资料</th>
          <th><input  type="submit" value="修改"></th>
        </tr>
        <tr>
          <td>姓名：</td>
          <td class="col4"><input type="text" placeholder="姜泉" ></td>
          <td>曾用名：</td>
          <td class="col4"><input type="text" placeholder="姜海泉" >          </td>
          <td colspan="2" rowspan="5" align="center"><img src="" alt="在此处插入徽标" width="120" height="150" style="background-color: #C6D580; display:block;"/></td>
          </tr>
        <tr>
          <td>年龄：</td>
          <td class="col4"><input type="text" placeholder="24" ></td>
          <td>职业：</td>
          <td class="col4"><input type="text" placeholder="结构工程师" ></td>
          </tr>
        <tr>
          <td>生日：</td>
          <td class="col4"><input type="text" placeholder="01月01日" ></td>
          <td>风险承受：</td>
          <td class="col4"><input type="text" placeholder="13216680533" ></td>
          </tr>
        <tr>
          <td>游戏场数：</td>
          <td class="col4"><input type="text" placeholder="由系统给出" ></td>
          <td>qq:</td>
          <td class="col4"><input type="text" placeholder="595121869" ></td>
          </tr>
        <tr>
          <td>星标用户：</td>
          <td><input type="radio" name="asterisk" value="1">
            是&nbsp;&nbsp;
            <input name="asterisk" type="radio" value="0" checked="CHECKED">
            否</td>
          <td>性别：</td>
          <td align="center"><input type="radio" name="sex" value="1" checked>
          男&nbsp;&nbsp;
          <input type="radio" name="sex" value="0">
          女</td>
          </tr>
        <tr>
          <td>身份证：</td>
          <td colspan="3" class="col4"><textarea rows="1" class="textarea1" placeholder="330881198901244315"></textarea></td>
          <td>头像：</td>
          <td class="col4"><input type="file"  name="photo"></td>
        </tr>
        <tr>
          <td>座右铭：</td>
          <td colspan="5" class="col4"><textarea name="textarea" rows="1"  class="textarea2" placeholder="新视角，看世界；新方式，兴中国！"></textarea></td>
          </tr>
        <tr>
          <td colspan="6" align="center"><input type="submit" value="保存">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input name="重置" type="reset" value="取消"></td>
        </tr>
</table>
</form>
    	</div>
    <!-- end .content --></div>
