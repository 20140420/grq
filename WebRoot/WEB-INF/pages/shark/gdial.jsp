<%@ page contentType="text/html; charset=utf-8" language="java" 
import="java.util.*,java.text.*,
com.grq.model.pojo.shark.SharkConfig,com.grq.model.dao.shark.SharkConfigDaoImpl,
com.grq.model.pojo.shark.PrizeRecord,com.grq.model.dao.shark.PrizeRecordDaoImpl,
com.grq.model.customizeenum.Prize" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

SharkConfig topConfigList = SharkConfigDaoImpl.lastSharkConfig();//通过调用配置实现类中的方法获取最后一条配置
Integer int_timeSpend = topConfigList.getTimeCircle();
System.out.println("转盘时间：" + int_timeSpend);
Integer int_timeObserve = topConfigList.getTimeObserve();
Integer int_timeBet = topConfigList.getTimeBet();
Integer int_timeDisplay = topConfigList.getTimeDisplay();
Integer int_timeWait = topConfigList.getTimeWait();
Integer int_timeCycle = topConfigList.getTimeCycle();
System.out.println("周期：" + int_timeCycle);
List<PrizeRecord> prizeRecordList = PrizeRecordDaoImpl.prizeRecordEntity();
Prize prize = prizeRecordList.get(prizeRecordList.size()-1).getPrizeName();
System.out.println("gdial页面最近一场中奖奖项：" + prize);
%>
<script>
	var time_spend= <%=int_timeSpend%>;//计算转盘花费的时间4秒，从而计算转盘速度
	var time_observe= <%=int_timeObserve%>; //观察时长 后期由服务器取得
	var time_bet= <%=int_timeBet%>;//下注时长 后期由服务器取得
	var time_display= <%=int_timeDisplay%>;//展示时长 后期由服务器取得
	var time_wait= <%=int_timeWait%>;//等待时长 后期由服务器取得
	var tCycle = "<%=int_timeCycle%>";
	//alert("周期tCycle=" + tCycle);
	var prize = "<%=prize%>";
	//alert("奖项prize=" + prize);
</script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/shark_cycle.js"></script>
<link href="<%=basePath%>css/shark_cycle.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/game.css" rel="stylesheet" type="text/css" />
<div class="gdial"><!---->
 <div class="gdial-top">
	<div class="gdial-top1"><img width="75" height="60" /></div>
	<div class="gdial-top2"><img width="75" height="60" /></div>
	<div class="gdial-top3"><img width="75" height="60" /></div>
	<div class="gdial-top4"><img width="75" height="60" /></div>
	<div class="gdial-top5"><img width="75" height="60" /></div>
	<div class="gdial-top6"><img width="75" height="60" /></div>
	<div class="gdial-top7"><img width="75" height="60" /></div>
	<div class="gdial-top8"><img width="75" height="60" /></div>
	<div class="gdial-top9"><img width="75" height="60" /></div>
 </div>
 <div class="gdial-left">
	<div class="gdial-left1"><img width="75" height="60" /></div>
	<div class="gdial-left2"><img width="75" height="60" /></div>
	<div class="gdial-left3"><img width="75" height="60" /></div>
	<div class="gdial-left4"><img width="75" height="60" /></div>
	<div class="gdial-left5"><img width="75" height="60" /></div>
 </div>
 <!-- 中间展示区 -->
 <div class="gdial-display">
	<div id="canvas-background-color" style="float: left" >
		<!-- <canvas id="playground" width="537" height="308"></canvas> -->
		<div class="colockbox" id="demo04">
			<span class="second">-</span>
		</div>
		<!-- 奖项动画展示 -->
		<div class="box" id="demo1">
		</div>
	</div> 
 </div>
 <div class="gdial-right">
	<div class="gdial-right1"><img width="75" height="60" /></div>
	<div class="gdial-right2"><img width="75" height="60" /></div>
	<div class="gdial-right3"><img width="75" height="60" /></div>
	<div class="gdial-right4"><img width="75" height="60" /></div>
	<div class="gdial-right5"><img width="75" height="60" /></div>
 </div> 
 <div class="gdial-bottom">
	<div class="gdial-bottom1"><img width="75" height="60" /></div>
	<div class="gdial-bottom2"><img width="75" height="60" /></div>
	<div class="gdial-bottom3"><img width="75" height="60" /></div>
	<div class="gdial-bottom4"><img width="75" height="60" /></div>
	<div class="gdial-bottom5"><img width="75" height="60" /></div>
	<div class="gdial-bottom6"><img width="75" height="60" /></div>
	<div class="gdial-bottom7"><img width="75" height="60" /></div>
	<div class="gdial-bottom8"><img width="75" height="60" /></div>
	<div class="gdial-bottom9"><img width="75" height="60" /></div>
 </div>
</div>
