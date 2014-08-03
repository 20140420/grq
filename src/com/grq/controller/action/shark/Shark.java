package com.grq.controller.action.shark;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.util.*;

import org.apache.commons.io.IOUtils;

import com.grq.model.SharkRun;
import com.grq.model.dao.shark.SharkConfigDaoImpl;


public class Shark{ 
	public static void main(String[] args) {
		String selfPid = null;
		selfPid = getSelfPID();
		System.out.println("获取项目主线程值： " + selfPid);
		
		String sharkPid = null;
		try {
			sharkPid = getSharkPid();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		boolean isBegin = SharkConfigDaoImpl.lastSharkConfig().getIsBegin();//获取游戏是否开启
		System.out.println("游戏是否开启："+isBegin);
		if(isBegin){//条件一是游戏开启
			System.out.println("是否有独立shark进程PID："+sharkPid);
			if(sharkPid != null){//条件二是独立的Shark线程在运行
				System.out.println("独立shark进程运行着："+sharkPid);
				sharkP();//非独立shark线程
			} else {
				startShark();//启动shark独立线程
			}
		}
	}
	/**
	 * 启动shark独立线程函数
	 */
	public static void startShark(){
		System.out.println("未做！启动shark独立线程函数startShark()");
		//暂时用非独立shark线程
		//sharkP();
	}
	public static void sharkP(){
		//以下非独立shark线程，暂时用
		Integer timeDelay = 2000;//延迟加载
		Integer timeCycle = SharkConfigDaoImpl.lastSharkConfig().getTimeCycle();//获取最后一条配置循环周期时长
		//System.out.println("循环周期时长:"+timeCycle);
		System.out.println("延2秒加载");
		Timer timer=new Timer();//实例化Timer类
		timer.schedule(new SharkRun(),timeDelay,timeCycle);//从第二次开始每隔周期时长，包括SharkRun()里面的延迟时间，调用SharkRun()一次
	}

	/**
	 * 使用jps来获得java进程，jps是sun的jdk自带的一个jvm运行进程查看工具，
	 * 无论win还是lin都有，至少能够支持跨平台
	 * 获取Shark的进程pid用于避免重复启用
	 * 不稳定，时有时无？
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getSharkPid() throws IOException {  
		Process p = Runtime.getRuntime().exec("jps"); 
		InputStream in = p.getInputStream();  
		List<String> jpsLines = IOUtils.readLines(in);  
		IOUtils.closeQuietly(in);  
		for (String line : jpsLines) {
			System.out.println("pidAllList: " + line);
			if (line.contains(Shark.class.getSimpleName())) { //获取类名是 Shark的进程PID
				String sharkPid = line.split("\\s")[0];
				System.out.println("独立的Shark进程PID："+sharkPid);
				return sharkPid;
			} else {
				return null;
			}
		} 
		throw new IllegalStateException("拿不到sharkPid");  
	}
	/**
	 * 获取项目主进程PID
	 * 
	 * @return
	 */
	public static String getSelfPID(){
		String pname = ManagementFactory.getRuntimeMXBean().getName();
		System.out.println("项目主进程名称： " + pname);
		int index = pname.indexOf('@');
		//System.out.println("获取自己进程index位数： " + index);
		if (index == -1) {
			System.out.println("获取项目主进程PID失败！进程名称为：" + pname);
		}
		String pid = pname.substring(0, index);
		return pid;
	}

}