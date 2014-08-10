<%@ page contentType="text/html; charset=utf-8" language="java" 
import="java.util.*,java.text.*,com.grq.model.pojo.shark.SharkConfig,com.grq.model.dao.shark.SharkConfigDaoImpl" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

SharkConfig topConfigList = SharkConfigDaoImpl.lastSharkConfig();//通过调用配置实现类中的方法获取最后一条配置
Integer int_timeCycle = topConfigList.getTimeCycle();
System.out.println("周期：" + int_timeCycle);
%>
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
		<!-- <canvas id="playground" width="537" height="308"></canvas>
		<div class="colockbox" id="demo04">
			<span class="second">-</span>
		</div> -->
		<!-- <div class="box_S" id="demos3" onclick="changeS(this,5);">
		</div> -->
		<div class="box" id="demo3" onclick="change(this,5);">
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
