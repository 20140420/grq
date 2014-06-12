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
	
	// �������
	private List<ProductCategory> categories;
	
	//getter��setter����
	public List<ProductCategory> getCategories() {
		return categories;
	}
	public void setCategories(List<ProductCategory> categories) {
		this.categories = categories;
	}
	
	
	/**
	 * �̳���дBaseAction
	 */
	@Override
	public String main() throws Exception {
		// ��ѯ�������
		String where = "where parent is null";
		categories = categoryDao.find(-1, -1, where, null).getList();

		return MAIN;
	}


}
