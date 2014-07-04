package com.grq.controller.action.shark;


import java.util.ArrayList;

import java.util.List;

import java.util.Random;
import java.util.Vector;

import com.grq.controller.action.BaseAction;
//import com.grq.model.PageModel;
import com.grq.model.customizeenum.Prize;
import com.grq.model.pojo.shark.PanelInfo;
import com.grq.model.pojo.shark.PrizeRecord;
import com.opensymphony.xwork2.ModelDriven;

public class sharkTest extends BaseAction implements ModelDriven<PanelInfo>{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* 游戏配置后期单独做一块 */
	//游戏倍数系统内部生成
	static int timesSwallow = 6;
	static int timesPigeon = 6;
	static int timesPeafowl = 8;
	static int timesEagle = 24;
	static int timesLion = 24;
	static int timesPanda = 8;
	static int timesMonkey = 6;
	static int timesRabbit = 6;
	
	//配置时间
	int time_circle= 3;//计算转盘花费的时间4秒，从而计算转盘速度
	int time_observe= 6; //观察时长 后期由服务器取得
	int time_bet= 12;//下注时长 后期由服务器取得
	int time_display= 3;//展示时长 后期由服务器取得
	int time_wait= 2;//等待时长 后期由服务器取得
	//int time_cycle;//一个周期时长 计算所得非配置,转盘-展示-等待-观察-下注
	//转盘配置
	int circle_num= 2;//转盘圈数 后期由服务器取得
	//关键配置
	static int timesMax = 99;//最高倍数
	static double commission_rate = 0.60; //佣金费率
	//int single_bet = 1; //单注额度调整
	int bet_limit = 999; //押注上限
	double initial_dividend =300;//彩金初始值
	
	//本类中的区域变量
	static double dividend; //彩金池变量需要储存在数据库中
	private static Random randomNum = new Random();//用于获取随机数
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
	private static boolean againOrNot; //是否重转，默认否
	private static Prize prizeString;//奖项变量，默认正在抽奖
	
	private static boolean bombOrNot; //是否存在炸弹，默认否
	// 奖项实体列表
	private static List<PrizeRecord> prizelist;
	private static Integer totalBet;//一条下注订单总筹码
	private static double totalBetSum;//一场下注总金额
	
	
	
	
	public static void main(String[] args) {
		List<PrizeRecord> beforePrizeList = beforePrize();
		dividend = beforePrizeList.get(0).getDividend();//获取上一盘彩金池
		
		System.out.println("上一期彩金："+dividend);
		prizeString = havePrize();
		System.out.println("单场押注总额之和为："+totalBetSum);
		
		System.out.println("系统费率："+commission_rate);
		System.out.println("本场中奖奖项为:"+prizeString);
		if(againOrNot == true){//如果是则获得再转一次
			turnAgain();
			System.out.println("本奖项有重转。");
			againOrNot = false;//重置
		}
		System.out.println("发奖后彩金："+dividend);
	}
	private static void turnAgain() {
		System.out.println("再转函数");		
	}
	/**
	 * 上一场的奖项记录
	 * @return
	 */
	private static List<PrizeRecord> beforePrize() {
		/*String field =" dividend,prize_name ";//选择字段奖项
		String where = null;
		Object[] queryParams = null;
		Map<String, String> orderby = new HashMap<String, String>();//定义Map集合
		orderby.put("createTime", "desc");//设置排序条件及方式
		prizelist = prizeRecordDao.getNumResult(field, where, queryParams, orderby, 0, 1);//参数1表示只获取最近一条数据
		*/
		//添加数据测试
		prizelist=new ArrayList<PrizeRecord>();		
		PrizeRecord prize1 = new PrizeRecord();	
		prize1.setDividend(300.0);
		prize1.setPrizeName(Prize.RABBIT);
		prizelist.add(prize1);		
		PrizeRecord prize2 = new PrizeRecord();
		prize2.setDividend(320.0);
		prize2.setPrizeName(Prize.PIGEON);
		prizelist.add(prize2);

		return prizelist;
	}
	/**
	 * 出奖
	 * @return
	 */
	private static Prize havePrize(){
		double totalPriceSum = countTotalPrice();//获得下注总额之和
		dividend = dividend + totalPriceSum*(1-commission_rate);//筹码注入彩金池
		System.out.println("发奖前彩金："+dividend);
		if( dividend > (totalPriceSum*timesMax) ){//如果已有99倍余额
			return sharkPrize();
		} else if( dividend > (totalPriceSum*24) ){//如果已有24倍余额
			return randomPrize();//随机函数
		} else if( dividend > 0){
			return dividendUpPrize();//彩金池增加的吃分函数
		} else {
			//setPrizeString(attractPrize());//诱惑函数
			return randomPrize();//随机函数
		}
	}
	private static Prize dividendUpPrize() {
		System.out.print("吃分函数：");
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
		System.out.println("八个奖出分集合totalSum值："+totalOutSum);
		double birdOutScore = getTotalBirdSum()*2;//飞禽总出分 ;
		double beastOutScore = getTotalBeastSum()*2;//走兽总出分 ;
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
			bombOrNot = queryNumResult(countNum);//查看20场内是否存在地雷
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

	
	private static boolean queryNumResult(int countNum) {
		/*String field ="prize";//选择字段奖项
		String where = null;
		Object[] queryParams = null;
		Map<String, String> orderby = new HashMap<String, String>();//定义Map集合
		orderby.put("createTime", "desc");//设置排序条件及方式
		list = prizeRecordDao.getNumResult(field, where, queryParams, orderby, 0, countNum);*/
		
		//添加数据测试
		prizelist=new ArrayList<PrizeRecord>();		
		PrizeRecord prize1 = new PrizeRecord();
		prize1.setPrizeId("2014");
		prize1.setCommissionRate(0.10);
		prize1.setCreateTime(null);	
		prize1.setPrizeName(Prize.RAFFLING);
		prizelist.add(prize1);		
		PrizeRecord prize2 = new PrizeRecord();
		prize2.setPrizeName(Prize.BOMB);
		prizelist.add(prize2);
		ArrayList<Object> onlyPrizeList = new ArrayList<Object>();//之前中奖列表
		for(PrizeRecord prizeRecord: prizelist){
			onlyPrizeList.add(prizeRecord.getPrizeName());
		}
		System.out.println("query之前中奖列表："+onlyPrizeList);
		for(int i=0 ; i < prizelist.size() ;i++){
			if(prizelist.get(i).getPrizeName() == Prize.BOMB){
				return true;//如果遍历的第一个就是地雷，后面19个就不遍历了
			}
		}
		return false;
	}
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
				return x;//返回符合要求的和最小的奖的索引
			}
			
		}catch (Exception ex) {
			System.out.printf("通用计算公式", "计算符合要求的值的索引:" + ex.getMessage());
        }
		return 0;
	}
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
	private static Prize bombPrize() {
		try{
			if( totalBombSum > 0 ){//如果有人下注
				System.out.println("炸有人:" + totalBombSum);
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
	private static Prize randomPrize() {
		System.out.print("随机函数：");
		againOrNot = false; //设置为false不重转
		int birdOrBeast =(int)(Math.floor(randomNum.nextInt(2)));//随机获取大于等于0到小于2的整数部分,即随机获取0或1
		if(birdOrBeast == 0){//为飞禽概率1/2
			double birdOutScore = getTotalBirdSum()*2;//飞禽总出分
			dividend = dividend - birdOutScore; //发了飞禽奖的彩金池
			int birdWhat =(int)(Math.floor(randomNum.nextInt(4)));//随机获取大于等于0到小于4的整数部分,即随机获取0或1或2或3，概率都为1/4。
			if(birdWhat == 0){//奖项燕子
				double swallowOutScore = getTotalSwallowSum()*timesSwallow;//燕子总出分，倍数暂时固定
				dividend = dividend - swallowOutScore; //发了第二个奖燕子后的彩金池
				return Prize.SWALLOW;
			} else if(birdWhat == 1){//奖项鸽子
				double pigeonOutScore = getTotalPigeonSum()*timesPigeon;//鸽子总出分，倍数暂时固定
				dividend = dividend - pigeonOutScore; //发了第二个奖鸽子后的彩金池
				return Prize.PIGEON;
			} else if(birdWhat == 2){//奖项孔雀
				double peafowlOutScore = getTotalPeafowlSum()*timesPeafowl;//鸽子总出分，倍数暂时固定
				dividend = dividend - peafowlOutScore; //发了第二个奖鸽子后的彩金池
				return Prize.PEAFOWL;
			} else if(birdWhat == 3){//奖项老鹰
				double eagleOutScore = getTotalEagleSum()*timesEagle;//鸽子总出分，倍数暂时固定
				dividend = dividend - eagleOutScore; //发了第二个奖鸽子后的彩金池
				return Prize.EAGLE;
			} else {
				System.out.print("不应该出现的error");
			}
			//记得更新到数据库
		} else if(birdOrBeast == 1){//为走兽概率1/2
			double beastOutScore = getTotalBeastSum()*2;//走兽总出分
			dividend = dividend - beastOutScore; //发了走兽奖的彩金池
			int beastWhat =(int)(Math.floor(randomNum.nextInt(4)));//随机获取大于等于0到小于4的整数部分,即随机获取0或1或2或3，概率都为1/4。
			if(beastWhat == 0){//奖项兔子
				double rabbitOutScore = getTotalRabbitSum()*timesRabbit;//兔子总出分，倍数暂时固定
				dividend = dividend - rabbitOutScore; //发了第二个奖兔子后的彩金池
				return Prize.RABBIT;
			} else if(beastWhat == 1){//奖项猴子
				double monkeyOutScore = getTotalMonkeySum()*timesMonkey;//猴子总出分，倍数暂时固定
				dividend = dividend - monkeyOutScore; //发了第二个奖猴子后的彩金池
				return Prize.MONKEY;
			} else if(beastWhat == 2){//奖项熊猫
				double pandaOutScore = getTotalPandaSum()*timesPanda;//熊猫总出分，倍数暂时固定
				dividend = dividend - pandaOutScore; //发了第二个奖熊猫后的彩金池
				return Prize.PANDA;
			} else if(beastWhat == 3){//奖项狮子
				double lionOutScore = getTotalLionSum()*timesLion;//狮子总出分，倍数暂时固定
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
	private static Prize sharkPrize() {
		againOrNot = true; //设置为true，用于再转一次
		double a = Math.floor(randomNum.nextInt(2));//随机获取大于等于0到小于2的整数部分,即随机获取0或1
		int silverOrGold = (int)a;//将double数据类型转换成int
		if(silverOrGold == 0){//为银鲨概率1/2
			double silverOutScore = getTotalSilverSum()*24;//银鲨总出分
			dividend = dividend - silverOutScore; //发了银鲨奖的彩金池
			//记得更新到数据库
			return Prize.SILVER_SHARK;//出奖银鲨+再转一次
		} else if(silverOrGold == 1){//为金鲨概率1/2
			int goldSharkTimes =(int)(Math.floor(randomNum.nextInt(timesMax-23))+24);//随机获取大于等于24到小于100的整数，即最高99倍
			double goldOutScore = getTotalGoldSum()*goldSharkTimes;//金鲨总出分
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
	 * 统计各奖项押注之和，及总押注总额之和
	 * @return float 未操作押注总额之和 totalBetSum
	 */
	private static double countTotalPrice() {
		/*
		Map<String, String> orderby = new HashMap<String, String>(1);//定义Map集合
		orderby.put("createTime", "desc");//设置按创建时间倒序排列
		String where = "where betCount = ?";//设置查询条件语句
		Object[] queryParams = {false};//获取未操作过的参数值
		pageModel = sharkDaoTest.find(where, queryParams, orderby, -1, -1);//执行查询方法
		List<PanelInfo> allBet = pageModel.getList();//获取所有未操作过的下注条目
		*/
		// 下注列表
		List<PanelInfo> allBet;
		
		//添加数据测试
		allBet = new ArrayList<PanelInfo>();		
		PanelInfo bet1 = new PanelInfo();
		bet1.setSingle_bet(10);
		bet1.setSwallow(1);
		bet1.setPigeon(1);
		bet1.setPeafowl(1);
		bet1.setEagle(1);
		bet1.setLion(1);
		bet1.setPanda(1);
		bet1.setMonkey(1);
		bet1.setRabbit(1);
		bet1.setBird(1);
		bet1.setBeast(1);
		bet1.setBomb(1);
		bet1.setSilver_shark(1);
		bet1.setGold_shark(1);
		bet1.setCreateTime(null);	
		bet1.setPrizeItem(Prize.RAFFLING);
		bet1.setBetCount(false);
		allBet.add(bet1);
		
		PanelInfo bet2 = new PanelInfo();
		bet2.setSingle_bet(10);
		bet2.setSwallow(1);
		bet2.setPigeon(1);
		bet2.setPeafowl(1);
		bet2.setEagle(1);
		bet2.setLion(1);
		bet2.setPanda(1);
		bet2.setMonkey(1);
		bet2.setRabbit(1);
		bet2.setBird(1);
		bet2.setBeast(1);
		bet2.setBomb(1);
		bet2.setSilver_shark(1);
		bet2.setGold_shark(1);
		bet2.setCreateTime(null);	
		bet2.setPrizeItem(Prize.RAFFLING);
		bet2.setBetCount(false);
		allBet.add(bet2);
		
		
		for(PanelInfo panelInfo : allBet){//遍历所有的下注条目
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
				totalBombSum += silver;
				totalGoldSum += gold;
				totalBeastSum += beast;//相加所有条目禽兽的下注总额
				totalBet = (swallow+pigeon+peafowl+eagle+lion+panda+monkey+rabbit+bird+silver+bomb+gold+beast);//一条订单总下注
				setTotalBetSum(getTotalBetSum() + totalBet);//相加所有条目的下注总额
				betCount = true; //设置改变标记为已经统计过
				//panelData = sharkDaoTest.load(panelData.getPanelBetId());//装载订单对象
				panelData.setBetCount(betCount);// 设置操作情况
				//sharkDaoTest.update(panelData);//更新修改操作状态
			}
		}
		System.out.println("系统单场押注总额之和为："+totalBetSum);
		return totalBetSum;//返回总下注数目之和
	}

	// 键盘panel对象
	private static PanelInfo panelData = new PanelInfo();//一定要先初始化obj对象！
	/**
	 * 此方法是Modeldriven接口的方法，要重写
	 * @return
	 */
	@Override
	public PanelInfo getModel() {
		return panelData;
	}
	//getter和setter方法，放入request中，好在jsp页面中能拿到
	//public PageModel<PanelInfo> getPageModel() {
	//	return pageModel;
	//}
	//public void setPageModel(PageModel<PanelInfo> pageModel) {
	//	sharkTest.pageModel = pageModel;
	//}
	//getter和setter方法
	public static double getTotalSwallowSum() {
		return totalSwallowSum;
	}
	public static void setTotalSwallowSum(double totalSwallowSum) {
		sharkTest.totalSwallowSum = totalSwallowSum;
	}
	public static double getTotalPigeonSum() {
		return totalPigeonSum;
	}
	public void setTotalPigeonSum(float totalPigeonSum) {
		sharkTest.totalPigeonSum = totalPigeonSum;
	}
	public static double getTotalPeafowlSum() {
		return totalPeafowlSum;
	}
	public void setTotalPeafowlSum(float totalPeafowlSum) {
		sharkTest.totalPeafowlSum = totalPeafowlSum;
	}
	public static double getTotalEagleSum() {
		return totalEagleSum;
	}
	public void setTotalEagleSum(float totalEagleSum) {
		sharkTest.totalEagleSum = totalEagleSum;
	}
	public static double getTotalLionSum() {
		return totalLionSum;
	}
	public void setTotalLionSum(float totalLionSum) {
		sharkTest.totalLionSum = totalLionSum;
	}
	public static double getTotalPandaSum() {
		return totalPandaSum;
	}
	public void setTotalPandaSum(float totalPandaSum) {
		sharkTest.totalPandaSum = totalPandaSum;
	}
	public static double getTotalMonkeySum() {
		return totalMonkeySum;
	}
	public void setTotalMonkeySum(float totalMonkeySum) {
		sharkTest.totalMonkeySum = totalMonkeySum;
	}
	public static double getTotalRabbitSum() {
		return totalRabbitSum;
	}
	public void setTotalRabbitSum(float totalRabbitSum) {
		sharkTest.totalRabbitSum = totalRabbitSum;
	}
	public static double getTotalBirdSum() {
		return totalBirdSum;
	}
	public void setTotalBirdSum(float totalBirdSum) {
		sharkTest.totalBirdSum = totalBirdSum;
	}
	public static double getTotalSilverSum() {
		return totalSilverSum;
	}
	public void setTotalSilverSum(float totalSilverSum) {
		sharkTest.totalSilverSum = totalSilverSum;
	}
	public double getTotalBombSum() {
		return totalBombSum;
	}
	public void setTotalBombSum(float totalBombSum) {
		sharkTest.totalBombSum = totalBombSum;
	}
	public static double getTotalGoldSum() {
		return totalGoldSum;
	}
	public void setTotalGoldSum(float totalGoldSum) {
		sharkTest.totalGoldSum = totalGoldSum;
	}
	public static double getTotalBeastSum() {
		return totalBeastSum;
	}
	public void setTotalBeastSum(float totalBeastSum) {
		sharkTest.totalBeastSum = totalBeastSum;
	}
	public static List<PrizeRecord> getPrizelist() {
		return prizelist;
	}
	public static void setPrizelist(List<PrizeRecord> prizelist) {
		sharkTest.prizelist = prizelist;
	}
	public static double getTotalBetSum() {
		return totalBetSum;
	}
	public static void setTotalBetSum(double totalBetSum) {
		sharkTest.totalBetSum = totalBetSum;
	}
}
