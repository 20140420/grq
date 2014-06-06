package com.grq.controller.action.manage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;

@Scope("prototype")
@Controller("adminAction")
public class AdminAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * msidebar“≥√Ê
	 * @return
	 * @throws Exception
	 */
	public String webserver() throws Exception{

		return "webserver";
	}
	public String webdatabase() throws Exception{

		return "webdatabase";
	}
	public String webotherinformation() throws Exception{

		return "webotherinformation";
	}
	public String adminuser() throws Exception{

		return "adminuser";
	}
	public String playeruser() throws Exception{

		return "playeruser";
	}
	public String assetgiro() throws Exception{

		return "assetgiro";
	}
	public String assetsilver() throws Exception{

		return "assetsilver";
	}
	public String assetinvest() throws Exception{

		return "assetinvest";
	}
	public String operatesales() throws Exception{

		return "operatesales";
	}
	public String operateoption() throws Exception{

		return "operateoption";
	}
		


}