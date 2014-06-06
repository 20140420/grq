package com.grq.controller.action.bocai;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;

@Scope("prototype")
@Controller("bocaiAction")
public class BocaiAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	
	// 处理方法
	public String aboutbc() throws Exception {
		return "aboutbc";
	}
	public String joinbc() throws Exception {
		return "joinbc";
	}
		


}
