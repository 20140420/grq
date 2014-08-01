package com.grq.controller.action.shark;


import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.PageModel;

import com.grq.model.pojo.shark.PrizeRecord;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("recordAction")
public class RecordAction extends BaseAction implements ModelDriven<PrizeRecord>{
	private static final long serialVersionUID = 1L;
	
/** -------------------------------------------------------------------- */
	private PageModel<PrizeRecord> pageModel;// 分页组件
	// 游戏配置对象
	private PrizeRecord prizeRecord = new PrizeRecord();//一定要先初始化obj对象！
	/**
	 * 此方法是Modeldriven接口的方法，要重写
	 * @return
	 */
	@Override
	public PrizeRecord getModel() {
		return prizeRecord;
	}
	//getter和setter方法，放入request中，好在jsp页面中能拿到	
	public PageModel<PrizeRecord> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<PrizeRecord> pageModel) {
		this.pageModel = pageModel;
	}
	
	/**
	 * 查询历史奖项记录页面
	 * @return
	 * @throws Exception
	 */
	public String grecord() throws Exception{
		Map<String, String> orderby = new HashMap<String, String>(1);//创建Map集合
		orderby.put("createTime", "desc");//设置排序条件及方式
		pageModel = prizeRecordDao.find(pageNo, pageSize, orderby);//查询所有奖项记录，每页10条
		return "grecord";
	}
/** -------------------------------------------------------------------- */	

}
