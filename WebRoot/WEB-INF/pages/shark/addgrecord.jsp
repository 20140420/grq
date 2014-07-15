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
	          <!-- <td><s:textfield name="prizeId" value=""></s:textfield></td>
	          <td><s:textfield name="timesLion" value="24"></s:textfield></td>
	          <td><s:textfield name="commissionRate" value="0.5"></s:textfield></td>
	          <td><s:textfield name="prizeName" value="RAFFLING"></s:textfield></td>
	          <td><s:textfield name="dividend" value="300"></s:textfield></td>
	          <td><s:textfield name="timesSwallow" value="4"></s:textfield></td>
	          <td><s:textfield name="timesPigeon" value="8"></s:textfield></td>
	          <td><s:textfield name="timesPeafowl" value="12"></s:textfield></td>
	          <td><s:textfield name="timesEagle" value="24"></s:textfield></td> -->
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
	          <!-- <td><s:textfield name="timesPanda" value="12"></s:textfield></td>
	          <td><s:textfield name="timesMonkey" value="8"></s:textfield></td>
	          <td><s:textfield name="timesRabbit" value="4"></s:textfield></td>
	          <td><s:textfield name="timesGoldShark" value="32"></s:textfield></td>
	          <td><s:textfield name="totalSwallowSum" value="122"></s:textfield></td>
	          <td><s:textfield name="totalPigeonSum" value="123"></s:textfield></td>
	          <td><s:textfield name="totalPeafowlSum" value="124"></s:textfield></td>
	          <td><s:textfield name="totalEagleSum" value="125"></s:textfield></td>
	          <td><s:textfield name="totalLionSum" value="126"></s:textfield></td> -->
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
	          <!-- <td><s:textfield name="totalPandaSum" value="112"></s:textfield></td>
	          <td><s:textfield name="totalMonkeySum" value="113"></s:textfield></td>
	          <td><s:textfield name="totalRabbitSum" value="114"></s:textfield></td>
	          <td><s:textfield name="totalBirdSum" value="115"></s:textfield></td>
	          <td><s:textfield name="totalSilverSum" value="116"></s:textfield></td>
	          <td><s:textfield name="totalBombSum" value="117"></s:textfield></td>
	          <td><s:textfield name="totalGoldSum" value="211"></s:textfield></td>
	          <td><s:textfield name="totalBeastSum" value="212"></s:textfield></td>
	          <td><s:textfield name="totalBetSum" value="213"></s:textfield></td> -->
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

