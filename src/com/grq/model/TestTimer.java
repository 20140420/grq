package com.grq.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.rmi.UnexpectedException;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.io.IOUtils;

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
		//new Timer().schedule(new TestTimer().init(), 3000,10000);//首次延迟2秒，无限循环 ，每个10秒 
		String pid = getPid();
		System.out.println("获取线程pid值： " + pid);
		String selfPid = getSelfPID();
		System.out.println("获取自己线程selfPid值： " + selfPid);
		boolean isExist = checkPidInProcess(selfPid);
		System.out.println("线程是否已近存在： " + isExist);
		while(true) { //无限循环记时
			System.out.println("秒："+new Date().getSeconds()); 
			Thread.sleep(1000); 
		} 
	}
	/**
	 * 使用jps来获得java进程，jps是sun的jdk自带的一个jvm运行进程查看工具，
	 * 无论win还是lin都有，至少能够支持跨平台
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	private static boolean checkPidInProcess(String pid) throws Exception {
		InputStream in = Runtime.getRuntime().exec("jps").getInputStream();
		BufferedReader b = new BufferedReader(new InputStreamReader(in));
		String line = null;
		while((line = b.readLine()) !=null){
			if(line.startsWith(pid)){//我这里是通过pid来识别(pid可以通过MBean获取)，其实完全可以改成通过类名来识别
				if(line.contains(TestTimer.class.getSimpleName())){//如果line中包含线程的类名
					System.out.println("line："+ line);
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	private static String getPid() throws IOException {  
		Process p = Runtime.getRuntime().exec("jps"); 
		InputStream in = p.getInputStream();  
		List<String> jpsLines = IOUtils.readLines(in);  
		IOUtils.closeQuietly(in);  
		for (String line : jpsLines) {
			System.out.println("sharkLine: " + line);
			if (line.contains(TestTimer.class.getSimpleName())) {  
				return line.split("\\s")[0];  
			}  
		}  
		throw new IllegalStateException("拿不到pid");  
	}
	/**
	 * 获取自身进程ID
	 * 
	 * @return
	 * @throws UnexpectedException 
	 */
	private static String getSelfPID() throws UnexpectedException {
		String pname = ManagementFactory.getRuntimeMXBean().getName();
		System.out.println("获取自己进程名称： " + pname);
		int index = pname.indexOf('@');
		System.out.println("获取自己进程index位数： " + index);
		if (index == -1) {
			throw new UnexpectedException("获取自身进程PID失败！进程名称为：" + pname);
		}
		String pid = pname.substring(0, index);
		return pid;
	}

} 


