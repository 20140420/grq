package com.grq.controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.grq.model.dao.product.ProductCategoryDao;
import com.grq.model.dao.product.ProductDao;
import com.grq.model.dao.product.UploadFileDao;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 基本Action对象，其它Action的父类
 * @author JiangQuan
 */
@Scope("prototype")
@Controller("baseAction")
public class BaseAction extends ActionSupport{
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
	
	public static final String INDEX = "index";
	public static final String MAIN = "main";
	public static final String MANAGE = "manage";
	public static final String ADD = "add";
	public static final String LIST = "list";
	public static final String EDIT = "edit";
	public static final String SELECT = "select";


	
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
