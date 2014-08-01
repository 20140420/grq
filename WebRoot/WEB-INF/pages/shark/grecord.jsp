<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>游戏记录</title>
<!--<link href="../../css/web.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css_example_url" />
<script src="js_example_url"></script>-->
</head>
<body>
<div class="grecord">
	<div class="header"><%@ include file="/WEB-INF/pages/header.jsp"%></div><!-- end .header -->
	<div>
	    <div>
	      <table border="1">
            <tr>
              <th scope="col">期号</th>
              <th scope="col">奖项</th>
              <th scope="col">燕子</th>
              <th scope="col">鸽子</th>
              <th scope="col">孔雀</th>
              <th scope="col">老鹰</th>
              <th scope="col">狮子</th>
              <th scope="col">熊猫</th>
              <th scope="col">猴子</th>
              <th scope="col">兔子</th>
              <th scope="col">飞禽</th>
              <th scope="col">银鲨</th>
              <th scope="col">炸弹</th>
              <th scope="col">金鲨</th>
              <th scope="col">走兽</th>
            </tr>
            <s:iterator value="pageModel.list">
	        <tr>
	          <th scope="col"><s:property value="prizeId" /></th>
	          <td align="center"><s:property value="prizeName" /></td>
	          <td align="center"><s:property value="totalSwallowSum" /></td>
	          <td align="center"><s:property value="totalPigeonSum" /></td>
	          <td align="center"><s:property value="totalPeafowlSum" /></td>
	          <td align="center"><s:property value="totalEagleSum" /></td>
	          <td align="center"><s:property value="totalLionSum" /></td>
	          <td align="center"><s:property value="totalPandaSum" /></td>
	          <td align="center"><s:property value="totalMonkeySum" /></td>
	          <td align="center"><s:property value="totalRabbitSum" /></td>
	          <td align="center"><s:property value="totalBirdSum" /></td>
	          <td align="center"><s:property value="totalSilverSum" /></td>
	          <td align="center"><s:property value="totalBombSum" /></td>
	          <td align="center"><s:property value="totalGoldSum" /></td>
	          <td align="center"><s:property value="totalBeastSum" /></td>
            </tr>
            </s:iterator>
            <tr>
              <td colspan="15" align="right" valign="middle">
				<div id="right_foot01">
					<s:url action="record_grecord" namespace="/shark" var="first">
						<s:param name="pageNo" value="1"></s:param>
					</s:url> 
					<s:url action="record_grecord" namespace="/shark" var="previous">
						<s:param name="pageNo" value="pageModel.pageNo-1"></s:param>
					</s:url> 
					<s:url action="record_grecord" namespace="/shark" var="last">
						<s:param name="pageNo" value="pageModel.bottomPageNo"></s:param>
					</s:url> 
					<s:url action="record_grecord" namespace="/shark" var="next">
						<s:param name="pageNo" value="pageModel.pageNo+1"></s:param>
					</s:url> 
					<s:include value="/WEB-INF/pages/common/page.jsp"></s:include>
				</div>
              </td>
            </tr>
          </table>
	    </div> <!-- end .grecord -->
	</div> 
	<div class="footer"><%@ include file="/WEB-INF/pages/footer.jsp"%><!-- end .footer --></div>
</div>
<script>
// 你的代码
</script>
</body>
</html>

