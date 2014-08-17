<%@ page contentType="text/html; charset=utf-8" language="java" 
import="java.util.*,java.text.*,
com.grq.model.pojo.shark.SharkConfig,
com.grq.model.pojo.shark.PrizeRecord,com.grq.model.dao.shark.PrizeRecordDaoImpl,
com.grq.model.customizeenum.Prize,com.grq.model.SharkRun" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

SharkRun sharkRun = new SharkRun();
SharkConfig topConfigList = sharkRun.haveConfig();//通过调用配置实现类中的方法获取最后一条配置
Integer int_stepTime = topConfigList.getStepTime();
System.out.println("转盘每步时长：" + int_stepTime);
Integer int_timeObserve = topConfigList.getTimeObserve();
Integer int_timeBet = topConfigList.getTimeBet();
Integer int_timeDisplay = topConfigList.getTimeDisplay();
Integer int_timeWait = topConfigList.getTimeWait();
Integer int_timeCycle = topConfigList.getTimeCycle();
System.out.println("周期：" + int_timeCycle);
Integer int_circleNum = topConfigList.getCircleNum();//转盘圈数
System.out.println("转盘圈数：" + int_circleNum);
List<PrizeRecord> prizeRecordList = PrizeRecordDaoImpl.prizeRecordEntity();
Prize prizeName = prizeRecordList.get(prizeRecordList.size()-1).getPrizeName();
System.out.println("最近记录中奖奖项：" + prizeName);

Prize prize = null;//获取用户个人的下注记录的奖项
if(prize == null){
//	prize = sharkRun.havePrize();//应该是个人下注记录里的奖项
	prize = sharkRun.randomPrize();//暂时看看
}
System.out.println("个人中奖奖项：" + prize);

List<Prize> list_numPrize = sharkRun.haveNumPrizeRecord(6);//考虑用一个函数记录havePrize()的几场奖项
System.out.println("查看最近奖项列表："+list_numPrize);
//System.out.println("查看奖项列表："+list_numPrize.get(0));
//把list循环成一个json格式的字符串(java中转换成字符串)
String str="";
for(int i=0;i<list_numPrize.size();i++){
str += ("{prize:'"+list_numPrize.get(i)+"'},");
}
if(str.length()>0){
str="["+str.substring(0,str.length()-1)+"]";
}
%>
<script>
	var time_observe= <%=int_timeObserve%>; //观察时长 后期由服务器取得
	var time_bet= <%=int_timeBet%>;//下注时长 后期由服务器取得
	var time_display= <%=int_timeDisplay%>;//展示时长 后期由服务器取得
	var time_wait= <%=int_timeWait%>;//等待时长 后期由服务器取得
	var time_cycle = <%=int_timeCycle%>;
	var prize = "<%=prize%>";
	//alert("奖项prize=" + prize);
	var stepTime = <%=int_stepTime%>;//用作控制转盘每步时长
	var circle_num= <%=int_circleNum%>;//转盘圈数
	var str = "<%=str%>";
	var numPrizeList = strToJson(str);//最近开奖记录列表
	function strToJson(str){ //js中将字符串转换成json
		var json = new Function("return " + str)(); 
		return json;
	}
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
