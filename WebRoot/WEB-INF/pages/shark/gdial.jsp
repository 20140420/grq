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
//System.out.println("转盘每步时长：" + int_stepTime);
Integer int_timeObserve = topConfigList.getTimeObserve();
Integer int_timeBet = topConfigList.getTimeBet();
Integer int_timeDisplay = topConfigList.getTimeDisplay();
Integer int_timeWait = topConfigList.getTimeWait();
Integer int_timeCycle = topConfigList.getTimeCycle();
//System.out.println("周期：" + int_timeCycle);
Integer int_prizeRecordNum = topConfigList.getPrizeRecordNum();//查看奖项记录数目
Integer int_circleNum = topConfigList.getCircleNum();//转盘圈数
//System.out.println("转盘圈数：" + int_circleNum);

List<Prize> list_numPrize = sharkRun.haveNumPrizeRecord(int_prizeRecordNum);//考虑用一个函数记录havePrize()的几场奖项
System.out.println("奖项记录表最近奖项列表："+list_numPrize);
//System.out.println("查看奖项列表："+list_numPrize.get(0));

//以下代码段把list循环成一个json格式的字符串(java中转换成字符串)
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
	
	var stepTime = <%=int_stepTime%>;//用作控制转盘每步时长
	var circle_num= <%=int_circleNum%>;//转盘圈数
	var str = "<%=str%>";
	var numPrizeList = strToJson(str);//最近开奖记录列表
	//delayGetPrize(circle_num, stepTime);
	
	var prize = "<%=sharkRun.randomPrize()%>";
	alert("奖项prize=" + prize);
	
	
function strToJson(str){ //js中将字符串转换成json
	var json = new Function("return " + str)(); 
	return json;
}
function delayGetPrize(circleNum, stepLength){
	var timerDial = null;
	var time_dial = 28*circleNum;
	timerDial = setInterval(function(){//函数内部计时转盘效果时长
		if(time_dial > 0){
			time_dial -= 1;
		} else {
			clearInterval(timerDial);
		}
	}, stepLength);
	if(time_dial === 0){//转盘整圈到时
		//获取押注中奖,这里需设置定时器，定在转盘整圈后出奖
		var prize = "<%=sharkRun.randomPrize()%>";
		alert("奖项prize=" + prize);
	}
}
</script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/shark_cycle.js"></script>
<link href="<%=basePath%>css/shark_cycle.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/game.css" rel="stylesheet" type="text/css" />
<div class="gdial"><!---->
 <div class="gdial-top">
	<div class="gdial-animals" id="gdial_SILVER_SHARK" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_EAGLE" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_EAGLE" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_EAGLE" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_GOLD_SHARK" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_LION" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_LION" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_LION" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_SILVER_SHARK" ><img width="75" height="60" /></div>
 </div>
 <div class="gdial-left">
	<div class="gdial-animals" id="gdial_PEAFOWL" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_PEAFOWL" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_GOLD_SHARK" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_PIGEON" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_PIGEON" ><img width="75" height="60" /></div>
 </div>
 <!-- 中间展示区 -->
 <div class="gdial-display">
	<div id="canvas-background-color" style="float: left" >
		<!-- <canvas id="playground" width="537" height="308"></canvas> -->
		<div class="colockbox" id="demo04">
			<span class="second">-</span>
		</div>
		<!-- 奖项动画展示 -->
		<div class="box" id="demo1"></div>
		<!-- 历史奖项展示 -->
		<div class="observe" id="observe"></div>
	</div> 
 </div>
 <div class="gdial-right">
	<div class="gdial-animals" id="gdial_PANDA" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_PANDA" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_GOLD_SHARK" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_MONKEY" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_MONKEY" ><img width="75" height="60" /></div>
 </div> 
 <div class="gdial-bottom">
	<div class="gdial-animals" id="gdial_SILVER_SHARK" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_SWALLOW" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_SWALLOW" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_SWALLOW" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_GOLD_SHARK" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_RABBIT" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_RABBIT" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_RABBIT" ><img width="75" height="60" /></div>
	<div class="gdial-animals" id="gdial_SILVER_SHARK" ><img width="75" height="60" /></div>
 </div>
</div>
