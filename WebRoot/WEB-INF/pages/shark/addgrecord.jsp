<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>添加游戏记录</title>
</head>
<body>
<style>
<!--
td input {
	font-size: 12px;
	width: 80px;
}
-->
</style>
<div class="container">
	<div class="header"><%@ include file="/WEB-INF/pages/header.jsp"%></div><!-- end .header -->
	<div class="content">
	    <div class="ranking">
	    <s:form action="record_timesCreate" namespace="/shark">
	      <table border="1">
            <tr>
              <th scope="col">期号</th>
              <th scope="col">狮子倍数</th>
              <th scope="col">费率</th>
              <th scope="col">奖项</th>
              <th scope="col">彩金池</th>
              <th scope="col">燕子倍数</th>
              <th scope="col">鸽子倍数</th>
              <th scope="col">孔雀倍数</th>
              <th scope="col">老鹰倍数</th>
            </tr>
	        <tr>
	          <td><s:textfield name="prizeId" value=""></s:textfield></td>
	          <td><s:textfield name="timesLion" value=""></s:textfield></td>
	          <td><s:textfield name="commissionRate" value=""></s:textfield></td>
	          <td><s:textfield name="prizeName" value=""></s:textfield></td>
	          <td><s:textfield name="dividend" value=""></s:textfield></td>
	          <td><s:textfield name="timesSwallow" value=""></s:textfield></td>
	          <td><s:textfield name="timesPigeon" value=""></s:textfield></td>
	          <td><s:textfield name="timesPeafowl" value=""></s:textfield></td>
	          <td><s:textfield name="timesEagle" value=""></s:textfield></td>
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
	          <td><s:textfield name="timesPanda" value=""></s:textfield></td>
	          <td><s:textfield name="timesMonkey" value=""></s:textfield></td>
	          <td><s:textfield name="timesRabbit" value=""></s:textfield></td>
	          <td><s:textfield name="timesGoldShark" value=""></s:textfield></td>
	          <td><s:textfield name="totalSwallowSum" value=""></s:textfield></td>
	          <td><s:textfield name="totalPigeonSum" value=""></s:textfield></td>
	          <td><s:textfield name="totalPeafowlSum" value=""></s:textfield></td>
	          <td><s:textfield name="totalEagleSum" value=""></s:textfield></td>
	          <td><s:textfield name="totalLionSum" value=""></s:textfield></td>
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
	          <td><s:textfield name="totalPandaSum" value=""></s:textfield></td>
	          <td><s:textfield name="totalMonkeySum" value=""></s:textfield></td>
	          <td><s:textfield name="totalRabbitSum" value=""></s:textfield></td>
	          <td><s:textfield name="totalBirdSum" value=""></s:textfield></td>
	          <td><s:textfield name="totalSilverSum" value=""></s:textfield></td>
	          <td><s:textfield name="totalBombSum" value=""></s:textfield></td>
	          <td><s:textfield name="totalGoldSum" value=""></s:textfield></td>
	          <td><s:textfield name="totalBeastSum" value=""></s:textfield></td>
	          <td><s:textfield name="totalBetSum" value=""></s:textfield></td>
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

