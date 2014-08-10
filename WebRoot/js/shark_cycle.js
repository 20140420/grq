/* 游戏周期流程 */
$(function(){
	var time_spend= 4;//计算转盘花费的时间4秒，从而计算转盘速度
	var time_observe= 6; //观察时长 后期由服务器取得
	var time_bet= 12;//下注时长 后期由服务器取得
	var time_display= 3;//展示时长 后期由服务器取得
	var time_wait= 2;//等待时长 后期由服务器取得
	var time_cycle= (time_spend+time_observe+ time_bet+ time_display+ time_wait);//一个周期时长 后期由服务器取得,展示-等待-观察-下注-转盘
	//var circle_num= 2;//转盘圈数 后期由服务器取得
	//var circle_speed= (28*80*circle_num)/time_spend;//计算转盘速度,28个跳格，setInterval()频率80毫秒
	//var int_timeCycle = "<%=int_timeCycle%>";
	//alert("周期int_timeCycle=" + int_timeCycle);

	clock(time_cycle,time_spend,time_display,time_wait,time_observe,time_bet,"#demo04 .second","#demo04 .second");

});

function clock(time_length,time_spend,time_display,time_wait,time_observe,time_bet,minute_elem,second_elem){
	setInterval(function(){
			if(time_length > (time_observe+ time_bet+ time_display+ time_wait)){//转盘
				time_length -=1;
				spend=(time_length-(time_observe+ time_bet+ time_display+ time_wait));
				$(second_elem).text(spend<10?"0"+spend:spend);
				//alert("转盘3秒");
			} else if(time_length > (time_observe+ time_bet+ time_wait)){//展示
				time_length -=1;
				display=(time_length-(time_observe+ time_bet+ time_wait));
				$(minute_elem).text(display<10?"0"+display:display);
				//alert("展示3秒");
			} else if(time_length > (time_observe+ time_bet)){//等待				
				time_length -=1;
				wait=(time_length-(time_observe+ time_bet));
				$(second_elem).text(wait<10?"0"+wait:wait);
				//alert("等待2秒"); 
			} else if(time_length > time_bet){//观察				
				time_length -=1;
				observe=(time_length-time_bet);
				$(minute_elem).text(observe<10?"0"+observe:observe); 
				//alert("观察6秒");
			} else if(time_length >0){//剩于下注				
				time_length -=1;
				$(second_elem).text(time_length<10?"0"+time_length:time_length); 
				//alert("下注7秒");
			} else {
				//clearInterval(timer);
				//alert("结束返回time_length："+time_length);
				document.panelform.submit();//下注结束后提交筹码
				//alert("提交panelform后，给time_length赋值");
				time_length = (time_spend+time_observe+ time_bet+ time_display+ time_wait);
				//alert("无限循环重新赋值time_length："+time_length);
			}
		},1000);
	//alert("返回timer："+timer);
	//alert("去掉本提示就可以无限循环，周期："+time_length);
	//return time_length;
}
//display展示中奖结果
function changeS (obj,num) 
{
	var n = num;
	//alert("查看n： " + n);
	setInterval(function(){
		if( num > 0)
		{
			obj.id = "demos"+num;
			num -= 1;
			//alert("查看obj.id： " + obj.id);
		} else {
			num = n;
		}		
	}, 150);
}
function change (obj,num) 
{
	var n = num;
	//alert("查看n： " + n);
	setInterval(function(){
		if( num > 0)
		{
			obj.id = "demo"+num;
			num -= 1;
			//alert("查看obj.id： " + obj.id);
		} else {
			num = n;
		}		
	}, 150);
}