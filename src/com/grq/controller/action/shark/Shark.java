package com.grq.controller.action.shark;

import java.util.Timer;

import com.grq.model.SharkRun;

public class Shark{ 
	private static Integer timeDelay;//延迟时长，用于加载游戏
	private static Integer timeCycle;//周期时长
	
	public static void main(String[] args) {
		timeDelay = 2000;//延迟加载
		timeCycle = 18000;//预先设置
		System.out.println("延2加载");
		Timer timer=new Timer();//实例化Timer类
		timer.schedule(new SharkRun(),timeDelay,timeCycle);//从第二次开始每隔周期时长，包括SharkRun()里面的延迟时间，调用SharkRun()一次
	}
}