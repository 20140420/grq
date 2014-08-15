/* 游戏周期流程 */
$(function()
{
	/* 变量在gdial.jsp页面定义 
	var time_spend= 5;//计算转盘花费的时间4秒，从而计算转盘速度
	var time_observe= 7; //观察时长 后期由服务器取得
	var time_bet= 12;//下注时长 后期由服务器取得
	var time_display= 3;//展示时长 后期由服务器取得
	var time_wait= 2;//等待时长 后期由服务器取得
	var circle_num= 2;//转盘圈数 后期由服务器取得
	*/
	var time_cycle= (time_spend+time_observe+ time_bet+ time_display+ time_wait);//一个周期时长 后期由服务器取得,展示-等待-观察-下注-转盘
	
	//var circle_speed= (28*80*circle_num)/time_spend;//计算转盘速度,28个跳格，setInterval()频率80毫秒
	
	clock(time_cycle,time_spend,time_display,time_wait,time_observe,time_bet,"#demo04 .second");
});
function countdown(time_length,second_elem)//倒计时
{
	$(second_elem).text(time_length<10?"0"+time_length:time_length);
}

function clock(time_length,time_spend,time_display,time_wait,time_observe,time_bet,second_elem)
{
	//alert("查看个时长： " + time_length + time_spend +time_display+time_wait+time_observe+time_bet);
	//var prize = "MONKEY";
	var stepTime = 80;//用作控制转盘每步时长
	var timer = null;
	timer= setInterval(function(){
		if(time_length > 0){//一个周期
			if(time_length > 10){//最后十秒
				if(time_length > (time_observe+ time_bet+ time_display+ time_wait)){//转盘
					dialAnimation(circle_num, prize, stepTime);
					countdown(time_length,second_elem);
					time_length -=1;
				} else if(time_length > (time_observe+ time_bet+ time_wait)){//展示
					prizeAnimation(time_display, prize);//奖项动画//变量prize在gdial.jsp页面定义
					countdown(time_length,second_elem);
					time_length -=1;
				} else if(time_length > (time_observe+ time_bet)){//等待
					countdown(time_length,second_elem);
					time_length -=1;
				} else {//观察
					observePrize();
					countdown(time_length,second_elem);
					time_length -=1;
				}
			} else {//最后10秒钟
				countAnimation(10);				
				countdown(time_length,second_elem);
				time_length -= 1;
			}
		} else {
			clearInterval(timer);
			//document.panelform.submit();//下注结束后提交筹码
			//time_length = (time_spend+time_observe+ time_bet+ time_display+ time_wait);
		}
	},1000);
}
//转盘动画效果
function dialAnimation(circleNum, prize, stepTime){
	var hor = $(".gdial-top > div");//找到所有div元素，并且这些元素都必须是.gdial-top元素的子元素。
	var rig = $(".gdial-right > div");
	var bottom = $(".gdial-bottom > div");
	var left = $(".gdial-left > div");
	
	var timer = null, index = 0;
	var allList = [];

	var stopPos = stopPosition(prize);
	$.each(hor, function(i, item){//确定了从左上角开始
		allList.push(item);
	});
	$.each(rig, function(i, item){
		allList.push(item);
	});
	var blen = bottom.length;
	$.each(bottom, function(i, item){
		allList.push(bottom[blen - 1 - i]);
	});
	var llen = left.length;
	$.each(left, function(i, item){
		allList.push(left[llen - 1 - i]);
	});
	timer = setInterval(function(){
		if(circleNum > 0){//控制圈数
			$(allList[index++]).removeClass("alpha");//移走透明度设置
			if (index === allList.length) {
				index = 0;//开始下一圈
				circleNum -= 1;//圈数减一
			}
			$(allList[index]).addClass("alpha");//添加透明度设置
		} else{
			$(allList[index++]).removeClass("alpha");//移走透明度设置
			if(index === stopPos){//停靠的奖项位置
				clearInterval(timer);
			}
			$(allList[index]).addClass("alpha");//添加透明度设置
		}
	}, stepTime);
}
//依据奖项确认停靠位置函数
function stopPosition(prize)
{
	//var index = null;
	if(prize == "SWALLOW"){
		var n = Math.floor(Math.random()*3);
		switch(n)
		{
		case 0:
			return index = 19;
		case 1:
			return index = 20;
		default:
			return index = 21;
		}
	}else if(prize == "PIGEON"){
		var n = Math.floor(Math.random()*2);
		switch(n)
		{
		case 0:
			return index = 23;
		default:
			return index = 24;
		}
	}else if(prize == "PEAFOWL"){
		var n = Math.floor(Math.random()*2);
		switch(n)
		{
		case 0:
			return index = 26;
		default:
			return index = 27;
		}
	}else if(prize == "EAGLE"){
		var n = Math.floor(Math.random()*3);
		switch(n)
		{
		case 0:
			return index = 1;
		case 1:
			return index = 2;
		default:
			return index = 3;
		}
	}else if(prize == "LION"){
		var n = Math.floor(Math.random()*3);
		switch(n)
		{
		case 0:
			return index = 5;
		case 1:
			return index = 6;
		default:
			return index = 7;
		}
	}else if(prize == "PANDA"){
		var n = Math.floor(Math.random()*2);
		switch(n)
		{
		case 0:
			return index = 9;
		default:
			return index = 10;
		}
	}else if(prize == "MONKEY"){
		var n = Math.floor(Math.random()*2);
		switch(n)
		{
		case 0:
			return index = 12;
		default:
			return index = 13;
		}
	}else if(prize == "RABBIT"){
		var n = Math.floor(Math.random()*3);
		switch(n)
		{
		case 0:
			return index = 15;
		case 1:
			return index = 16;
		default:
			return index = 17;
		}
	}else if(prize == "SILVER_SHARK"){
		var n = Math.floor(Math.random()*4);
		switch(n)
		{
		case 0:
			return index = 0;
		case 1:
			return index = 8;
		case 2:
			return index = 14;
		default:
			return index = 22;
		}
	}else if(prize == "GOLD_SHARK"){
		var n = Math.floor(Math.random()*4);
		switch(n)
		{
		case 0:
			return index = 4;
		case 1:
			return index = 11;
		case 2:
			return index = 18;
		default:
			return index = 25;
		}
	} else {
		return 28;//炸弹奖项
	}
}
//观察最近几场的出奖奖项
function observePrize()
{
	
}
//最后十秒倒计时动画
function countAnimation(time_bet)
{
	//var num = 10 ;//组成动画的一张图片分10部分
	var obj = document.getElementById("demo1");
	var timerCountdown = null;
	timerCountdown = setInterval(function(){
		if( time_bet > 0)
		{
			obj.id = "time"+ (time_bet-1);
			obj.className = 'box_time';
			time_bet -= 1;
			//alert("查看obj.id： " + obj.id);
		} else {
			clearInterval(timerCountdown);
			obj.className = 'box';
			obj.id = "demo1";
		}	
	}, 1000);
}
//display展示中奖结果
function prizeAnimation (time_display, prize) 
{
	var num = 5 ;//组成动画的一张图片分5部分
	var obj = document.getElementById("demo1");
	var n = num;
	var timerDisplayTime = null;
	var timerDisplay = null;
	timerDisplayTime = setInterval(function(){
		if(time_display > 0){
			time_display -= 1;
		} else {
			clearInterval(timerDisplayTime);
		}
	}, 1000);
	var strClassName = 'box_'+prize;
	if( strClassName != null )
	{
		obj.className = strClassName;
	}
	//alert("查看n： " + n);
	timerDisplay = setInterval(function(){
		if( num > 0)
		{
			obj.id = "demo"+num;
			num -= 1;
			//alert("查看obj.id： " + obj.id);
		} else if(time_display != 0){
			num = n;
		} else{
			clearInterval(timerDisplay);
			obj.className = 'box';
			obj.id = "demo1";
		}	
	}, 150);
}