package com.grq.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import com.grq.model.pojo.shark.TimesEntity;

public class SharkRun extends TimerTask {
	private static Integer timeBet;//下注时长
	private static List<TimesEntity> timesEntity;//包含六组倍数的实体
	
	/**
	 *游戏一个运行周期,等同主函数
	 */
	@Override
	public void run() {
		System.out.println("-------------------------------------------");
		process();      //周期循环流程
		System.out.println("---------如果没退出周期，还有18-5-3开始第二周期----------");
		this.cancel();//退出周期调用，结束线程
	}

	private void process() {
		makeTimes();          //获取倍数,倍数随机生成不统一		
		haveConfig();         //获取配置
		haveLastDividend();   //获取上期彩金池
		//观察、下注 
		timeBet = 5 ;        //观察下注时间
		System.out.println("观察下注时间5");
		try {
	        Thread.sleep(timeBet*1000);//括号里面3000代表3000毫秒也3秒该成需要时间
		} catch (InterruptedException e) {
	        e.printStackTrace();
		}
		System.out.println("结束下注");
		havePrize();  //出奖
		//包括转盘、展示
		System.out.println("开奖时间3");
		try {
	        Thread.sleep(3000);
		} catch (InterruptedException e) {
	        e.printStackTrace();
		}
		makeRecord(); //记录奖项函数		
		betClear();   //重置清零		
	}
	/**
	 * 随机生成一组倍数列表
	 * @return
	 */
	private void makeTimes() {
		System.out.println("获取倍数函数，倍数随机生成不统一");	
		timesEntity=new ArrayList<TimesEntity>();
		for(int i = 0; i < 6; i++){	
			TimesEntity timesList = new TimesEntity();
			timesList.setTimesSwallow(i);
			timesList.setTimesPigeon(i);
			timesList.setTimesPeafowl(i);
			timesList.setTimesEagle(i);
			timesList.setTimesLion(i);
			timesList.setTimesPanda(i);
			timesList.setTimesMonkey(i);
			timesList.setTimesRabbit(i);
			timesEntity.add(timesList);
		}
		int timesIndex=(int)(Math.random()*timesEntity.size());//从总共timesEntity.size()组倍数中随机一组倍数
		
	}

	private void haveConfig() {
		System.out.println("获取配置函数");
		
	}

	private void haveLastDividend() {
		System.out.println("获取上期彩金池函数");		
	}
	
	private void havePrize() {
		System.out.println("出奖函数");		
	}
	
	private void makeRecord() {
		System.out.println("记录奖项函数");		
	}
	
	private void betClear() {
		System.out.println("重置清零函数");		
	}

}
