package com.grq.controller.action.shark;

import java.util.Timer;
import java.util.TimerTask;

public class test{ 
	public static void main(String[] args) {
		System.out.println("Hello World!3秒之后");
		try {
	        Thread.sleep(3000);//括号里面3000代表3000毫秒也3秒该成需要时间
		} catch (InterruptedException e) {
	        e.printStackTrace();
		}
		System.out.println("Hello World!后面还有");
		/**
		 * 
		 *  
		 *  */
		Timer timer=new Timer();//实例化Timer类
		timer.schedule(new TimerTask(){
			public void run(){
				System.out.println("退出，延迟的是这里");
				this.cancel();//退出确保只运行一次
			}
		},2000,1000);//2000毫秒
		
		
		//Timer timer=new Timer();//实例化Timer类
		//timer.schedule(new MyTask(),2000,1000);//2000毫秒,从第二次开始每隔1秒调用run()一次
	}
}