package com.grq.controller.action.invest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;

@Scope("prototype")
@Controller("investAction")
public class InvestAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排名页面
	 * @return
	 * @throws Exception
	 */
	public String ranking() throws Exception{

		return "ranking";
	}
	
	/**
	 * 大甩卖活动
	 * @return
	 * @throws Exception
	 */
	public String sales() throws Exception{

		return "sales";
	}
		

}
