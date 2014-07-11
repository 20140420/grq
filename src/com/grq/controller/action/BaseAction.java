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
import com.grq.model.dao.user.UserDao;
import com.grq.model.dao.shark.PrizeRecordDao;
import com.grq.model.dao.shark.BetDao;
import com.grq.model.dao.shark.SharkConfigDao;
import com.grq.model.pojo.user.Customer;
import com.grq.model.pojo.user.User;
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
	protected int pageSize = 4;//每页显示多少条
	
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
	@Autowired
	protected UserDao userDao;
	@Autowired
	protected BetDao betDao;
	@Autowired
	protected PrizeRecordDao prizeRecordDao;
	@Autowired
	protected SharkConfigDao sharkConfigDao;
	
	// Map类型的session
	protected Map<String, Object> session;
	
	public static final String TEST = "test";
	public static final String INDEX = "index";
	public static final String MANAGE = "manage";
	public static final String MAIN = "main";
	public static final String ADD = "add";
	public static final String LIST = "list";
	public static final String EDIT = "edit";
	public static final String SELECT = "select";
	public static final String QUERY = "query";
	public static final String LOGIN = "login";
	public static final String REG = "reg";
	
	public static final String CUSTOMER_LOGIN = "customerLogin";
	public static final String CUSTOMER_MANAGE = "customerManage";
	public static final String ADMIN_LOGIN = "adminLogin";
	public static final String ADMIN_MANAGE = "adminManage";
	
	

	// 处理方法
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String test() throws Exception {
		return TEST;
	}
	public String index() throws Exception {
		return INDEX;
	}
	public String manage() throws Exception {
		return MANAGE;
	}
	public String main() throws Exception {
		return MAIN;
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
	 * 	 获取顾客用户id
	 * 	 获取顾客用户对象
	 * @return
	 */
	public Customer getLoginCustomer(){
		if(session.get("customer") != null){
			return (Customer) session.get("customer");
		}
		return null;
	}
	/**
	 *  获取管理用户id
	 * 	获取管理用户对象
	 * @return
	 */
	public User getLoginUser(){
		if(session.get("admin") != null){
			return (User) session.get("admin");
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
