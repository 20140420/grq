package com.grq.controller.action.shark;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;

@Scope("prototype")
@Controller("sharkAction")
public class SharkAction extends BaseAction {
	private static final long serialVersionUID = 1L;
		
	/**
	 * ת��ҳ��
	 * @return
	 * @throws Exception
	 */
	public String gdial() throws Exception{

		return "gdial";
	}
	
	/**
	 * ��������ҳ��
	 * @return
	 * @throws Exception
	 */
	public String gpanel() throws Exception{

		return "gpanel";
	}
	
	/**
	 * ����gruleҳ��
	 * @return
	 * @throws Exception
	 */
	public String grule() throws Exception{

		return "grule";
	}

}
