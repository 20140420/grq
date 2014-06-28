package com.grq.controller.action.shark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.PageModel;
import com.grq.model.pojo.shark.PanelInfo;
import com.grq.model.util.StringUtil;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("sharkAction")
public class SharkAction extends BaseAction implements ModelDriven<PanelInfo>{
	private static final long serialVersionUID = 1L;
	
	// 键盘panel对象
	private PanelInfo panelData = new PanelInfo();//一定要先初始化obj对象！
	
	private PageModel<PanelInfo> pageModel;// 分页组件
	/**
	 * 此方法是Modeldriven接口的方法，要重写
	 * @return
	 */
	

	private float dividend = 300;//彩金池变量
	private double commission_rate = 0.10;//佣金费率
	private float totalPriceSum = 0f; //统计下注总额之和的变量
	private float totalSwallowSum = 0f; //统计燕子下注总额之和
	private float totalPigeonSum = 0f;
	private float totalPeafowlSum = 0f;
	private float totalEagleSum = 0f;
	private float totalLionSum = 0f;
	private float totalPandaSum = 0f;
	private float totalMonkeySum = 0f;
	private float totalRabbitSum = 0f;
	private float totalBirdSum = 0f;
	private float totalSilverSum = 0f;
	private float totalBombSum = 0f;
	private float totalGoldSum = 0f;
	private float totalBeastSum = 0f;
	
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
				float single_bet=panelData.getSingle_bet(); //单注额度
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
				sharkDao.save(panelData);//保存panel获得数据	
				//记得重置panel下注
			}
			return MAIN;//返回shark主页面
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
			pageModel = sharkDao.find(where, queryParams, orderby , pageNo, pageSize);//执行查询方法
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
		pageModel = sharkDao.find(where, params.toArray(), orderby, pageNo, pageSize);//执行查询方法
		return LIST;//返回后台下注列表
	}
	
	/**
	 * 查询指定一下注单的下注情况
	 */
	public String select() throws Exception {
		panelData = sharkDao.load(panelData.getPanelBetId());
		return SELECT;
	}

	
	/**
	 * 出奖
	 * @return String 奖项
	 */
	public String getPrize(){
		StringBuffer prize = new StringBuffer();//定义字符串对象
		float totalBetSum = countTotalPrice();//获得下注总额之和
		if( (totalBetSum*(1-commission_rate)+dividend) > (totalBetSum*99) ){//如果已有99倍余额
			turnAgain();
			sharkPrize();//鲨鱼函数,根据返回值确定是金鲨还是银鲨
		} else if( (totalBetSum*(1-commission_rate)+dividend) > (totalBetSum*24) ){//如果已有24倍余额
			randomPrize();//随机函数
		} else if( (totalBetSum*(1-commission_rate)+dividend) > 0){
			dividendUpPrize();//彩金池增加的吃分函数
		} else {
			attractPrize();//诱惑函数
		}
		System.out.print("奖项为："+prize);
		return prize.toString();//返回奖项字符串
	}

	/**
	 * 统计各奖项押注之和，及总押注总额之和
	 * @return float 未操作押注总额之和 totalBetSum
	 */
	private float countTotalPrice(){
		Map<String, String> orderby = new HashMap<String, String>(1);//定义Map集合
		orderby.put("createTime", "desc");//设置按创建时间倒序排列
		String where = "where betCount = ?";//设置查询条件语句
		Object[] queryParams = {false};//获取未操作过的参数值
		pageModel = sharkDao.find(where, queryParams, orderby, -1, -1);//执行查询方法
		List<PanelInfo> allBet = pageModel.getList();//获取所有未操作过的下注条目
		for(PanelInfo panelInfo : allBet){//遍历所有的下注条目
			float totalPrice = panelInfo.getTotalPrice();//获取每一条目下注总额
			float single_bet = panelInfo.getSingle_bet();//获取每一条单注额度
			Integer swallow = panelInfo.getSwallow();
			Integer pigeon = panelInfo.getPigeon();
			Integer peafowl = panelInfo.getPeafowl();
			Integer eagle = panelInfo.getEagle();
			Integer lion = panelInfo.getLion();
			Integer panda = panelInfo.getPanda();
			Integer monkey = panelInfo.getMonkey();
			Integer rabbit = panelInfo.getRabbit();
			Integer bird = panelInfo.getBird();
			Integer silver = panelInfo.getSilver_shark();
			Integer bomb = panelInfo.getBomb();
			Integer gold = panelInfo.getGold_shark();
			Integer beast = panelInfo.getBeast();
			boolean betCount = panelInfo.getBetCount();//获得条目统计状态
			if(betCount == false){//如果条目未操作过
				float totalSwallow = swallow*single_bet;
				setTotalSwallowSum(getTotalSwallowSum() + totalSwallow);
				float totalPigeon = pigeon*single_bet;
				setTotalPigeonSum(getTotalPigeonSum() + totalPigeon);//等同于totalPigeonSum += totalPigeon;
				float totalPeafowl = peafowl*single_bet;
				totalPeafowlSum += totalPeafowl;
				float totalEagle = eagle*single_bet;
				totalEagleSum += totalEagle;
				float totalLion = lion*single_bet;
				totalLionSum += totalLion;
				float totalPanda = panda*single_bet;
				totalPandaSum += totalPanda;
				float totalMonkey = monkey*single_bet;
				totalMonkeySum += totalMonkey;
				float totalRabbit = rabbit*single_bet;
				totalRabbitSum += totalRabbit;
				float totalBird = bird*single_bet;
				totalBirdSum += totalBird;
				float totalSilver = silver*single_bet;
				totalSilverSum += totalSilver;
				float totalBomb = bomb*single_bet;
				totalBombSum += totalBomb;
				float totalGold = gold*single_bet;
				totalGoldSum += totalGold;
				float totalBeast = beast*single_bet;
				totalBeastSum += totalBeast;//相加所有条目禽兽的下注总额
				totalPriceSum += totalPrice;//相加所有条目的下注总额
				betCount = true; //设置改变标记为已经统计过
				panelData = sharkDao.load(panelData.getPanelBetId());//装载订单对象
				panelData.setBetCount(betCount);// 设置操作情况
				sharkDao.update(panelData);//更新修改操作状态
			}
		}
		System.out.print("单场押注总额之和为："+totalPriceSum);		
		return totalPriceSum;//返回总下注数目之和
	}
	
	/**
	 * 鲨鱼函数
	 */
	private String sharkPrize() {
		// TODO Auto-generated method stub
		double a = Math.floor(randomNum.nextInt(2));//随机获取大于等于0到小于2的整数部分,即随机获取0或1
		int b = (int)a;//将double数据类型转换成int
		if(b == 0){//为银鲨概率1/2
			float silverOutScore = getTotalSilverSum()*24;//银鲨总出分
			dividend = dividend + countTotalPrice() - silverOutScore; //彩金池数目变动
			//记得更新到数据库
			return "silver_shark";
		} else if(b == 1){//为金鲨概率1/2
			int times =(int)(Math.floor(randomNum.nextInt(75))+25);//随机获取大于等于25到小于100的整数
			float goldOutScore = getTotalGoldSum()*times;//金鲨总出分
			dividend = dividend + countTotalPrice() - goldOutScore; //彩金池数目变动
			//记得更新到数据库
			return "gold_shark";
		} else {
			System.out.print("不应该出现的error");
		}
		return null;
	}
	
	/**
	 * 再转函数
	 */
	private void turnAgain() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 彩金池增加的吃分函数
	 */
	private void dividendUpPrize() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 诱惑函数
	 */
	private void attractPrize() {
		// TODO Auto-generated method stub
		
	}
	
	Random randomNum = new Random();
	/** 
	 * 随机函数
	 */
	private void randomPrize() {
		// TODO Auto-generated method stub
		
	}
	
	//getter和setter方法
	public float getTotalSwallowSum() {
		return totalSwallowSum;
	}
	public void setTotalSwallowSum(float totalSwallowSum) {
		this.totalSwallowSum = totalSwallowSum;
	}

	public float getTotalPeafowlSum() {
		return totalPeafowlSum;
	}
	public void setTotalPeafowlSum(float totalPeafowlSum) {
		this.totalPeafowlSum = totalPeafowlSum;
	}
	public float getTotalPigeonSum() {
		return totalPigeonSum;
	}
	public void setTotalPigeonSum(float totalPigeonSum) {
		this.totalPigeonSum = totalPigeonSum;
	}
	public float getTotalEagleSum() {
		return totalEagleSum;
	}
	public void setTotalEagleSum(float totalEagleSum) {
		this.totalEagleSum = totalEagleSum;
	}
	public float getTotalLionSum() {
		return totalLionSum;
	}
	public void setTotalLionSum(float totalLionSum) {
		this.totalLionSum = totalLionSum;
	}
	public float getTotalPandaSum() {
		return totalPandaSum;
	}
	public void setTotalPandaSum(float totalPandaSum) {
		this.totalPandaSum = totalPandaSum;
	}
	public float getTotalMonkeySum() {
		return totalMonkeySum;
	}
	public void setTotalMonkeySum(float totalMonkeySum) {
		this.totalMonkeySum = totalMonkeySum;
	}
	public float getTotalRabbitSum() {
		return totalRabbitSum;
	}
	public void setTotalRabbitSum(float totalRabbitSum) {
		this.totalRabbitSum = totalRabbitSum;
	}
	public float getTotalBirdSum() {
		return totalBirdSum;
	}
	public void setTotalBirdSum(float totalBirdSum) {
		this.totalBirdSum = totalBirdSum;
	}
	public float getTotalSilverSum() {
		return totalSilverSum;
	}
	public void setTotalSilverSum(float totalSilverSum) {
		this.totalSilverSum = totalSilverSum;
	}
	public float getTotalBombSum() {
		return totalBombSum;
	}
	public void setTotalBombSum(float totalBombSum) {
		this.totalBombSum = totalBombSum;
	}
	public float getTotalGoldSum() {
		return totalGoldSum;
	}
	public void setTotalGoldSum(float totalGoldSum) {
		this.totalGoldSum = totalGoldSum;
	}
	public float getTotalBeastSum() {
		return totalBeastSum;
	}
	public void setTotalBeastSum(float totalBeastSum) {
		this.totalBeastSum = totalBeastSum;
	}
}
