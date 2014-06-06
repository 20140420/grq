package com.grq.controller.action.manage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;

@Scope("prototype")
@Controller("userAction")
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	/**
	 * usidebar“≥√Ê
	 * @return
	 * @throws Exception
	 */
	public String usilverbuy() throws Exception{

		return "usilverbuy";
	}
	public String usilversell() throws Exception{

		return "usilversell";
	}
	public String uinquiryaccount() throws Exception{

		return "uinquiryaccount";
	}
	public String uinquirysilverrecord() throws Exception{

		return "uinquirysilverrecord";
	}
	public String uinquirygame() throws Exception{

		return "uinquirygame";
	}
	public String uinvest() throws Exception{

		return "uinvest";
	}
	public String uinvestrecord() throws Exception{

		return "uinvestrecord";
	}
	public String ugiro() throws Exception{

		return "ugiro";
	}
	public String ugirorecord() throws Exception{

		return "ugirorecord";
	}
	public String uprofile() throws Exception{

		return "uprofile";
	}
	public String upassquestion() throws Exception{

		return "upassquestion";
	}
	public String ubankcard() throws Exception{

		return "ubankcard";
	}
	public String umaster() throws Exception{

		return "umaster";
	}
	public String uapprentice() throws Exception{

		return "uapprentice";
	}
	public String cart() throws Exception{

		return "cart";
	}
	public String order() throws Exception{

		return "order";
	}

}