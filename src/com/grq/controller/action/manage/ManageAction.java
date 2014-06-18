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
	 * session.customer != null
	 * session.get("customer") != null
	 */
	public String sidebar() throws Exception {
		if( (session.get("customer") != null) && (session.get("admin") == null) ){
			return "usidebar";//USER后台主页
		}else if( (session.get("customer") == null) && (session.get("admin") != null) ){
			return "msidebar";//ADMIN后台主页
		}else if((session.get("customer") != null) && (session.get("admin") != null)){
			return "usidebar";//USER后台主页
		}
		return "usidebar";//USER后台主页
	}
		


}