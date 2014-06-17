package com.grq.controller.action;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.grq.model.dao.product.ProductCategoryDao;
import com.grq.model.dao.product.ProductDao;
import com.grq.model.dao.product.UploadFileDao;
import com.grq.model.dao.product.OrderDao;
import com.grq.model.dao.user.CustomerDao;
import com.grq.model.pojo.user.Customer;
import com.grq.model.pojo.product.OrderItem;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 基本Action对象，其它Action的父类
 * @author JiangQuan
 */
@Scope("prototype")
@Controller("baseAction")
public class BaseAction extends ActionSupport implements 
SessionAware{
	private static final long serialVersionUID = 1L;
	
	protected int pageNo = 1;//当前页
	protected int pageSize = 6;//每页显示多少条
	
	// 注入Dao
	@Autowired
	protected ProductCategoryDao categoryDao;
	@Autowired
	protected ProductDao productDao;
	@Autowired
	protected UploadFileDao uploadFileDao;
	@Autowired
	protected OrderDao orderDao;
	@Autowired
	protected CustomerDao customerDao;
	
	// Map类型的session
	protected Map<String, Object> session;
	
	public static final String INDEX = "index";
	public static final String MAIN = "main";
	public static final String MANAGE = "manage";
	public static final String ADD = "add";
	public static final String LIST = "list";
	public static final String EDIT = "edit";
	public static final String SELECT = "select";
	public static final String QUERY = "query";
	public static final String LOGIN = "login";
	public static final String REG = "reg";
	
	public static final String CUSTOMER_LOGIN = "customerLogin";
	
	

	// 处理方法
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String index() throws Exception {
		return INDEX;
	}
	public String main() throws Exception {
		return MAIN;
	}
	public String manage() throws Exception {
		return MANAGE;
	}
	public String add() throws Exception {
		return ADD;
	}
	public String list() throws Exception {
		return LIST;
	}
	public String edit() throws Exception {
		return EDIT;
	}
	public String select() throws Exception {
		return SELECT;
	}
	public String query() throws Exception{
		return QUERY;
	}
	public String login() throws Exception{
		return LOGIN;
	}
	public String reg() throws Exception{
		return REG;
	}
	
	/**
	 * 获取Map类型的session赋值
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		// 获取Map类型的session赋值
		this.session = session;
	}
	

	/**
	 * 	 获取用户id
	 * 	 获取用户对象
	 * @return
	 */
	public Customer getLoginCustomer(){
		if(session.get("customer") != null){
			return (Customer) session.get("customer");
		}
		return null;
	}
	/**
	 * 从session中取出购物车
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Set<OrderItem> getCart(){
		Object obj = session.get("cart");
		if(obj == null){
			return new HashSet<OrderItem>();
		}else{
			return (Set<OrderItem>) obj;
		}
	}
	
	
	
	// getter和settter方法
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


}
