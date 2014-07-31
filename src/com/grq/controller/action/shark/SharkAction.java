package com.grq.controller.action.shark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Timer;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.PageModel;
import com.grq.model.SharkRun;
import com.grq.model.customizeenum.Prize;
import com.grq.model.pojo.shark.PanelInfo;
import com.grq.model.pojo.shark.TimesEntity;
import com.grq.model.util.StringUtil;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("sharkAction")
public class SharkAction extends BaseAction implements ModelDriven<PanelInfo>{
	private static final long serialVersionUID = 1L;
	
	// 键盘panel对象
	private PanelInfo panelData = new PanelInfo();//一定要先初始化obj对象！
	private PageModel<PanelInfo> pageModel;// 分页组件

	private static TimesEntity timesList;//必须是static类型的
	
	/**
	 * 此方法是Modeldriven接口的方法，要重写
	 */
	@Override
	public PanelInfo getModel() {
		return panelData;
	}
	//getter和setter方法，放入request中，好在jsp页面中能拿到	
	public PageModel<PanelInfo> getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel<PanelInfo> pageModel) {
		this.pageModel = pageModel;
	}
	public PanelInfo getPanelData() {
		return panelData;
	}
	public void setPanelData(PanelInfo panelData) {
		this.panelData = panelData;
	}
	
	
	
	/**
	 * 鲨鱼主函数
	 * @author 泉
	 * @return 游戏主页面
	 */
	@Override
	public String main(){
		boolean isBegin = true;
		if(isBegin){
			/*
			//这里不能放下面代码
			Integer timeDelay;//延迟时长，用于加载游戏
			Integer timeCycle;//周期时长
			timeDelay = 2000;//延迟加载
			timeCycle = 18000;//预先设置
			System.out.println("延2加载");
			Timer timer=new Timer();//实例化Timer类
			timer.schedule(new SharkRun(),timeDelay,timeCycle);//从第二次开始每隔周期时长，包括SharkRun()里面的延迟时间，调用SharkRun()一次
			*/
			return MAIN;//返回主题页
		} else {
			System.out.println("还未开始");
		}
		return null;
	}
/**-------------------------------------------------------------------*/
	/**
	 * 从panel提交获得数据,
	 * @return shark页面
	 * @throws Exception
	 */
	public String save() throws Exception{
		//System.out.print("panel提交的data");
		if(getLoginCustomer() != null){//如果顾客用户已登录
			//把倍数加到对象panelData中
			panelData.setTimesSwallow(timesList.getTimesSwallow());
			panelData.setTimesPigeon(timesList.getTimesPigeon());
			panelData.setTimesPeafowl(timesList.getTimesPeafowl());
			panelData.setTimesEagle(timesList.getTimesEagle());
			panelData.setTimesLion(timesList.getTimesLion());
			panelData.setTimesPanda(timesList.getTimesPanda());
			panelData.setTimesMonkey(timesList.getTimesMonkey());
			panelData.setTimesRabbit(timesList.getTimesRabbit());
			// 计算下注总数（非总额）的变量
			Integer totalBet=(panelData.getSwallow()+panelData.getPigeon()+panelData.getPeafowl()
					+panelData.getEagle()+panelData.getLion()+panelData.getPanda()
					+panelData.getMonkey()+panelData.getRabbit()+panelData.getBird()
					+panelData.getSilver_shark()+panelData.getBomb()+panelData.getGold_shark()
					+panelData.getBeast());
			if (totalBet != 0){//如果有下注
				System.out.println("save总额："+totalBet);
				Boolean betCount = false;// 用于判断是否是统计过（默认值为false）
				panelData.setPanelBetId(StringUtil.createOrderId());// 设置21位的订单号
				panelData.setCustomer(getLoginCustomer());// 设置所属用户	
				panelData.setTotalBet(totalBet);//把下注总数加到对象panelData中
				panelData.setBetCount(betCount);// 用于判断是否是统计过（默认值为false）
				panelData.setPrizeItem(Prize.RAFFLING);// 设置奖项状态为正在抽奖
				System.out.println("下单创建时间："+panelData.getCreateTime());
				betDao.save(panelData);//保存panel获得数据	
				//记得重置panel下注
			}
			return main();//通过主函数返回shark主页面，可进行统计出结果
		}
		return CUSTOMER_LOGIN;//返回登入页面
	}
	/**
	 * 用户下注查询页面
	 * @return
	 * @throws Exception
	 */
	public String uinquirybet() throws Exception{

		return findByCustomer();//返回查询个人下注的方法
	}
	/**
	 * 查询个人下注
	 * @return String
	 * @throws Exception
	 */
	public String findByCustomer() throws Exception {
		if(getLoginCustomer() != null){//如果用户已登录
			String where = "where customer.id = ?";//将用户id设置为查询条件
			Object[] queryParams = {getLoginCustomer().getId()};//创建对象数组
			Map<String, String> orderby = new HashMap<String, String>(1);//创建Map集合
			orderby.put("createTime", "desc");//设置排序条件及方式
			pageModel = betDao.find(where, queryParams, orderby , pageNo, pageSize);//执行查询方法
		}
		return LIST;//返回订单列表页面
	}
	
	/**
	 * 查询所有人下注
	 * @return String
	 * @throws Exception
	 */
	public String list() throws Exception {
		Map<String, String> orderby = new HashMap<String, String>(1);//定义Map集合
		orderby.put("createTime", "desc");//设置按创建时间倒序排列
		StringBuffer whereBuffer = new StringBuffer("");//创建字符串对象
		List<Object> params = new ArrayList<Object>();//创建列表集合
		if(panelData.getPanelBetId() != null && panelData.getPanelBetId().length() > 0){//如果下注单不为空
			whereBuffer.append("panelBetId = ?");//以下注单号为查询条件
			params.add(panelData.getPanelBetId());//设置参数
		}
		if(panelData.getCustomer() != null && panelData.getCustomer().getUsername() != null 
				&& panelData.getCustomer().getUsername().length() > 0){//如果会员名不为空
			if(params.size() > 0) whereBuffer.append(" and ");//增加查询条件
			whereBuffer.append("customer.username = ?");//设置会员名为查询条件
			params.add(panelData.getCustomer().getUsername());//设置参数
		}
		//如果whereBuffer为空则查询条件为空，否则以whereBuffer为查询条件
		String where = whereBuffer.length()>0 ? "where "+whereBuffer.toString() : "";
		pageModel = betDao.find(where, params.toArray(), orderby, pageNo, pageSize);//执行查询方法
		return LIST;//返回后台下注列表
	}
	
	/**
	 * 查询指定一单的下注情况
	 */
	public String select() throws Exception {
		panelData = betDao.load(panelData.getPanelBetId());
		return SELECT;
	}
	
	
	/**
	 * 转盘页面
	 * @return
	 * @throws Exception
	 */
	public String gdial() throws Exception{

		return "gdial";
	}
	
	/**
	 * 按键键盘页面
	 * @return
	 * @throws Exception
	 */
	public String gpanel() throws Exception{
		SharkRun sharkRun = new SharkRun();
		timesList = sharkRun.makeTimes();//获取随机生成的一组倍数
		//把随机列表保存到对象实例中
		panelData.setTimesSwallow(timesList.getTimesSwallow());
		panelData.setTimesPigeon(timesList.getTimesPigeon());
		panelData.setTimesPeafowl(timesList.getTimesPeafowl());
		panelData.setTimesEagle(timesList.getTimesEagle());
		panelData.setTimesLion(timesList.getTimesLion());
		panelData.setTimesPanda(timesList.getTimesPanda());
		panelData.setTimesMonkey(timesList.getTimesMonkey());
		panelData.setTimesRabbit(timesList.getTimesRabbit());
		return "gpanel";
	}
	
	/**
	 * 导向grule页面
	 * @return
	 * @throws Exception
	 */
	public String grule() throws Exception{

		return "grule";
	}
}
