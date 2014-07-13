package com.grq.controller.action.shark;

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
/** -------------------------------------------------------------------- */	
	
	/**
	 * 保存奖项记录
	 * @return
	 * @throws Exception
	 
	public String save() throws Exception{
		try{
			//System.out.print("提交的配置设定");
			if(getLoginUser() != null){//如果用户已登录
				Integer timeCycle =(sharkConfig.getTimeObserve()+sharkConfig.getTimeBet()+sharkConfig.getTimeCircle()+sharkConfig.getTimeDisplay()+sharkConfig.getTimeWait());
				sharkConfig.setTimeCycle(timeCycle);//添加计算得到的周期时长
				sharkConfig.setId(StringUtil.getStringTime());//添加18位数字字符串与其他配置属性一起加到数据库中
				sharkConfigDao.saveOrUpdate(sharkConfig);//保存到对象
				
				return list();//返回设定页面
			}
		} catch(Exception ex){
			System.out.println("保存游戏配置时出现问题");
		}
		return ADMIN_LOGIN;//返回登入页面
	}*/
}
