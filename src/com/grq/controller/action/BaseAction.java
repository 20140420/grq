package com.grq.controller.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 基本Action对象，其它Action的父类
 * @author JiangQuan
 */
@Scope("prototype")
@Controller("baseAction")
public class BaseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	public static final String INDEX = "index";
	public static final String MAIN = "main";

	
	// 处理方法
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String index() throws Exception {
		return INDEX;
	}
	public String main() throws Exception {
		return MAIN;
	}

	// getter和settter方法

}
