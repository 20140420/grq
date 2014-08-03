package com.grq.controller.action.shark;

import java.util.Timer;

import com.grq.model.SharkRun;
import com.grq.model.dao.shark.SharkConfigDaoImpl;


public class Shark{ 
	
	public static void main(String[] args) {
		Integer timeDelay = 2000;//延迟加载
		Integer timeCycle = SharkConfigDaoImpl.lastSharkConfig().getTimeCycle();//获取最后一条配置循环周期时长
		//System.out.println("循环周期时长:"+timeCycle);
		System.out.println("延2秒加载");
		Timer timer=new Timer();//实例化Timer类
		timer.schedule(new SharkRun(),timeDelay,timeCycle);//从第二次开始每隔周期时长，包括SharkRun()里面的延迟时间，调用SharkRun()一次
	}
}