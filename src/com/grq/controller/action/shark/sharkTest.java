package com.grq.controller.action.shark;


import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import com.grq.controller.action.BaseAction;
import com.grq.model.PageModel;
import com.grq.model.customizeenum.Prize;
import com.grq.model.pojo.shark.PanelInfo;
import com.opensymphony.xwork2.ModelDriven;

public class sharkTest extends BaseAction implements ModelDriven<PanelInfo>{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* 游戏配置后期单独做一块 */
	//游戏倍数
	static int timesSwallow = 6;
	static int timesPigeon = 6;
	static int timesPeafowl = 8;
	static int timesEagle = 24;
	static int timesLion = 24;
	static int timesPanda = 8;
	static int timesMonkey = 6;
	static int timesRabbit = 6;
	static int timesMax = 99;//最高倍数
	//配置时间
	int time_spend= 3;//计算转盘花费的时间4秒，从而计算转盘速度
	int time_observe= 6; //观察时长 后期由服务器取得
	int time_bet= 12;//下注时长 后期由服务器取得
	int time_display= 3;//展示时长 后期由服务器取得
	int time_wait= 2;//等待时长 后期由服务器取得
	//int time_cycle;//一个周期时长 计算所得非配置,转盘-展示-等待-观察-下注
	//转盘配置
	int circle_num= 2;//转盘圈数 后期由服务器取得
	//关键配置	
	static double dividend = 3000.00; //彩金池变量
	static double commission_rate = 0.10; //佣金费率
	double single_bet = 1000.00; //单注上限
	int bet_limit = 999; //押注上限
	
	private static PageModel<PanelInfo> pageModel;// 分页组件
	//private static PageModel<PanelInfo> pageModel;// 分页组件
	private static Random randomNum = new Random();//用于获取随机数
	private static double totalPriceSum = 0.0; //统计下注总额之和的变量
	private static double totalSwallowSum = 0f; //统计燕子下注总额之和
	private static double totalPigeonSum = 0f;
	private static double totalPeafowlSum = 0f;
	private static double totalEagleSum = 0f;
	private static double totalLionSum = 0f;
	private static double totalPandaSum = 0f;
	private static double totalMonkeySum = 0f;
	private static double totalRabbitSum = 0f;
	private static double totalBirdSum = 0f;//统计飞禽下注总额之和
	private static double totalSilverSum = 0.0;
	private static double totalBombSum = 0f;
	private static double totalGoldSum = 0.0;
	private static double totalBeastSum = 0f;//统计走兽下注总额之和
	private static boolean againOrNot = false; //是否重转，默认否
	private static Prize prizeString = Prize.RAFFLING;//奖项变量，默认正在抽奖
	
	
	public static void main(String[] args) {
		System.out.println("上一期彩金："+dividend);
		prizeString = havePrize();
		if(againOrNot == true){//如果是则获得再转一次
			turnAgain();
			againOrNot = false;//重置
		}
		System.out.println("单场押注总额之和为："+totalPriceSum);
		System.out.println("奖项为:"+prizeString);
		System.out.println("发奖后彩金："+dividend);
	}
	private static void turnAgain() {
		System.out.println("再转函数");		
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
		double priceForPrize = totalPriceSum*(1-commission_rate);//单场用于发奖注额
		double swallowOutScore = totalSwallowSum*timesSwallow;
		double pigeonOutScore = totalPigeonSum*timesPigeon;
		double peafowlOutScore = totalPeafowlSum*timesPeafowl;
		double eagleOutScore = totalEagleSum*timesEagle;
		double lionOutScore = totalLionSum*timesLion;
		double pandaOutScore = totalPandaSum*timesPanda;
		double monkeyOutScore = totalMonkeySum*timesMonkey;
		double rabbitOutScore = totalRabbitSum*timesRabbit;		
		ArrayList<Object> totalSum = new ArrayList<Object>();//八个奖出分集合		
		totalSum.add(swallowOutScore);//注意顺序不能弄乱
		totalSum.add(pigeonOutScore);
		totalSum.add(peafowlOutScore);
		totalSum.add(eagleOutScore);
		totalSum.add(lionOutScore);
		totalSum.add(pandaOutScore);
		totalSum.add(monkeyOutScore);
		totalSum.add(rabbitOutScore);
		double birdOutScore = getTotalBirdSum()*2;//飞禽总出分 ;
		double beastOutScore = getTotalBeastSum()*2;//走兽总出分 ;
		Vector<Object> less = lessThan(totalSum,birdOutScore,beastOutScore,priceForPrize);//获得能吃分的几个奖项的索引的集合
		if(less.size() > 0 && less != null){//如果存在能吃分的奖项的索引
			System.out.println("存在正常吃分奖项");
			int index=(int)(Math.random()*less.size());//从总共less.size()个能吃分奖中，随机一个能吃分奖的索引的索引，
			if((Integer)less.get(index) == 0){//第index个吃分奖对应的索引
				dividend= dividend -swallowOutScore-birdOutScore;
				System.out.println("燕子发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.SWALLOW;
			} else if((Integer)less.get(index) == 1){
				dividend= dividend -pigeonOutScore-birdOutScore;
				System.out.println("鸽子发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.PIGEON;
			} else if((Integer)less.get(index) == 2){
				dividend= dividend -peafowlOutScore-birdOutScore;
				System.out.println("孔雀发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.PEAFOWL;
			} else if((Integer)less.get(index) == 3){
				dividend= dividend -eagleOutScore-birdOutScore;
				System.out.println("老鹰发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.EAGLE;
			} else if((Integer)less.get(index) == 4){
				dividend= dividend -lionOutScore-beastOutScore;
				System.out.println("狮子发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.LION; 
			} else if((Integer)less.get(index) == 5){
				dividend= dividend -pandaOutScore-beastOutScore;
				System.out.println("熊猫发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.PANDA;
			}  else if((Integer)less.get(index) == 6){
				dividend= dividend -monkeyOutScore-beastOutScore;
				System.out.println("猴子发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.MONKEY;
			}  else if((Integer)less.get(index) == 7){
				dividend= dividend -rabbitOutScore-beastOutScore;
				System.out.println("兔子发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.RABBIT;
			} else{
				System.out.print("不应该出现的error");
			}
		} else {
			System.out.println("需要非正常吃分奖项");
			int bombNum = 21;
			if(bombNum < 20){//判断20场内是否出现地雷奖项，这里要再写
				int i = outScoreMin(totalSum,birdOutScore,beastOutScore);//获取符合要求的值的索引
				if(i == 0){//第一个奖对应的索引
					System.out.println("燕子发奖："+totalSum.get(i));
					dividend= dividend -swallowOutScore-birdOutScore;
					return Prize.SWALLOW;
				} else if(i == 1){
					System.out.println("鸽子发奖："+totalSum.get(i));
					dividend= dividend -pigeonOutScore-birdOutScore;
					return Prize.PIGEON;
				} else if(i == 2){
					System.out.println("孔雀发奖："+totalSum.get(i));
					dividend= dividend -peafowlOutScore-birdOutScore;
					return Prize.PEAFOWL;
				} else if(i == 3){
					System.out.println("老鹰发奖："+totalSum.get(i));
					dividend= dividend -eagleOutScore-birdOutScore;
					return Prize.EAGLE;
				} else if(i == 4){
					System.out.println("狮子发奖："+totalSum.get(i));
					dividend= dividend -lionOutScore-beastOutScore;
					return Prize.LION; 
				} else if(i == 5){
					System.out.println("熊猫发奖："+totalSum.get(i));
					dividend= dividend -pandaOutScore-beastOutScore;
					return Prize.PANDA;
				}  else if(i == 6){
					System.out.println("猴子发奖："+totalSum.get(i));
					dividend= dividend -monkeyOutScore-beastOutScore;
					return Prize.MONKEY;
				}  else if(i == 7){
					System.out.println("兔子发奖："+totalSum.get(i));
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
	private static int outScoreMin(ArrayList<Object> totalSum,
			double birdOutScore, double beastOutScore) {
		try{
			int x = 0;//预定义集合第一个值为符合要求值,记下索引值
			double min = Float.parseFloat(totalSum.get(0).toString()) + birdOutScore;//预定义集合第一个值加和为符合要求值
			if (totalSum.size() > 0){//集合多于两个值时
				for(int i=0 ; i<totalSum.size() ; i++){
					double temp = Float.parseFloat(totalSum.get(i).toString());
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
	private static Vector<Object> lessThan(ArrayList<Object> totalSum,
			double birdOutScore, double beastOutScore, double priceForPrize) {
		Vector<Object> v = new Vector<Object>(totalSum.size());
		for(int i=0 ; i<totalSum.size() ; i++){
			if( i < (totalSum.size()/2) ){//飞禽类
				if ((Double)totalSum.get(i) < (priceForPrize - birdOutScore)){
					v.add(i);
				}
			} else {//走兽类
				if ((Double)totalSum.get(i) < (priceForPrize - beastOutScore)){
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
				dividend= dividend -totalPriceSum*(1-commission_rate);
				System.out.println("发炸弹金额:" + totalPriceSum*(1-commission_rate));
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
				double swallowOutScore = getTotalSwallowSum()*6;//燕子总出分，倍数暂时固定
				dividend = dividend - swallowOutScore; //发了第二个奖燕子后的彩金池
				return Prize.SWALLOW;
			} else if(birdWhat == 1){//奖项鸽子
				double pigeonOutScore = getTotalPigeonSum()*6;//鸽子总出分，倍数暂时固定
				dividend = dividend - pigeonOutScore; //发了第二个奖鸽子后的彩金池
				return Prize.PIGEON;
			} else if(birdWhat == 2){//奖项孔雀
				double peafowlOutScore = getTotalPeafowlSum()*8;//鸽子总出分，倍数暂时固定
				dividend = dividend - peafowlOutScore; //发了第二个奖鸽子后的彩金池
				return Prize.PEAFOWL;
			} else if(birdWhat == 3){//奖项老鹰
				double eagleOutScore = getTotalEagleSum()*24;//鸽子总出分，倍数暂时固定
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
				double rabbitOutScore = getTotalRabbitSum()*6;//兔子总出分，倍数暂时固定
				dividend = dividend - rabbitOutScore; //发了第二个奖兔子后的彩金池
				return Prize.RABBIT;
			} else if(beastWhat == 1){//奖项猴子
				double monkeyOutScore = getTotalMonkeySum()*6;//猴子总出分，倍数暂时固定
				dividend = dividend - monkeyOutScore; //发了第二个奖猴子后的彩金池
				return Prize.MONKEY;
			} else if(beastWhat == 2){//奖项熊猫
				double pandaOutScore = getTotalPandaSum()*8;//熊猫总出分，倍数暂时固定
				dividend = dividend - pandaOutScore; //发了第二个奖熊猫后的彩金池
				return Prize.PANDA;
			} else if(beastWhat == 3){//奖项狮子
				double lionOutScore = getTotalLionSum()*24;//狮子总出分，倍数暂时固定
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
			System.out.print("金鲨倍数："+goldSharkTimes);
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
		totalSwallowSum =1.5;
		totalPigeonSum =1.4;
		totalPeafowlSum =1.0;
		totalEagleSum =1.1;
		totalLionSum =1.0;
		totalPandaSum =1.0;
		totalMonkeySum =7.0;		
		totalRabbitSum =1.5;
		totalBirdSum =1.0;
		totalBombSum =0.5;
		totalBeastSum =1.0;
		totalSilverSum = 1.0;
		totalGoldSum = 1.0;
		totalPriceSum = totalSwallowSum+totalPigeonSum+totalPeafowlSum+totalEagleSum+totalLionSum+totalPandaSum+totalMonkeySum+totalRabbitSum+totalBirdSum+totalBombSum+totalBeastSum+ totalSilverSum + totalGoldSum;
		//System.out.print("系统单场押注总额之和为："+totalPriceSum);
		return totalPriceSum;//返回总下注数目之和
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
	public PageModel<PanelInfo> getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel<PanelInfo> pageModel) {
		this.pageModel = pageModel;
	}
	//getter和setter方法
	public double getTotalPriceSum() {
		return totalPriceSum;
	}
	public void setTotalPriceSum(float totalPriceSum) {
		this.totalPriceSum = totalPriceSum;
	}
	public static double getTotalSwallowSum() {
		return totalSwallowSum;
	}
	public void setTotalSwallowSum(float totalSwallowSum) {
		this.totalSwallowSum = totalSwallowSum;
	}
	public static double getTotalPigeonSum() {
		return totalPigeonSum;
	}
	public void setTotalPigeonSum(float totalPigeonSum) {
		this.totalPigeonSum = totalPigeonSum;
	}
	public static double getTotalPeafowlSum() {
		return totalPeafowlSum;
	}
	public void setTotalPeafowlSum(float totalPeafowlSum) {
		this.totalPeafowlSum = totalPeafowlSum;
	}
	public static double getTotalEagleSum() {
		return totalEagleSum;
	}
	public void setTotalEagleSum(float totalEagleSum) {
		this.totalEagleSum = totalEagleSum;
	}
	public static double getTotalLionSum() {
		return totalLionSum;
	}
	public void setTotalLionSum(float totalLionSum) {
		this.totalLionSum = totalLionSum;
	}
	public static double getTotalPandaSum() {
		return totalPandaSum;
	}
	public void setTotalPandaSum(float totalPandaSum) {
		this.totalPandaSum = totalPandaSum;
	}
	public static double getTotalMonkeySum() {
		return totalMonkeySum;
	}
	public void setTotalMonkeySum(float totalMonkeySum) {
		this.totalMonkeySum = totalMonkeySum;
	}
	public static double getTotalRabbitSum() {
		return totalRabbitSum;
	}
	public void setTotalRabbitSum(float totalRabbitSum) {
		this.totalRabbitSum = totalRabbitSum;
	}
	public static double getTotalBirdSum() {
		return totalBirdSum;
	}
	public void setTotalBirdSum(float totalBirdSum) {
		this.totalBirdSum = totalBirdSum;
	}
	public static double getTotalSilverSum() {
		return totalSilverSum;
	}
	public void setTotalSilverSum(float totalSilverSum) {
		this.totalSilverSum = totalSilverSum;
	}
	public double getTotalBombSum() {
		return totalBombSum;
	}
	public void setTotalBombSum(float totalBombSum) {
		this.totalBombSum = totalBombSum;
	}
	public static double getTotalGoldSum() {
		return totalGoldSum;
	}
	public void setTotalGoldSum(float totalGoldSum) {
		this.totalGoldSum = totalGoldSum;
	}
	public static double getTotalBeastSum() {
		return totalBeastSum;
	}
	public void setTotalBeastSum(float totalBeastSum) {
		this.totalBeastSum = totalBeastSum;
	}
	public boolean isAgainOrNot() {
		return againOrNot;
	}
	public void setAgainOrNot(boolean againOrNot) {
		this.againOrNot = againOrNot;
	}
}
