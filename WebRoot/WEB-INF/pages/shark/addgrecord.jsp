<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>添加游戏记录</title>
</head>
<body>
<div class="container">
	<div class="header"><%@ include file="/WEB-INF/pages/header.jsp"%></div><!-- end .header -->
	<div class="content">
	    <div class="ranking">
	    <s:form action="record_save" namespace="/shark">
	      <table border="1">
            <tr>
              <th scope="col">期号</th>
              <th scope="col">时间</th>
              <th scope="col">费率</th>
              <th scope="col">奖项</th>
              <th scope="col">彩金池</th>
              <th scope="col">燕子倍数</th>
              <th scope="col">鸽子倍数</th>
              <th scope="col">孔雀倍数</th>
              <th scope="col">老鹰倍数</th>
            </tr>
	        <tr>
	          <td>887</td>
	          <td>股如泉887</td>
	          <td>109</td>
	          <td>86880</td>
	          <td>10.02</td>
	          <td>4.32</td>
	          <td>12.35</td>
	          <td>1108</td>
	          <td>666</td>
            </tr>
            <tr>
              <th scope="col">熊猫倍数</th>
              <th scope="col">猴子倍数</th>
              <th scope="col">兔子倍数</th>
              <th scope="col">金鲨倍数</th>
              <th scope="col">燕子总额</th>
              <th scope="col">鸽子总额</th>
              <th scope="col">孔雀总额</th>
              <th scope="col">老鹰总额</th>
              <th scope="col">狮子总额</th>
            </tr>
	        <tr>
	          <td>1887</td>
	          <td>股如泉887</td>
	          <td>109</td>
	          <td>86880</td>
	          <td>10.02</td>
	          <td>4.32</td>
	          <td>12.35</td>
	          <td>1108</td>
	          <td>666</td>
            </tr>
            <tr>
              <th scope="col">熊猫总额</th>
              <th scope="col">猴子总额</th>
              <th scope="col">兔子总额</th>
              <th scope="col">飞禽总额</th>
              <th scope="col">银鲨总额</th>
              <th scope="col">炸弹总额</th>
              <th scope="col">金鲨总额</th>
              <th scope="col">走兽总额</th>
              <th scope="col">单场总额</th>
            </tr>
	        <tr>
	          <td>1887</td>
	          <td>股如泉887</td>
	          <td>109</td>
	          <td>86880</td>
	          <td>10.02</td>
	          <td>4.32</td>
	          <td>12.35</td>
	          <td>1108</td>
	          <td>666</td>
            </tr>
            <tr>
              <td colspan="9" align="center" valign="middle"><s:submit type="text" value="提交记录"></s:submit></td>
            </tr>
          </table>
        </s:form>
	    </div>
	</div>
  <div class="footer"><%@ include file="/WEB-INF/pages/footer.jsp"%><!-- end .footer --></div>
</div>
<script>
// 你的代码
</script>
</body>
</html>

