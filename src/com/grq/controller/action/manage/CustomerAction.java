package com.grq.controller.action.manage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.pojo.user.Customer;
import com.grq.model.util.AppException;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 顾客Action
 * @author JiangQuan
 */
@Scope("prototype")
@Controller("customerAction")
public class CustomerAction extends BaseAction implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1L;
	// 顾客
	private Customer customer = new Customer();
	// 确认密码
	private String repassword;
	@Override
	public Customer getModel() {
		return customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	/**
	 * 继承BaseAction并重写，顾客用户登入页面
	 * @return "customerLogin"
	 * @throws Exception
	 */
	@Override
	public String login() throws Exception{
		return CUSTOMER_LOGIN;
	}
	/**
	 * 用户登录 
	 * @return
	 * @throws Exception
	 */
	public String logon() throws Exception{
		//验证用户名和密码是否正确
		Customer loginCustomer = customerDao.login(customer.getUsername(), customer.getPassword());
		if(loginCustomer != null){//如果通过验证
			session.put("customer", loginCustomer);//将登录会员信息保存在Session中
		}else{//验证失败
			addFieldError("", "CustomerAction用户名或密码不正确！");//返回错误信息
			return CUSTOMER_LOGIN;//返回会员登录页面
		}
		return CUSTOMER_MANAGE;//顾客登入成功后转入用户后台
	}
	/**
	 * 用户退出
	 * @return String
	 * @throws Exception
	 */
	public String logout() throws Exception{
		if(session != null && session.size() > 0){
			session.clear();
		}
		return INDEX;
	}
	/**
	 * 用户注册
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		boolean unique = customerDao.isUnique(customer.getUsername());//判断用户名是否唯一
		if(unique){//如果用户名可用
			customerDao.save(customer);//保存注册信息
			return CUSTOMER_LOGIN;//返回会员登录页面
		}else{
			throw new AppException("user have Already exists!!此用户名不可用");//否则返回页面错误信息
		}
	}
	
	
	
	/**
	 * 顾客用户后台页面
	 * @return
	 * @throws Exception
	 */
	@Override
	public String manage() throws Exception{

		return CUSTOMER_MANAGE;
	}
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
	
}
