package com.grq.controller.action.chat;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;

@Scope("prototype")
@Controller("chatAction")
public class ChatAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	/**
	 * chat页面的广告窗口
	 * @return
	 * @throws Exception
	 */
	public String minsales() throws Exception{

		return "minsales";
	}
}
