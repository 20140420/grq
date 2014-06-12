package com.grq.controller.action.sale;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.pojo.product.ProductCategory;


@Scope("prototype")
@Controller("saleAction")
public class SaleAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	// 所有类别
	private List<ProductCategory> categories;
	
	//getter和setter方法
	public List<ProductCategory> getCategories() {
		return categories;
	}
	public void setCategories(List<ProductCategory> categories) {
		this.categories = categories;
	}
	
	
	/**
	 * 继承重写BaseAction
	 */
	@Override
	public String main() throws Exception {
		// 查询所有类别
		String where = "where parent is null";
		categories = categoryDao.find(-1, -1, where, null).getList();

		return MAIN;
	}


}
