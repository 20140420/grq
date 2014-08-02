package com.grq.model;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer { 

	class MyTimerTask extends TimerTask {
		private int time; //定时执行时间 
		public MyTimerTask(){
		}
		public MyTimerTask(int _time){
			this.time = _time; 
		} 
		@Override 
		public void run() {
			System.out.println("time:" + time); 
			System.out.println(("判断："+"time==3000") ); 
			if(time==3000) {//如果是三秒
				System.out.println("---------------");
				throw new RuntimeException("异常");
			} 
			if(time%6000==0) { //如果六秒整除
				time = 0; 
			} 
			System.out.println("下次执行时间" + time); 
			new Timer().schedule(new MyTimerTask(time+1000), time);//延迟 time时长，不循环
			//this.cancel();//是否终止10秒循环周期
			//System.exit(0);//是否正常退出JVM虚拟机所有线程
		} 
	}
	/**
	 * 初始化
	 * @return
	 */
	public MyTimerTask init() {
		return new MyTimerTask(); 
	} 
	public static void main(String[] args) throws Exception { 
		//双循环
		new Timer().schedule(new TestTimer().init(), 3000,10000);//首次延迟2秒，无限循环 ，每个10秒
		while(true) { //无限循环记时
			System.out.println("秒："+new Date().getSeconds()); 
			Thread.sleep(1000); 
		} 
	} 
} 


