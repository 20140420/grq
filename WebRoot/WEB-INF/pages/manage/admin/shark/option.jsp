<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path" value="#request.get('javax.servlet.forward.context_path')"></s:set>
<link href="${context_path}/css/manage.css" rel="stylesheet" type="text/css" />
    <div class="content">
<div class="operateoption">
<s:form action="config_save" namespace="/admin/operate" enctype="multipart/form-data" method="post">
	<table>
    	<tr>
          <td colspan="6" align="left">游戏配置</td>
        </tr>
        <tr>
          <th colspan="5" align="left">配置设置</th>
          <th><s:submit type="text" value="提交修改"></s:submit></th>
          </tr>
        <tr>
          <td>佣金比率：</td>
          <td class="col4"><input type="text" placeholder="10%" ></td>
          <td>彩金池：</td>
          <td class="col4"><input type="text" placeholder="1000" ></td>
          <td>最高倍数：</td>
          <td class="col4"><input type="text" placeholder="99" ></td>
          </tr>
        <tr>
          <td>观察时长：</td>
          <td class="col4"><input type="text" placeholder="5" ></td>
          <td>下注时长：</td>
          <td class="col4"><input type="text" placeholder="30" ></td>
          <td>转盘时长：</td>
          <td class="col4"><s:textfield name="timeCircle"></s:textfield></td>
        </tr>
        <tr>
          <td>转盘圈数：</td>
          <td class="col4"><input type="text" placeholder="2" ></td>
          <td>展示时长：</td>
          <td class="col4"><input type="text" placeholder="5" ></td>
          <td>押注上限：</td>
          <td class="col4"><input type="text" placeholder="5000" ></td>
        </tr>
	</table>
</s:form>
	<table>
        <tr>
          <th colspan="2" align="left">配置记录</th>
          <th colspan="4">配置号：<input type="text" name="textfield" id="textfield">[搜索]</th>
        </tr>
        <tr>
          <td>配置号</td>
          <td class="col4">佣金比率/%</td>
          <td>彩金池/个</td>
          <td class="col4">最高倍数</td>
          <td align="center">时间周期/秒</td>
          <td align="center">押注上限/个</td>
        </tr>
        <tr>
          <td>20130910</td>
          <td class="col4">10</td>
          <td>1000</td>
          <td class="col4">99</td>
          <td align="center">45</td>
          <td align="center">5000</td>
        </tr>
        <tr>
          <td>20140106</td>
          <td class="col4">15</td>
          <td>2000</td>
          <td class="col4">99</td>
          <td align="center">45</td>
          <td align="center">10000</td>
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
</div>
    <!-- end .content --></div>
