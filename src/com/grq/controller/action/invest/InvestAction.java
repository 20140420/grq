package com.grq.controller.action.invest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;

@Scope("prototype")
@Controller("investAction")
public class InvestAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String ranking() throws Exception{

		return "ranking";
	}
	
	/**
	 * ��˦���
	 * @return
	 * @throws Exception
	 */
	public String sales() throws Exception{

		return "sales";
	}
		

}
