package com.grq.controller.action.manage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.pojo.user.User;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("adminAction")
public class AdminAction extends BaseAction implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	
	// 管理员用户对象
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 管理员登入
	 */
	@Override
	public String login() throws Exception{
		return ADMIN_LOGIN;
	}
	/**
	 * 登录 
	 * @return
	 * @throws Exception
	 */
	public String logon() throws Exception{
		//验证用户名和密码
		User loginUser = userDao.login(user.getUsername(), user.getPassword());
		if(loginUser != null){//通过验证
			session.put("admin", loginUser);//将管理员信息保存在Session对象admin中
		}else{
			addFieldError("", "admin用户名或密码不正确！");//返回错误提示信息
			return ADMIN_LOGIN;//返回管理员后台登录页面
		}
		System.out.print("管理员登入成功！OK");
		return ADMIN_MANAGE;//返回管理员后台页面
	}
	/**
	 * 退出(修改后只管理员退出)
	 * @return String
	 * @throws Exception
	 */
	public String logout() throws Exception{
		//if(session != null && session.size() > 0){
		if(session.get("admin") != null){
			//session.clear();
			session.put("admin", null);
		}
		return INDEX;
	}
	
	/**
	 * 管理员用户后台页面
	 * @return
	 * @throws Exception
	 */
	@Override
	public String manage() throws Exception{

		return ADMIN_MANAGE;
	}
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