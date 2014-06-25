package com.grq.controller.action.shark;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;

@Scope("prototype")
@Controller("sharkAction")
public class SharkAction extends BaseAction {
	private static final long serialVersionUID = 1L;
		
	/**
	 * 转盘页面
	 * @return
	 * @throws Exception
	 */
	public String gdial() throws Exception{

		return "gdial";
	}
	
	/**
	 * 按键键盘页面
	 * @return
	 * @throws Exception
	 */
	public String gpanel() throws Exception{

		return "gpanel";
	}
	
	/**
	 * 导向grule页面
	 * @return
	 * @throws Exception
	 */
	public String grule() throws Exception{

		return "grule";
	}
	
	/**
	 * 从panel提交获得数据
	 * @return shark页面
	 * @throws Exception
	 */
	public String save() throws Exception{
		System.out.print("panel提交的data");
		
		return MAIN;//返回shark主页面
	}

}
