package com.grq.controller.action.shark;

import java.util.TimerTask;

public class MyTask extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("延迟的是这里");
		this.cancel();//退出周期调用
	}

}
