package com.grq.controller.action.product;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.PageModel;
import com.grq.model.pojo.product.ProductCategory;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 商品类别Action对象
 * @author JiangQuan
 *
 */
@Scope("prototype")
@Controller("productCategoryAction")
public class ProductCategoryAction extends BaseAction implements ModelDriven<ProductCategory>{
	private static final long serialVersionUID = 1L;
	
	private ProductCategory category = new ProductCategory();//一定要先初始化obj对象！

	// 父类别id
	private Integer pid;
	// 所有类别
	private PageModel<ProductCategory> pageModel;

	/**
	 * 此方法是Modeldriven接口的方法，要重写
	 */
	@Override
	public ProductCategory getModel() {
		return category;
	}	
	/**
	 * 跳到添加类别
	 */
	@Override
	public String add() throws Exception {
		if(pid != null && pid>0){//如果有父节点
			ProductCategory parent = categoryDao.load(pid);//加载父类
			//层次加1
			category.setLevel(parent.getLevel()+1);
		}
		return INPUT;
	}
	/**
	 * 添加类别
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		if(pid != null && pid > 0 ){//如果有父节点
			category.setParent(categoryDao.load(pid));//设置父节点
		}
		categoryDao.saveOrUpdate(category);//添加类别信息
		return list();//返回类别列表的查找方法
	}
	/**
	 * 查询类别
	 * @return
	 * @throws Exception
	 */
	@Override
	public String list() throws Exception{
		Object[] params = null ;//定义对象数组初值为空
		String where;//定义查询条件变量
		if(pid != null && pid > 0 ){//如果有父节点  
			where = "where parent.id = ?";//执行查询条件
			params = new Integer[]{pid};//设置参数值
		}else{
			where ="where parent is null";//查询根节点
		}
		pageModel = categoryDao.find(pageNo, pageSize, where, params);//执行封装的 搜索信息分页方法 查询方法
		return LIST;//返回后台类别列表页面
	}
	/**
	 * 编辑类别
	 * @return String
	 * @throws Exception
	 */
	@Override
	public String edit() throws Exception{
		if(category.getId() != null && category.getId() > 0){//判断是否获得ID参数
			this.category = categoryDao.get(category.getId());//加载对象ID参数
		}	
		return EDIT;
	}
	/**
	 * 删除类别
	 * @return String
	 * @throws Exception
	 */
	public String del() throws Exception{
		if(category.getId() != null && category.getId() > 0){//判断是否获得ID参数
			categoryDao.delete(category.getId());//执行删除操作
		}
		return list();//返回商品类别列表的查找方法
	}
	
	//getter和setter方法
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public PageModel<ProductCategory> getPageModel() {
		return pageModel;
	}
	/**
	 * 
	 * @param pageModel
	public void setPageModel(PageModel<ProductCategory> pageModel) {
		this.pageModel = pageModel;
	}
	 */
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}

}
