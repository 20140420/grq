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
	 * session.customer != null
	 * session.get("customer") != null
	 */
	public String sidebar() throws Exception {
		if( (session.get("customer") != null) && (session.get("admin") == null) ){
			return "usidebar";//USER��̨��ҳ
		}else if( (session.get("customer") == null) && (session.get("admin") != null) ){
			return "msidebar";//ADMIN��̨��ҳ
		}else if((session.get("customer") != null) && (session.get("admin") != null)){
			return "usidebar";//USER��̨��ҳ
		}
		return "usidebar";//USER��̨��ҳ
	}
		


}