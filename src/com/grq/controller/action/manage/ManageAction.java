package com.grq.controller.action.manage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;

@Scope("prototype")
@Controller("manageAction")
public class ManageAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 控制区别用户和管理员的后台页面
	 */
	public String sidebar() throws Exception {
		if(0>1){
			return "usidebar";//USER后台主页
		}
		return "msidebar";//ADMIN后台主页
	}
		


}