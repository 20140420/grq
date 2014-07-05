package com.grq.controller.action.shark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.PageModel;
import com.grq.model.customizeenum.Prize;
import com.grq.model.pojo.shark.PanelInfo;
import com.grq.model.util.StringUtil;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("sharkAction")
public class SharkAction extends BaseAction implements ModelDriven<PanelInfo>{
	private static final long serialVersionUID = 1L;
	
	

	


	
	/**
	 * 鲨鱼主函数
	 * @author 泉
	 * @return 游戏主页面
	 */
	@Override
	public String main(){
		//prizeString = havePrize();
		/*if(againOrNot == true){//如果是则获得再转一次
			turnAgain();
			againOrNot = false;//重置
		}*/
		return MAIN;//返回主题页	
	}
	

	
	
	
/**-------------------------------------------------------------------*/
	/**
	 * 从panel提交获得数据,
	 * @return shark页面
	 * @throws Exception
	 */
	public String save() throws Exception{
		//System.out.print("panel提交的data");
		if(getLoginCustomer() != null){//如果用户已登录
			//System.out.print("用户登入的");			
			Integer swallow =panelData.getSwallow();// 燕子
			Integer pigeon =panelData.getPigeon();// 鸽子
			Integer peafowl =panelData.getPeafowl();// 孔雀
			Integer eagle =panelData.getEagle();// 老鹰
			Integer lion =panelData.getLion();// 狮子
			Integer panda =panelData.getPanda();// 熊猫
			Integer monkey =panelData.getMonkey();// 猴子
			Integer rabbit =panelData.getRabbit();// 兔子
			Integer bird =panelData.getBird();// 飞禽
			Integer silver_shark =panelData.getSilver_shark();// 银鲨
			Integer bomb =panelData.getBomb();// 炸弹
			Integer gold_shark =panelData.getGold_shark();// 金鲨
			Integer beast =panelData.getBeast();// 走兽
			Integer totalBet =0;// 计算下注总数（非总额）的变量
			totalBet=(swallow+pigeon+peafowl+eagle+lion+panda+monkey+rabbit+bird+silver_shark+bomb+gold_shark+beast);
			//System.out.print("下注总数："+totalBet);
			if (totalBet != 0){//如果有下注
				Integer single_bet=panelData.getSingle_bet(); //单注额度
				float totalPrice = 0f; // 计算总额的变量
				totalPrice =single_bet*totalBet;
				System.out.print("总额："+totalPrice);
				Boolean betCount = false;// 用于判断是否是统计过（默认值为false）
				panelData.setPanelBetId(StringUtil.createOrderId());// 设置21位的订单号
				panelData.setCustomer(getLoginCustomer());// 设置所属用户	
				panelData.setSwallow(swallow);
				panelData.setPigeon(pigeon);
				panelData.setPeafowl(peafowl);
				panelData.setEagle(eagle);
				panelData.setLion(lion);
				panelData.setPanda(panda);
				panelData.setMonkey(monkey);
				panelData.setRabbit(rabbit);
				panelData.setBird(bird);
				panelData.setSilver_shark(silver_shark);
				panelData.setBomb(bomb);
				panelData.setGold_shark(gold_shark);
				panelData.setBeast(beast);
				panelData.setTotalBet(totalBet);//把下注总数加到对象panelData中
				panelData.setSingle_bet(single_bet);
				panelData.setTotalPrice(totalPrice);//把下注总额度
				panelData.setBetCount(betCount);// 用于判断是否是统计过（默认值为false）
				panelData.setPrizeItem(Prize.RAFFLING);// 设置奖项状态为正在抽奖
				betDao.save(panelData);//保存panel获得数据	
				//记得重置panel下注
			}
			//return MAIN;//返回shark主页面
			return main();//通过主函数返回shark主页面，可进行统计出结果
		}
		return CUSTOMER_LOGIN;//返回登入页面
	}
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
		System.out.println("最新一单飞禽押注："+pageModel.getList().get(0).getBird());
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
	/**
	 * 游戏shark的设定
	 * @return shark设定页面
	 * @throws Exception
	 */
	public String option() throws Exception{

		return "option";
	}
	
	// 键盘panel对象
	private PanelInfo panelData = new PanelInfo();//一定要先初始化obj对象！
	private PageModel<PanelInfo> pageModel;// 分页组件
	/**
	 * 此方法是Modeldriven接口的方法，要重写
	 * @return
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
/**---------------------------------------------------------------------*/
	
}
