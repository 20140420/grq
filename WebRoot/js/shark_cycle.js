/* 游戏周期流程 */
$(function()
{
	/* 变量在gdial.jsp页面定义
	var time_observe= 6; //观察时长 后期由服务器取得
	var time_bet= 12;//下注时长 后期由服务器取得
	var time_display= 3;//展示时长 后期由服务器取得
	var time_wait= 2;//等待时长 后期由服务器取得
	var circle_num= 2;//转盘圈数 后期由服务器取得
	var time_cycle= 20;//一个周期时长 后期由服务器取得,展示-等待-观察-下注-转盘
	var prize = "MONKEY";
	var stepTime = 80;
	*/
	//var circle_speed= (28*80*circle_num)/time_spend;//计算转盘速度,28个跳格，setInterval()频率80毫秒
	dial(time_cycle,time_display,time_wait,time_observe,time_bet,
			circle_num,stepTime,prize,"#demo04 .second");//变量在gdial.jsp页面定义
});
function countdown(time_length,second_elem)//倒计时
{
	$(second_elem).text(time_length<10?"0"+time_length:time_length);
}

function dial(time_length,time_display,time_wait,time_observe,time_bet,
		circle_num,stepTime,prize,second_elem)
{
	//alert("查看个时长： " + time_length + time_spend +time_display+time_wait+time_observe+time_bet);
	var timer = null;
	timer= setInterval(function(){
		if(time_length > 0){//一个周期
			if(time_length > 10){//最后十秒
				if(time_length > (time_observe+ time_bet+ time_display+ time_wait)){//转盘
					dialAnimation(circle_num, prize, stepTime);//转盘效果
					countdown(time_length,second_elem);
					time_length -=1;
				} else if(time_length > (time_observe+ time_bet+ time_wait)){//展示
					prizeAnimation(time_display, prize);//奖项动画
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
			document.panelform.submit();//下注结束后提交筹码
			//time_length = (time_spend+time_observe+ time_bet+ time_display+ time_wait);
		}
	},1000);
}
//转盘动画效果
function dialAnimation(circleNum, prizeItem, stepLength){
	var hor = $(".gdial-top > div");//找到所有div元素，并且这些元素都必须是.gdial-top元素的子元素。
	var rig = $(".gdial-right > div");
	var bottom = $(".gdial-bottom > div");
	var left = $(".gdial-left > div");
	
	var timer = null, index = 0;
	var allList = [];

	var stopPos = stopPosition(prizeItem);
	alert("查看stopPos： " + stopPos);
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
	}, stepLength);
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
	obj.className = 'box_'+prize;
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
//依据奖项确认停靠位置函数
function stopPosition(prizeItem)
{
	if(prizeItem == "SWALLOW"){
		var n = Math.floor(Math.random()*3);
		switch(n)
		{
		case 0:
			return 19;
		case 1:
			return 20;
		default:
			return 21;
		}
	}else if(prizeItem == "PIGEON"){
		var n = Math.floor(Math.random()*2);
		switch(n)
		{
		case 0:
			return 23;
		default:
			return 24;
		}
	}else if(prizeItem == "PEAFOWL"){
		var n = Math.floor(Math.random()*2);
		switch(n)
		{
		case 0:
			return 26;
		default:
			return 27;
		}
	}else if(prizeItem == "EAGLE"){
		var n = Math.floor(Math.random()*3);
		switch(n)
		{
		case 0:
			return 1;
		case 1:
			return 2;
		default:
			return 3;
		}
	}else if(prizeItem == "LION"){
		var n = Math.floor(Math.random()*3);
		switch(n)
		{
		case 0:
			return 5;
		case 1:
			return 6;
		default:
			return 7;
		}
	}else if(prizeItem == "PANDA"){
		var n = Math.floor(Math.random()*2);
		switch(n)
		{
		case 0:
			return 9;
		default:
			return 10;
		}
	}else if(prizeItem == "MONKEY"){
		var n = Math.floor(Math.random()*2);
		switch(n)
		{
		case 0:
			return 12;
		default:
			return 13;
		}
	}else if(prizeItem == "RABBIT"){
		var n = Math.floor(Math.random()*3);
		switch(n)
		{
		case 0:
			return 15;
		case 1:
			return 16;
		default:
			return 17;
		}
	}else if(prizeItem == "SILVER_SHARK"){
		var n = Math.floor(Math.random()*4);
		switch(n)
		{
		case 0:
			return 0;
		case 1:
			return 8;
		case 2:
			return 14;
		default:
			return 22;
		}
	}else if(prizeItem == "GOLD_SHARK"){
		var n = Math.floor(Math.random()*4);
		switch(n)
		{
		case 0:
			return 4;
		case 1:
			return 11;
		case 2:
			return 18;
		default:
			return 25;
		}
	} else {
		return 28;//炸弹奖项
	}
}