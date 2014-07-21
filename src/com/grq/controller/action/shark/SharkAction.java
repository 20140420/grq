package com.grq.controller.action.shark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.PageModel;
import com.grq.model.customizeenum.Prize;
import com.grq.model.pojo.shark.PanelInfo;
import com.grq.model.pojo.shark.PrizeRecord;
import com.grq.model.pojo.shark.SharkConfig;
import com.grq.model.pojo.shark.TimesEntity;
import com.grq.model.util.StringUtil;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("sharkAction")
public class SharkAction extends BaseAction implements ModelDriven<PanelInfo>{
	private static final long serialVersionUID = 1L;

	//本类中的区域变量
	//游戏倍数
	private static int timesSwallow;
	private static int timesPigeon;
	private static int timesPeafowl;
	private static int timesEagle;
	private static int timesLion;
	private static int timesPanda;
	private static int timesMonkey;
	private static int timesRabbit;
	//一场下注总额
	private static double totalSwallowSum; //统计燕子下注总额之和
	private static double totalPigeonSum;
	private static double totalPeafowlSum;
	private static double totalEagleSum;
	private static double totalLionSum;
	private static double totalPandaSum;
	private static double totalMonkeySum;
	private static double totalRabbitSum;
	private static double totalBirdSum;//统计飞禽下注总额之和
	private static double totalSilverSum;
	private static double totalBombSum;
	private static double totalGoldSum;
	private static double totalBeastSum;//统计走兽下注总额之和
	private static double totalBetSum;//一场下注总金额
	//一单下注
	private static Integer totalBet;//一条下注订单总筹码
	//游戏配置
	private static Integer timeCircle;//转圈时间和延长时间同用变量
	private static Integer timeCycle;//周期时长
	private static double commission_rate; //佣金费率
	private static int timesMax;//最高倍数
	private static double commissionProfit;//佣金收益
	private static double lastDividend;
	private static double dividend; //彩金池变量需要储存在数据库中
	private static boolean againOrNot; //是否重转，默认否	
	private static boolean bombOrNot; //是否存在炸弹，默认否
	
	// 实体变量
	private static List<PrizeRecord> prizeEntity;
	private static List<TimesEntity> timesEntity;
	private static List<PanelInfo> betEntity;
		
	//自定义类型变量
	private static Prize prizeString;//奖项变量，默认正在抽奖
	
	private static Random randomNum = new Random();//用于获取随机数

	/**
	 * 鲨鱼主函数
	 * @author 泉
	 * @return 游戏主页面
	 */
	@Override
	public String main(){
		
		return MAIN;//返回主题页	
	}
	/**
	 * 重置清零
	 */
	public void betClear(){
		//游戏倍数
		timesSwallow = 0;
		timesPigeon = 0;
		timesPeafowl = 0;
		timesEagle = 0;
		timesLion = 0;
		timesPanda = 0;
		timesMonkey = 0;
		timesRabbit = 0;
		//一场下注总额
		totalSwallowSum = 0.0; //统计燕子下注总额之和
		totalPigeonSum = 0.0;
		totalPeafowlSum = 0.0;
		totalEagleSum = 0.0;
		totalLionSum = 0.0;
		totalPandaSum = 0.0;
		totalMonkeySum = 0.0;
		totalRabbitSum = 0.0;
		totalBirdSum = 0.0;//统计飞禽下注总额之和
		totalSilverSum = 0.0;
		totalBombSum = 0.0;
		totalGoldSum = 0.0;
		totalBeastSum = 0.0;//统计走兽下注总额之和
		totalBetSum = 0.0;//一场下注总金额
		//一单下注
		totalBet = 0;//一条下注订单总筹码
		//游戏配置
		timeCircle = 0;//转盘时间
		timeCycle = 0;//周期时长
		commission_rate =0.0; //佣金费率
		timesMax = 0;//最高倍数
		commissionProfit = 0.0;//佣金收益
		lastDividend = 0.0;
		dividend = 0.0; //彩金池变量需要储存在数据库中
		againOrNot = false; //是否重转，默认否	
		bombOrNot = false; //是否存在炸弹，默认否
		// 实体变量
		prizeEntity = null;
		//timesEntity = null;
		betEntity = null;
		//自定义类型变量
		prizeString = Prize.RAFFLING;//奖项变量，默认正在抽奖
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
			timesEntity=new ArrayList<TimesEntity>();
			for(int i = 0; i < 6; i++){	
				TimesEntity timesList = new TimesEntity();
				timesList.setTimesSwallow(i);
				timesList.setTimesPigeon(i);
				timesList.setTimesPeafowl(i);
				timesList.setTimesEagle(i);
				timesList.setTimesLion(i);
				timesList.setTimesPanda(i);
				timesList.setTimesMonkey(i);
				timesList.setTimesRabbit(i);
				timesEntity.add(timesList);
			}
			int timesIndex=(int)(Math.random()*timesEntity.size());//从总共timesEntity.size()组倍数中随机一组倍数
			//把随机列表保存到对象实例中
			panelData.setTimesSwallow(timesEntity.get(timesIndex).getTimesSwallow());
			panelData.setTimesPigeon(timesEntity.get(timesIndex).getTimesPigeon());
			panelData.setTimesPeafowl(timesEntity.get(timesIndex).getTimesPeafowl());
			panelData.setTimesEagle(timesEntity.get(timesIndex).getTimesEagle());
			panelData.setTimesLion(timesEntity.get(timesIndex).getTimesLion());
			panelData.setTimesPanda(timesEntity.get(timesIndex).getTimesPanda());
			panelData.setTimesMonkey(timesEntity.get(timesIndex).getTimesMonkey());
			panelData.setTimesRabbit(timesEntity.get(timesIndex).getTimesRabbit());
			//查看随机生成的倍数列表
			ArrayList<Object> newTimesList = new ArrayList<Object>();//临时存储随机生成的倍数
			newTimesList.add(timesEntity.get(timesIndex).getTimesSwallow());//注意添加的顺序
			newTimesList.add(timesEntity.get(timesIndex).getTimesPigeon());
			newTimesList.add(timesEntity.get(timesIndex).getTimesPeafowl());
			newTimesList.add(timesEntity.get(timesIndex).getTimesEagle());
			newTimesList.add(timesEntity.get(timesIndex).getTimesLion());
			newTimesList.add(timesEntity.get(timesIndex).getTimesPanda());
			newTimesList.add(timesEntity.get(timesIndex).getTimesMonkey());
			newTimesList.add(timesEntity.get(timesIndex).getTimesRabbit());
			System.out.println("查看随机生成的倍数列表："+newTimesList);
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
				System.out.println("save总额："+totalPrice);
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
				System.out.println("下单创建时间："+panelData.getCreateTime());
				betDao.save(panelData);//保存panel获得数据	
				//记得重置panel下注
			}
			//return MAIN;//返回shark主页面
			return toMain();//通过主函数返回shark主页面，可进行统计出结果
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
	
	// 键盘panel对象
	private PanelInfo panelData = new PanelInfo();//一定要先初始化obj对象！
	private PageModel<PanelInfo> pageModel;// 分页组件
	private SharkConfig topConfigList;//最新一条配置
	//private PrizeRecord topPrizeList;//最新一条奖项记录

	//private PrizeRecord prizeRecord;
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
	/**
	 * 本函数代替main()大部分功能，与定时器一起完成与前端的配合
	 * @return
	 */
	public String toMain(){
		System.out.println("---------------开始--------------");		
		/** 从奖项记录获得新存倍数 */
		List<Object> oneTimesList = timesHave();
		System.out.println("从奖项记录获得新存倍数列表："+oneTimesList);
		
		/** 获取系统配置 */
		List<Object> lastConfigList = sharkConfigHave();
		System.out.println("最新配置列表："+lastConfigList);
		
		/** 获取上期彩金池 */
		lastDividend = lastDividendHave();
		System.out.println("上一期彩金："+lastDividend);		
		//延迟3000毫秒后调用出奖函数 
		try {
	        Thread.sleep(timeCircle*1000);//括号里面3000代表3000毫秒也3秒该成需要时间
		} catch (InterruptedException e) {
	        e.printStackTrace();
		}
		System.out.println("延迟时间即转盘时间："+timeCircle*1000);
		prizeString = havePrize();//统计获取奖项
		System.out.println("单场押注总额之和为："+totalBetSum);
		System.out.println("佣金收益为："+commissionProfit);
		System.out.println("本场中奖奖项为:"+prizeString);
		
		ArrayList<Object> beforePrizeList = new ArrayList<Object>();//之前中奖列表
		for(PrizeRecord prizeRecord: prizeEntity){
			beforePrizeList.add(prizeRecord.getPrizeName());
		}
		System.out.println("历次中奖奖项为:"+beforePrizeList);
		
		if(againOrNot == true){//如果是则获得再转一次
			turnAgain();
			System.out.println("本奖项有重转。");
			againOrNot = false;//重置
		}
		System.out.println("发奖后彩金："+dividend);	
		
		betClear();//重置清零
		
		/** 随机生成一组倍数 */
		RecordAction recordAction = new RecordAction();//调用RecordAction类里的函数
		recordAction.timesCreate();//为下一场随机生成一组倍数列表并保存到奖项记录中
		System.out.println("为下一场随机生成一组倍数列表");
		
		return main();		
	}
	/**
	 * 获取配置
	 * @return
	 */
	private List<Object> sharkConfigHave() {

		Map<String, String> orderby = new HashMap<String, String>();//定义Map集合
		orderby.put("createTime", "desc");//设置排序条件及方式
		PageModel<SharkConfig> configList = sharkConfigDao.find(-1, -1, orderby);//获取最近一条数据
		if(configList.getList().get(0).getId() != null){//存在配置
			topConfigList = sharkConfigDao.get(configList.getList().get(0).getId());//加载对象最新配置序列号
		}		
		ArrayList<Object> lastConfigList = new ArrayList<Object>();//之前中奖列表
		timeCircle = topConfigList.getTimeCircle();
		timeCycle = topConfigList.getTimeCycle();
		commission_rate = topConfigList.getCommissionRate();//获取最新的费率配置
		timesMax = topConfigList.getTimesMax();//获取最新的最大倍率配置
		lastConfigList.add(commission_rate);
		lastConfigList.add(topConfigList.getInitialDividend());
		lastConfigList.add(timesMax);
		lastConfigList.add(timeCycle);//周期
		lastConfigList.add(topConfigList.getBetLimit());
		lastConfigList.add(timeCircle);
		
		return lastConfigList;
	}
	/**
	 * 获取上场彩金池
	 * @return
	 */
	private static double lastDividendHave() {
		prizeEntity = prizeRecordHave();
		Double lastDividend = prizeEntity.get(0).getDividend();//获取上场奖项记录的彩金池记录
		return lastDividend;
	}
	/**
	 * 获取奖项记录
	 * @return
	 */
	private static List<PrizeRecord> prizeRecordHave() {
		/*String field =" dividend,prize_name ";//选择字段奖项
		String where = null;
		Object[] queryParams = null;
		Map<String, String> orderby = new HashMap<String, String>();//定义Map集合
		orderby.put("createTime", "desc");//设置排序条件及方式
		prizelist = prizeRecordDao.getNumResult(field, where, queryParams, orderby, 0, 1);//参数1表示只获取最近一条数据
		*/
		/*String field ="prize";//选择字段奖项
		String where = null;
		Object[] queryParams = null;
		Map<String, String> orderby = new HashMap<String, String>();//定义Map集合
		orderby.put("createTime", "desc");//设置排序条件及方式
		list = prizeRecordDao.getNumResult(field, where, queryParams, orderby, 0, countNum);
		*/
		//添加数据测试
		prizeEntity=new ArrayList<PrizeRecord>();		
		PrizeRecord prize1 = new PrizeRecord();
		prize1.setPrizeId("2014");
		prize1.setCommissionRate(0.10);
		prize1.setCreateTime(null);
		prize1.setPrizeName(Prize.RAFFLING);
		prize1.setDividend(310.0);
		prizeEntity.add(prize1);
		PrizeRecord prize2 = new PrizeRecord();
		prize2.setDividend(320.0);
		prize2.setPrizeName(Prize.SWALLOW);
		prizeEntity.add(prize2);
		PrizeRecord prize3 = new PrizeRecord();
		prize3.setPrizeName(Prize.RABBIT);
		prizeEntity.add(prize3);
		PrizeRecord prize4 = new PrizeRecord();
		prize4.setPrizeName(Prize.PEAFOWL);
		prizeEntity.add(prize4);
		PrizeRecord prize5 = new PrizeRecord();
		prize5.setPrizeName(Prize.EAGLE);
		prizeEntity.add(prize5);
		PrizeRecord prize6 = new PrizeRecord();
		prize6.setPrizeName(Prize.PANDA);
		prizeEntity.add(prize6);

		return prizeEntity;
	}
	/**
	 * 从奖项记录获得新存倍数
	 * @return
	 */
	private static List<Object> timesHave() {
		
		//从奖项记录获得新存倍数(必须有新存奖项)
		prizeEntity = prizeRecordHave();
		ArrayList<Object> oneTimesList = new ArrayList<Object>();
		oneTimesList.add(timesSwallow);//注意添加的顺序
		oneTimesList.add(timesPigeon);
		oneTimesList.add(timesPeafowl);
		oneTimesList.add(timesEagle);
		oneTimesList.add(timesLion);
		oneTimesList.add(timesPanda);
		oneTimesList.add(timesMonkey);
		oneTimesList.add(timesRabbit);
		return oneTimesList;
	}
	/**
	 * 出奖
	 * @return
	 */
	private Prize havePrize(){
		totalBetSum = countTotalPrice();//获得下注总额之和
		if(totalBetSum != 0){
			dividend = lastDividend + totalBetSum*(1-commission_rate);//筹码注入彩金池
			commissionProfit = totalBetSum*commission_rate;//佣金收益
			System.out.println("发奖前彩金："+dividend);
			if( dividend > (totalBetSum*timesMax) ){//如果已有99倍余额
				return sharkPrize();
			} else if( dividend > (totalBetSum*24) ){//如果已有24倍余额
				return randomPrize();//随机函数
			} else if( dividend > 0){
				return dividendUpPrize();//彩金池增加的吃分函数
			} else {
				//return attractPrize();//诱惑函数
				return randomPrize();//随机函数
			}
		}
		return randomPrize();
	}
	/**
	 * 统计各奖项押注之和，及总押注总额之和
	 * @return float 未操作押注总额之和 totalBetSum
	 */
	private double countTotalPrice() {
		Map<String, String> orderby = new HashMap<String, String>(1);//定义Map集合
		orderby.put("createTime", "desc");//设置按创建时间倒序排列
		String where = "where betCount = ?";//设置查询条件语句
		Object[] queryParams = {false};//获取未操作过的参数值
		pageModel = betDao.find(where, queryParams, orderby, -1, -1);//执行查询方法
		betEntity = pageModel.getList();//获取所有未操作过的下注条目
		//添加数据之后
		if(betEntity != null && betEntity.size() >0){
			for(PanelInfo panelInfo : betEntity){//遍历所有的下注条目
				//float single_bet = panelInfo.getSingle_bet();//获取每一条单注额度
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
					totalSwallowSum += swallow;
					totalPigeonSum += pigeon;//在totalPigeonSum不要求为静态等同于setTotalPigeonSum(getTotalPigeonSum() + totalPigeon)
					totalPeafowlSum += peafowl;
					totalEagleSum += eagle;
					totalLionSum += lion;
					totalPandaSum += panda;
					totalMonkeySum += monkey;
					totalRabbitSum += rabbit;
					totalBirdSum += bird;
					totalSilverSum += silver;
					totalBombSum += bomb;
					totalGoldSum += gold;
					totalBeastSum += beast;//相加所有条目禽兽的下注总额
					totalBet = (swallow+pigeon+peafowl+eagle+lion+panda+monkey+rabbit+bird+silver+bomb+gold+beast);//一条订单总下注
					totalBetSum += totalBet;//相加所有条目的下注总额
					betCount = true; //设置改变标记为已经统计过
					panelData = betDao.load(panelInfo.getPanelBetId());//装载下单对象
					panelData.setBetCount(betCount);// 更改筹码统计状态
					betDao.update(panelData);//更新修改操作状态
				}
			}
		}
		return totalBetSum;//返回总下注数目之和
	}
	/**
	 * 吃分函数
	 * @return
	 */
	private static Prize dividendUpPrize() {
		System.out.println("吃分函数：");
		againOrNot = false; //设置为false不重转
		double priceForPrize = totalBetSum*(1-commission_rate);//单场用于发奖注额
		double swallowOutScore = totalSwallowSum*timesSwallow;
		double pigeonOutScore = totalPigeonSum*timesPigeon;
		double peafowlOutScore = totalPeafowlSum*timesPeafowl;
		double eagleOutScore = totalEagleSum*timesEagle;
		double lionOutScore = totalLionSum*timesLion;
		double pandaOutScore = totalPandaSum*timesPanda;
		double monkeyOutScore = totalMonkeySum*timesMonkey;
		double rabbitOutScore = totalRabbitSum*timesRabbit;
		ArrayList<Object> totalOutSum = new ArrayList<Object>();//八个奖出分集合	
		totalOutSum.add(swallowOutScore);//注意顺序不能弄乱
		totalOutSum.add(pigeonOutScore);
		totalOutSum.add(peafowlOutScore);
		totalOutSum.add(eagleOutScore);
		totalOutSum.add(lionOutScore);
		totalOutSum.add(pandaOutScore);
		totalOutSum.add(monkeyOutScore);
		totalOutSum.add(rabbitOutScore);
		System.out.println("八个奖出分集合totalOutSum值："+totalOutSum);
		double birdOutScore = totalBirdSum*2;//飞禽总出分 ;
		double beastOutScore = totalBeastSum*2;//走兽总出分 ;
		Vector<Object> less = lessThan(totalOutSum,birdOutScore,beastOutScore,priceForPrize);//获得能吃分的几个奖项的索引的集合
		if(less.size() > 0 && less != null){//如果存在能吃分的奖项的索引
			System.out.println("存在正常吃分奖项");
			int index=(int)(Math.random()*less.size());//从总共less.size()个能吃分奖中，随机一个能吃分奖的索引的索引，
			if((Integer)less.get(index) == 0){//第index个吃分奖对应的索引
				dividend= dividend -swallowOutScore-birdOutScore;
				System.out.println("燕子发奖："+totalOutSum.get((Integer) less.get(index)));
				return Prize.SWALLOW;
			} else if((Integer)less.get(index) == 1){
				dividend= dividend -pigeonOutScore-birdOutScore;
				System.out.println("鸽子发奖："+totalOutSum.get((Integer) less.get(index)));
				return Prize.PIGEON;
			} else if((Integer)less.get(index) == 2){
				dividend= dividend -peafowlOutScore-birdOutScore;
				System.out.println("孔雀发奖："+totalOutSum.get((Integer) less.get(index)));
				return Prize.PEAFOWL;
			} else if((Integer)less.get(index) == 3){
				dividend= dividend -eagleOutScore-birdOutScore;
				System.out.println("老鹰发奖："+totalOutSum.get((Integer) less.get(index)));
				return Prize.EAGLE;
			} else if((Integer)less.get(index) == 4){
				dividend= dividend -lionOutScore-beastOutScore;
				System.out.println("狮子发奖："+totalOutSum.get((Integer) less.get(index)));
				return Prize.LION;
			} else if((Integer)less.get(index) == 5){
				dividend= dividend -pandaOutScore-beastOutScore;
				System.out.println("熊猫发奖："+totalOutSum.get((Integer) less.get(index)));
				return Prize.PANDA;
			}  else if((Integer)less.get(index) == 6){
				dividend= dividend -monkeyOutScore-beastOutScore;
				System.out.println("猴子发奖："+totalOutSum.get((Integer) less.get(index)));
				return Prize.MONKEY;
			}  else if((Integer)less.get(index) == 7){
				dividend= dividend -rabbitOutScore-beastOutScore;
				System.out.println("兔子发奖："+totalOutSum.get((Integer) less.get(index)));
				return Prize.RABBIT;
			} else{
				System.out.print("不应该出现的error");
			}
		} else {
			System.out.println("需要非正常吃分奖项");
			int countNum = 20 ;//统计20场
			bombOrNot = ifExistBomb(countNum);//查看20场内是否存在地雷
			if( bombOrNot == true){//如果20场内出现地雷奖项
				int i = outScoreMin(totalOutSum,birdOutScore,beastOutScore);//获取符合要求最小出分的奖项的索引
				if(i == 0){//第一个奖对应的索引
					System.out.println("燕子发奖："+totalOutSum.get(i));
					dividend= dividend -swallowOutScore-birdOutScore;
					return Prize.SWALLOW;
				} else if(i == 1){
					System.out.println("鸽子发奖："+totalOutSum.get(i));
					dividend= dividend -pigeonOutScore-birdOutScore;
					return Prize.PIGEON;
				} else if(i == 2){
					System.out.println("孔雀发奖："+totalOutSum.get(i));
					dividend= dividend -peafowlOutScore-birdOutScore;
					return Prize.PEAFOWL;
				} else if(i == 3){
					System.out.println("老鹰发奖："+totalOutSum.get(i));
					dividend= dividend -eagleOutScore-birdOutScore;
					return Prize.EAGLE;
				} else if(i == 4){
					System.out.println("狮子发奖："+totalOutSum.get(i));
					dividend= dividend -lionOutScore-beastOutScore;
					return Prize.LION;
				} else if(i == 5){
					System.out.println("熊猫发奖："+totalOutSum.get(i));
					dividend= dividend -pandaOutScore-beastOutScore;
					return Prize.PANDA;
				}  else if(i == 6){
					System.out.println("猴子发奖："+totalOutSum.get(i));
					dividend= dividend -monkeyOutScore-beastOutScore;
					return Prize.MONKEY;
				}  else if(i == 7){
					System.out.println("兔子发奖："+totalOutSum.get(i));
					dividend= dividend -rabbitOutScore-beastOutScore;
					return Prize.RABBIT;
				} else{
					System.out.print("不应该出现的error");
				}
			} else {
				return bombPrize();
			}
			
		}
		return null;
	}
	/**
	 * 几场之内是否存在地雷奖
	 * @param countNum
	 * @return
	 */
	private static boolean ifExistBomb(int countNum) {
		prizeEntity = prizeRecordHave();//获取奖项记录实体
		if(prizeEntity.size() < countNum ){
			for(int i=0 ; i < prizeEntity.size() ;i++){
				if(prizeEntity.get(i).getPrizeName() == Prize.BOMB){
					return true;//如果遍历的第一个就是地雷，后面就不遍历了
				}
			}
		} else {
			for(int i=0 ; i < countNum ;i++){
				if(prizeEntity.get(i).getPrizeName() == Prize.BOMB){
					return true;//如果遍历的第一个就是地雷，后面19个就不遍历了
				}
			}
		}
		return false;
	}
	/**
	 * 符合要求时最小的奖的索引
	 * @param totalSum
	 * @param birdOutScore
	 * @param beastOutScore
	 * @return
	 */
	private static int outScoreMin(ArrayList<Object> totalSum,
			double birdOutScore, double beastOutScore) {
		try{
			int x = 0;//预定义集合第一个值为符合要求值,记下索引值
			double min = Double.parseDouble(totalSum.get(0).toString()) + birdOutScore;//预定义集合第一个值加和为符合要求值
			if (totalSum.size() > 0){//集合多于两个值时
				for(int i=0 ; i<totalSum.size() ; i++){
					double temp = Double.parseDouble(totalSum.get(i).toString());
					if( i < (totalSum.size()/2) ){//飞禽类
						if ( min > (temp+birdOutScore)){
							min = (temp+birdOutScore);
							x = i;
						}
					} else {//走兽类
						if ( min > (temp+beastOutScore)){
							min = (temp+beastOutScore);
							x = i;
						}
					}
				}
				return x;//返回符合要求时最小的奖的索引
			}
		}catch (Exception ex) {
			System.out.printf("通用计算公式", "计算符合要求的值的索引:" + ex.getMessage());
        }
		return 0;
	}
	/**
	 * 获取能吃分的奖项的索引
	 * @param totalOutSum
	 * @param birdOutScore
	 * @param beastOutScore
	 * @param priceForPrize
	 * @return 索引集合
	 */
	private static Vector<Object> lessThan(ArrayList<Object> totalOutSum,
			double birdOutScore, double beastOutScore, double priceForPrize) {
		Vector<Object> v = new Vector<Object>(totalOutSum.size());
		for(int i=0 ; i<totalOutSum.size() ; i++){
			if( i < (totalOutSum.size()/2) ){//飞禽类
				if ((Double)totalOutSum.get(i) < (priceForPrize - birdOutScore)){
					v.add(i);
				}
			} else {//走兽类
				if ((Double)totalOutSum.get(i) < (priceForPrize - beastOutScore)){
					v.add(i);
				}
			}

		}
		return v;
	}
	/**
	 * 炸弹函数
	 * @return
	 */
	private static Prize bombPrize() {
		try{
			if( totalBombSum > 0 ){//如果有人下注
				System.out.println("炸弹有人:" + totalBombSum);
				dividend= dividend -totalBetSum*(1-commission_rate);
				System.out.println("发炸弹金额:" + totalBetSum*(1-commission_rate));
				return Prize.BOMB;
			} else {
				System.out.println("炸弹无人:" + totalBombSum);
				againOrNot = true; //设置为true再转
				return Prize.BOMB;
			}
		} catch  (Exception ex) {
			System.out.printf("炸弹函数问题。The problem of bomb.");
		}
		return null;
	}
	/**
	 * 随机函数
	 * @return
	 */
	private static Prize randomPrize() {
		System.out.print("随机函数：");
		againOrNot = false; //设置为false不重转
		int birdOrBeast =(int)(Math.floor(randomNum.nextInt(2)));//随机获取大于等于0到小于2的整数部分,即随机获取0或1
		if(birdOrBeast == 0){//为飞禽概率1/2
			double birdOutScore = totalBirdSum*2;//飞禽总出分
			dividend = dividend - birdOutScore; //发了飞禽奖的彩金池
			int birdWhat =(int)(Math.floor(randomNum.nextInt(4)));//随机获取大于等于0到小于4的整数部分,即随机获取0或1或2或3，概率都为1/4。
			if(birdWhat == 0){//奖项燕子
				double swallowOutScore = totalSwallowSum*timesSwallow;//燕子总出分，倍数暂时固定
				dividend = dividend - swallowOutScore; //发了第二个奖燕子后的彩金池
				return Prize.SWALLOW;
			} else if(birdWhat == 1){//奖项鸽子
				double pigeonOutScore = totalPigeonSum*timesPigeon;//鸽子总出分，倍数暂时固定
				dividend = dividend - pigeonOutScore; //发了第二个奖鸽子后的彩金池
				return Prize.PIGEON;
			} else if(birdWhat == 2){//奖项孔雀
				double peafowlOutScore = totalPeafowlSum*timesPeafowl;//鸽子总出分，倍数暂时固定
				dividend = dividend - peafowlOutScore; //发了第二个奖鸽子后的彩金池
				return Prize.PEAFOWL;
			} else if(birdWhat == 3){//奖项老鹰
				double eagleOutScore = totalEagleSum*timesEagle;//鸽子总出分，倍数暂时固定
				dividend = dividend - eagleOutScore; //发了第二个奖鸽子后的彩金池
				return Prize.EAGLE;
			} else {
				System.out.print("不应该出现的error");
			}
			//记得更新到数据库
		} else if(birdOrBeast == 1){//为走兽概率1/2
			double beastOutScore = totalBeastSum*2;//走兽总出分
			dividend = dividend - beastOutScore; //发了走兽奖的彩金池
			int beastWhat =(int)(Math.floor(randomNum.nextInt(4)));//随机获取大于等于0到小于4的整数部分,即随机获取0或1或2或3，概率都为1/4。
			if(beastWhat == 0){//奖项兔子
				double rabbitOutScore = totalRabbitSum*timesRabbit;//兔子总出分，倍数暂时固定
				dividend = dividend - rabbitOutScore; //发了第二个奖兔子后的彩金池
				return Prize.RABBIT;
			} else if(beastWhat == 1){//奖项猴子
				double monkeyOutScore = totalMonkeySum*timesMonkey;//猴子总出分，倍数暂时固定
				dividend = dividend - monkeyOutScore; //发了第二个奖猴子后的彩金池
				return Prize.MONKEY;
			} else if(beastWhat == 2){//奖项熊猫
				double pandaOutScore = totalPandaSum*timesPanda;//熊猫总出分，倍数暂时固定
				dividend = dividend - pandaOutScore; //发了第二个奖熊猫后的彩金池
				return Prize.PANDA;
			} else if(beastWhat == 3){//奖项狮子
				double lionOutScore = totalLionSum*timesLion;//狮子总出分，倍数暂时固定
				dividend = dividend - lionOutScore; //发了第二个奖狮子后的彩金池
				return Prize.LION;
			} else {
				System.out.print("不应该出现的error");
			}
		} else {
			System.out.print("不应该出现的error");
		}
		return null;
	}
	/**
	 * 鲨鱼函数
	 * @return
	 */
	private static Prize sharkPrize() {
		againOrNot = true; //设置为true，用于再转一次
		int silverOrGold = (int) Math.floor(randomNum.nextInt(2));//随机获取大于等于0到小于2的整数部分,即随机获取0或1
		if(silverOrGold == 0){//为银鲨概率1/2
			double silverOutScore = totalSilverSum*24;//银鲨总出分
			dividend = dividend - silverOutScore; //发了银鲨奖的彩金池
			//记得更新到数据库
			return Prize.SILVER_SHARK;//出奖银鲨+再转一次
		} else if(silverOrGold == 1){//为金鲨概率1/2
			int goldSharkTimes =(int)(Math.floor(randomNum.nextInt(timesMax-23))+24);//随机获取大于等于24到小于100的整数，即最高99倍
			double goldOutScore = totalGoldSum*goldSharkTimes;//金鲨总出分
			dividend = dividend - goldOutScore; //发了金鲨奖的彩金池
			//记得更新到数据库
			System.out.println("金鲨倍数："+goldSharkTimes);
			return Prize.GOLD_SHARK;//出奖金鲨+再转一次
		} else {
			System.out.print("不应该出现的error");
		}
		return null;
	}
	/**
	 * 再转函数
	 */
	private static void turnAgain() {
		System.out.println("再转函数");
	}
	
}
