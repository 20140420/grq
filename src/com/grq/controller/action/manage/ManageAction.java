package com.grq.controller.action.manage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;

@Scope("prototype")
@Controller("manageAction")
public class ManageAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ���������û��͹���Ա�ĺ�̨ҳ��
	 */
	public String sidebar() throws Exception {
		if(0>1){
			return "usidebar";//USER��̨��ҳ
		}
		return "msidebar";//ADMIN��̨��ҳ
	}
		


}