package com.grq.model;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Random;
import java.util.TimerTask;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.grq.controller.action.shark.OptionAction;
import com.grq.model.customizeenum.Prize;
import com.grq.model.dao.shark.BetDao;
import com.grq.model.dao.shark.PrizeRecordDao;
import com.grq.model.dao.shark.SharkConfigDao;
import com.grq.model.pojo.shark.PanelInfo;
import com.grq.model.pojo.shark.PrizeRecord;
import com.grq.model.pojo.shark.SharkConfig;
import com.grq.model.pojo.shark.TimesEntity;
import com.grq.model.util.StringUtil;

public class SharkRun extends TimerTask {
	private PanelInfo panelData = new PanelInfo();//一定要先初始化obj对象！
	private PrizeRecord prizeRecord = new PrizeRecord();//一定要先初始化obj对象！
	private static Random randomNum = new Random();//用于获取随机数
	
	private PageModel<SharkConfig> pageModelConfig;// 分页组件
	private PageModel<PanelInfo> pageModelPanelData;// 分页组件
	private PageModel<PrizeRecord> pageModelPrizeRecord;// 分页组件
	
	private static int timeBet;//观察下注时间
	/** ------------------未重置的变量------------------------- */
	
	private static SharkConfig topConfigList = new SharkConfig();//最新一条配置实体
	
	private static List<TimesEntity> timesEntity;//包含六组倍数的实体
	private static List<PrizeRecord> prizeRecordEntity;//奖项记录实体，一定要先初始化
	private static List<PanelInfo> betEntity;//下注单实体
	
	private static Prize prizeName;//奖项变量，默认正在抽奖
	
	private static double lastDividend;//上场奖项彩金池
	private static double dividend; //彩金池变量
	private static double commission_rate; //佣金费率
	private static double commissionProfit;//佣金收益
	private static Integer timesMax;//最高倍数
	private static Integer timesGoldShark;//金鲨倍数
	private static Integer timesBomb;//炸弹倍数
	private static Integer prizeRecordNum;//统计场数,考虑添加到配置函数
	
	private static boolean againOrNot; //是否重转，默认否
	
	//单场下注和出分情况变量
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
	private static double betForPrize;//单场用于发奖注额
	//各奖项出分
	private static double outSwallowScore;
	private static double outPigeonScore;
	private static double outPeafowlScore;
	private static double outEagleScore;
	private static double outLionScore;
	private static double outPandaScore;
	private static double outMonkeyScore;
	private static double outRabbitScore;
	private static ArrayList<Object> outItemScore = new ArrayList<Object>();//八个奖出分集合
	private static double outSilverScore;
	private static double outGoldScore;
	private static double outBirdScore;//飞禽总出分 ;
	private static double outBeastScore;//走兽总出分 ;
	private static double outBombScore;//炸弹出分	
	
	@Autowired
	protected BetDao betDao;
	@Autowired
	protected SharkConfigDao sharkConfigDao;
	@Autowired
	protected PrizeRecordDao prizeRecordDao;
	

	
	/**
	 *游戏一个运行周期,等同主函数
	 */
	@Override
	public void run() {
		System.out.println("-------------------------------------------");
		process();      //周期循环流程
		System.out.println("---------如果没退出周期，还有18-5-3开始第二周期----------");
		this.cancel();//退出周期调用，结束线程
	}

	private void process() {
		//makeTimes();          //获取倍数,倍数随机生成不统一	
		haveConfig();         //获取配置
		haveLastDividend();   //获取上期彩金池
		//观察、下注 
		timeBet = 5 ;        //观察下注时间
		System.out.println("观察下注时间5");
		try {
	        Thread.sleep(timeBet*1000);//括号里面3000代表3000毫秒也3秒该成需要时间
		} catch (InterruptedException e) {
	        e.printStackTrace();
		}
		System.out.println("结束下注");
		prizeName = havePrize();  //出奖
		System.out.println("本场中奖奖项为:"+prizeName);
		//包括转盘、展示
		System.out.println("开奖时间3");
		try {
	        Thread.sleep(3000);
		} catch (InterruptedException e) {
	        e.printStackTrace();
		}
		makeRecord(); //记录奖项函数
		
		if(againOrNot == true){//如果是则获得再转一次
			turnAgain();
		}
		betClear();//重置清零
	}
	/**
	 * 随机生成一组倍数列表
	 * @return 
	 * @return
	 */
	public TimesEntity makeTimes() {
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
		return timesEntity.get(timesIndex);//返回随机生成的一组倍数
	}
	/**
	 * 获取配置
	 * @return
	 */
	private void haveConfig() {
		System.out.println("获取配置函数haveConfig()");
		/*
		Map<String, String> orderby = new HashMap<String, String>();//定义Map集合
		orderby.put("createTime", "desc");//设置排序条件及方式
		pageModelConfig = sharkConfigDao.find(-1, -1, orderby);//获取所有配置记录
		
		System.out.println("获取配置："+pageModelConfig.getList().get(0).getInitialDividend());
		
		if(pageModelConfig.getList().get(0).getId() != null){//存在配置
		topConfigList = sharkConfigDao.get(pageModelConfig.getList().get(0).getId());//加载对象最新配置序列号
		}*/
		OptionAction optionAction = new OptionAction();//调用OptionAction类里的函数
		topConfigList = optionAction.topConfigList();
		System.out.println("获取配置函数初始彩金池："+topConfigList.getInitialDividend());
		/*
		//添加测试数据
		topConfigList.setBetLimit(999);
		topConfigList.setCircleNum(4);
		topConfigList.setCommissionRate(0.1);
		topConfigList.setId(StringUtil.getStringTime());//18位数字字符串作为配置序列号
		topConfigList.setInitialDividend(1500.0);
		topConfigList.setPrizeRecordNum(3);//奖项查看数目
		topConfigList.setTimeBet(6);
		topConfigList.setTimeCircle(5);
		topConfigList.setTimeCycle(26);
		topConfigList.setTimeDisplay(5);
		topConfigList.setTimeObserve(5);
		topConfigList.setTimeWait(5);
		topConfigList.setTimesMax(99);//最高倍数
		*/
		ArrayList<Object> lastConfigList = new ArrayList<Object>();//列表
		lastConfigList.add(topConfigList.getCommissionRate());//获取最新的费率配置
		lastConfigList.add(topConfigList.getInitialDividend());//获取初始彩金池
		lastConfigList.add(topConfigList.getTimesMax());  //获取最新的最大倍率配置
		lastConfigList.add(topConfigList.getTimeCycle()); //周期
		lastConfigList.add(topConfigList.getBetLimit());  //压筹限制
		lastConfigList.add(topConfigList.getPrizeRecordNum());//查看几条奖项记录
		System.out.println("最新配置列表："+lastConfigList);
		System.out.println("最新一条配置实体："+topConfigList);
		//配置添加到变量中
		commission_rate = topConfigList.getCommissionRate();
		timesMax = topConfigList.getTimesMax();
	}
	/**
	 * 获取上场彩金池
	 * @return
	 */
	private void haveLastDividend() {
		prizeRecordEntity = havePrizeRecord();
		lastDividend = prizeRecordEntity.get(0).getDividend();//获取上场奖项记录的彩金池记录
		System.out.println("查看上场彩金池：" + lastDividend);
	}
	/**
	 * 出奖
	 * @return
	 */
	private Prize havePrize() {
		System.out.println("出奖函数");
		countAndSum();//统计并求总押注和、各单项押注和、各单项出分和
		if(totalBetSum != 0){//有人下注
			System.out.println("下注总额："+totalBetSum);
			dividend = lastDividend + totalBetSum*(1-commission_rate);//筹码注入彩金池
			System.out.println("发奖前彩金："+dividend);
			commissionProfit = totalBetSum*commission_rate;//佣金收益
			System.out.println("佣金收益为："+commissionProfit);			
			if( dividend > (totalBetSum*timesMax) ){//如果已有99倍余额
				return sharkPrize();
			} else if( dividend > (totalBetSum*24) ){//如果已有24倍余额
				return randomPrize();//随机函数
			} else if( dividend > 0){
				return dividendUpPrize();//彩金池增加的吃分函数
			}
		}
		//return attractPrize();//诱惑函数
		return randomPrize();
	}
	/**
	 * 吃分函数
	 * @return
	 */
	private Prize dividendUpPrize() {
		System.out.println("吃分函数：");
		againOrNot = false; //设置为false不重转
		betForPrize = totalBetSum*(1-commission_rate);//单场用于发奖注额
		Vector<Object> less = lessThan(outItemScore,outBirdScore,outBeastScore,betForPrize);//获得能吃分的几个奖项的索引的集合
		if(less.size() > 0 && less != null){//如果存在能吃分的奖项的索引
			System.out.println("存在正常吃分奖项");
			int index=(int)(Math.random()*less.size());//从总共less.size()个能吃分奖中，随机一个能吃分奖的索引的索引，
			if((Integer)less.get(index) == 0){//第index个吃分奖对应的索引
				dividend= dividend -outSwallowScore-outBirdScore;
				return Prize.SWALLOW;
			} else if((Integer)less.get(index) == 1){
				dividend= dividend -outPigeonScore-outBirdScore;
				return Prize.PIGEON;
			} else if((Integer)less.get(index) == 2){
				dividend= dividend -outPeafowlScore-outBirdScore;
				return Prize.PEAFOWL;
			} else if((Integer)less.get(index) == 3){
				dividend= dividend -outEagleScore-outBirdScore;
				return Prize.EAGLE;
			} else if((Integer)less.get(index) == 4){
				dividend= dividend -outLionScore-outBeastScore;
				return Prize.LION;
			} else if((Integer)less.get(index) == 5){
				dividend= dividend -outPandaScore-outBeastScore;
				return Prize.PANDA;
			}  else if((Integer)less.get(index) == 6){
				dividend= dividend -outMonkeyScore-outBeastScore;
				return Prize.MONKEY;
			}  else if((Integer)less.get(index) == 7){
				dividend= dividend -outRabbitScore-outBeastScore;
				return Prize.RABBIT;
			} else{
				System.out.print("不应该出现的error");
			}
		} else {
			System.out.println("需要非正常吃分奖项");
			prizeRecordNum = topConfigList.getPrizeRecordNum();//统计场数,考虑添加到配置函数
			if( ifExistBomb(prizeRecordNum) == true){//如果20场内出现地雷奖项
				int i = outScoreMin(outItemScore,outBirdScore,outBeastScore);//获取符合要求最小出分的奖项的索引
				if(i == 0){//第一个奖对应的索引
					dividend= dividend -outSwallowScore-outBirdScore;
					return Prize.SWALLOW;
				} else if(i == 1){
					dividend= dividend -outPigeonScore-outBirdScore;
					return Prize.PIGEON;
				} else if(i == 2){
					dividend= dividend -outPeafowlScore-outBirdScore;
					return Prize.PEAFOWL;
				} else if(i == 3){
					dividend= dividend -outEagleScore-outBirdScore;
					return Prize.EAGLE;
				} else if(i == 4){
					dividend= dividend -outLionScore-outBeastScore;
					return Prize.LION;
				} else if(i == 5){
					dividend= dividend -outPandaScore-outBeastScore;
					return Prize.PANDA;
				}  else if(i == 6){
					dividend= dividend -outMonkeyScore-outBeastScore;
					return Prize.MONKEY;
				}  else if(i == 7){
					dividend= dividend -outRabbitScore-outBeastScore;
					return Prize.RABBIT;
				} else{
					System.out.print("不应该出现的error");
				}
			} else {
				return prizeBomb();
			}
		}
		return null;
	}
	/**
	 * 炸弹函数
	 * @return
	 */
	private Prize prizeBomb() {
		try{
			if( totalBombSum > 0 ){//如果有人下注炸弹
				dividend= dividend -totalBetSum*(1-commission_rate);
				timesBomb = (int) Math.floor(totalBetSum*(1-commission_rate)/totalBombSum);//求出炸弹倍数
				outBombScore = totalBombSum*timesBomb;
				System.out.printf("炸弹出分：" + outBombScore);
				return Prize.BOMB;
			} else {
				againOrNot = true;   //设置为true再转
				timesBomb = null;//没人押注炸弹，倍数就为空值
				outBombScore = 0 ;   //没人押注炸弹出分为0
				return Prize.BOMB;
			}
		} catch  (Exception ex) {
			System.out.printf("炸弹函数问题。The problem of bomb.");
		}
		return null;
	}
	/**
	 * 获取符合要求最小出分的奖项的索引
	 * @param outItemScore
	 * @param outBirdScore
	 * @param outBeastScore
	 * @return
	 */
	private int outScoreMin(ArrayList<Object> outItemScore,
			double outBirdScore, double outBeastScore) {
		try{
			int x = 0;//预定义集合第一个值为符合要求值,记下索引值
			double min = Double.parseDouble(outItemScore.get(0).toString()) + outBirdScore;//预定义集合第一个值加和为符合要求值
			if (outItemScore.size() > 0){//集合多于两个值时
				for(int i=0 ; i<outItemScore.size() ; i++){
					double temp = Double.parseDouble(outItemScore.get(i).toString());
					if( i < (outItemScore.size()/2) ){//飞禽类
						if ( min > (temp+outBirdScore)){
							min = (temp+outBirdScore);
							x = i;
						}
					} else {//走兽类
						if ( min > (temp+outBeastScore)){
							min = (temp+outBeastScore);
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
	 * 判断num场内是否存在地雷奖项
	 * @param num
	 * @return
	 */
	private boolean ifExistBomb(int num) {
		prizeRecordEntity = havePrizeRecord();//获取奖项记录实体
		if(prizeRecordEntity.size() < num ){
			for(int i=0 ; i < prizeRecordEntity.size() ;i++){//如果奖项记录条数还不到要求数目
				if(prizeRecordEntity.get(i).getPrizeName() == Prize.BOMB){
					return true;//如果遍历的第一个就是地雷，后面就不遍历了
				}
			}
		} else {
			for(int i=0 ; i < num ;i++){
				if(prizeRecordEntity.get(i).getPrizeName() == Prize.BOMB){
					return true;//如果遍历的第一个就是地雷，后面19个就不遍历了
				}
			}
		}
		return false;
	}
	/**
	 * 从集合中获取符合条件的值的索引
	 * @param outItemScore
	 * @param outBirdScore
	 * @param outBeastScore
	 * @param betForPrize
	 * @return
	 */
	private static Vector<Object> lessThan(ArrayList<Object> outItemScore,
			double outBirdScore, double outBeastScore, double betForPrize) {
		Vector<Object> v = new Vector<Object>(outItemScore.size());
		for(int i=0 ; i<outItemScore.size() ; i++){
			if( i < (outItemScore.size()/2) ){//飞禽类
				if ((Double)outItemScore.get(i) < (betForPrize - outBirdScore)){
					v.add(i);
				}
			} else {//走兽类
				if ((Double)outItemScore.get(i) < (betForPrize - outBeastScore)){
					v.add(i);
				}
			}
		}
		return v;
	}
	/**
	 * 随机函数
	 * @return
	 */
	private Prize randomPrize() {
		System.out.print("随机函数：");
		againOrNot = false; //设置为false不重转
		int whatPrize =(int)(Math.floor(randomNum.nextInt(8)));//随机获取大于等于0到小于8的整数部分,即随机获取0/1/2/3/4/5/6/7
		if(whatPrize == 0){//为燕子概率1/8
			dividend = dividend - outSwallowScore - outBirdScore;
			return Prize.SWALLOW;
		} else if(whatPrize == 1){//鸽子
			dividend = dividend - outPigeonScore - outBirdScore;
			return Prize.PIGEON;
		} else if(whatPrize == 2){//奖项孔雀
			dividend = dividend - outPeafowlScore - outBirdScore;
			return Prize.PEAFOWL;
		} else if(whatPrize == 3){//奖项老鹰
			dividend = dividend - outEagleScore - outBirdScore;
			return Prize.EAGLE;			
		} else if(whatPrize == 4){//奖项狮子
			dividend = dividend - outLionScore - outBeastScore; 
			return Prize.LION;
		} else if(whatPrize == 5){//奖项熊猫
			dividend = dividend - outPandaScore - outBeastScore; 
			return Prize.PANDA;
		} else if(whatPrize == 6){//奖项猴子
			dividend = dividend - outMonkeyScore - outBeastScore;
			return Prize.MONKEY;
		} else if(whatPrize == 7){//奖项兔子
			dividend = dividend - outRabbitScore - outBeastScore;
			return Prize.RABBIT;
		} else {
			System.out.print("不应该出现的error");
		}
		return null;
	}
	/**
	 * 鲨鱼函数
	 * @return
	 */
	private Prize sharkPrize() {
		againOrNot = true; //设置为true，用于再转一次
		int silverOrGold = (int) Math.floor(randomNum.nextInt(2));//随机获取大于等于0到小于2的整数部分,即随机获取0或1
		if(silverOrGold == 0){//为银鲨概率1/2
			outSilverScore = totalSilverSum*24;//银鲨总出分
			dividend = dividend - outSilverScore; //发了银鲨奖的彩金池
			return Prize.SILVER_SHARK;//出奖银鲨+再转一次
		} else if(silverOrGold == 1){//为金鲨概率1/2
			timesGoldShark =(int)(Math.floor(randomNum.nextInt(timesMax-23))+24);//随机获取大于等于24到小于100的整数，即最高99倍
			outGoldScore = totalGoldSum*timesGoldShark;//金鲨总出分
			dividend = dividend - outGoldScore; //发了金鲨奖的彩金池
			System.out.println("金鲨倍数："+timesGoldShark);
			return Prize.GOLD_SHARK;//出奖金鲨+再转一次
		} else {
			System.out.print("不应该出现的error");
		}
		return null;
	}

	/**
	 * 统计并求总押注和、各单项押注和、各单项出分和
	 * @return  押注总额之和 totalBetSum
	 */
	private void countAndSum() {
		System.out.println("统计并求总押注和、各单项押注和、各单项出分和");
		betEntity = haveBet();//获取下注单
		if(betEntity != null && betEntity.size() >0){
			for(PanelInfo panelInfo : betEntity){//遍历所有的下注条目
				System.out.println("遍历下单实体");
				boolean betCount = panelInfo.getBetCount();//获得条目统计状态
				if(betCount == false){//如果条目未操作过
					totalSwallowSum += panelInfo.getSwallow();
					totalPigeonSum += panelInfo.getPigeon();
					totalPeafowlSum += panelInfo.getPeafowl();
					totalEagleSum += panelInfo.getEagle();
					totalLionSum += panelInfo.getLion();
					totalPandaSum += panelInfo.getPanda();
					totalMonkeySum += panelInfo.getMonkey();
					totalRabbitSum += panelInfo.getRabbit();
					totalBirdSum += panelInfo.getBird();
					totalSilverSum += panelInfo.getSilver_shark();
					totalBombSum += panelInfo.getBomb();
					totalGoldSum += panelInfo.getGold_shark();
					totalBeastSum += panelInfo.getBeast();
					totalBetSum += panelInfo.getTotalBet();//单场总下注
					//各项出分
					outSwallowScore += panelInfo.getSwallow()*panelInfo.getTimesSwallow();
					outPigeonScore += panelInfo.getPigeon()*panelInfo.getTimesPigeon();
					outPeafowlScore += panelInfo.getPeafowl()*panelInfo.getTimesPeafowl();
					outEagleScore += panelInfo.getEagle()*panelInfo.getTimesEagle();
					outLionScore += panelInfo.getLion()*panelInfo.getTimesLion();
					outPandaScore += panelInfo.getPanda()*panelInfo.getTimesPanda();
					outMonkeyScore += panelInfo.getMonkey()*panelInfo.getTimesMonkey();
					outRabbitScore += panelInfo.getRabbit()*panelInfo.getTimesRabbit();
					//panelData = betDao.load(panelInfo.getPanelBetId());//装载下单对象
					//panelData.setBetCount(true);// 更改筹码统计状态
					//betDao.update(panelData);//更新修改操作状态
				}				
			}
			ArrayList<Object> totalItemSum = new ArrayList<Object>();//查看单场各项押注
			totalItemSum.add(totalSwallowSum);//注意顺序不能弄乱
			totalItemSum.add(totalPigeonSum);
			totalItemSum.add(totalPeafowlSum);
			totalItemSum.add(totalEagleSum);
			totalItemSum.add(totalLionSum);
			totalItemSum.add(totalPandaSum);
			totalItemSum.add(totalMonkeySum);
			totalItemSum.add(totalRabbitSum);
			totalItemSum.add(totalBirdSum);
			totalItemSum.add(totalSilverSum);
			totalItemSum.add(totalBombSum);
			totalItemSum.add(totalGoldSum);
			totalItemSum.add(totalBeastSum);
			totalItemSum.add(totalBetSum);
			System.out.println("查看单场各项押注："+totalItemSum);
			outItemScore = new ArrayList<Object>();//八个奖出分集合	
			outItemScore.add(outSwallowScore);//注意顺序不能弄乱
			outItemScore.add(outPigeonScore);
			outItemScore.add(outPeafowlScore);
			outItemScore.add(outEagleScore);
			outItemScore.add(outLionScore);
			outItemScore.add(outPandaScore);
			outItemScore.add(outMonkeyScore);
			outItemScore.add(outRabbitScore);
			System.out.println("查看八个奖出分集合outItemScore值："+outItemScore);
			outBirdScore = totalBirdSum*2;//飞禽总出分 ;
			outBeastScore = totalBeastSum*2;//走兽总出分 ;
		} else {
			System.out.println("无人下注");
		}		
	}

	/**
	 * 保存记录奖项情况到表中
	 */
	private void makeRecord() {
		System.out.println("记录奖项PrizeRecord");
		try{
			prizeRecord.setPrizeId(StringUtil.getStringTime());//添加18位数字字符串与其他配置属性一起加到数据库中
			prizeRecord.setCommissionRate(commission_rate);
			prizeRecord.setPrizeName(prizeName);//放入开出的奖
			prizeRecord.setDividend(dividend);
			prizeRecord.setTimesGoldShark(timesGoldShark);
			prizeRecord.setTimesBomb(timesBomb);
			prizeRecord.setTotalSwallowSum(totalSwallowSum);
			prizeRecord.setTotalPigeonSum(totalPigeonSum);
			prizeRecord.setTotalPeafowlSum(totalPeafowlSum);
			prizeRecord.setTotalEagleSum(totalEagleSum);
			prizeRecord.setTotalLionSum(totalLionSum);
			prizeRecord.setTotalPandaSum(totalPandaSum);
			prizeRecord.setTotalMonkeySum(totalMonkeySum);
			prizeRecord.setTotalRabbitSum(totalRabbitSum);
			prizeRecord.setTotalBirdSum(totalBirdSum);
			prizeRecord.setTotalSilverSum(totalSilverSum);
			prizeRecord.setTotalBombSum(totalBombSum);
			prizeRecord.setTotalGoldSum(totalGoldSum);
			prizeRecord.setTotalBeastSum(totalBeastSum);
			prizeRecord.setTotalBetSum(totalBetSum);
			prizeRecord.setOutSwallowScore(outSwallowScore);
			prizeRecord.setOutPigeonScore(outPigeonScore);
			prizeRecord.setOutPeafowlScore(outPeafowlScore);
			prizeRecord.setOutEagleScore(outEagleScore);
			prizeRecord.setOutLionScore(outLionScore);
			prizeRecord.setOutPandaScore(outPandaScore);
			prizeRecord.setOutMonkeyScore(outMonkeyScore);
			prizeRecord.setOutRabbitScore(outRabbitScore);
			prizeRecord.setOutSilverScore(outSilverScore);
			prizeRecord.setOutGoldScore(outGoldScore);
			prizeRecord.setOutBirdScore(outBirdScore);
			prizeRecord.setOutBeastScore(outBeastScore);
			prizeRecord.setOutBombScore(outBombScore);
			System.out.print("记录奖项情况");
			prizeRecordDao.save(prizeRecord);//保存奖项记录对象
		} catch(Exception ex){
			System.out.println("记录奖项时出现问题");
		}
	}
	
	private void turnAgain() {
		System.out.println("再转函数");
		againOrNot = false;//再转之后不再转
	}
	/**
	 * 重置清零
	 */
	private void betClear(){
		System.out.println("重置清零函数");	
		//游戏倍数
		timesGoldShark = null;//金鲨倍数
		timesBomb = null;//炸弹倍数
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
		betForPrize = 0.0;
		//各奖项出分
		outSwallowScore = 0.0;
		outPigeonScore = 0.0;
		outPeafowlScore = 0.0;
		outEagleScore = 0.0;
		outLionScore = 0.0;
		outPandaScore = 0.0;
		outMonkeyScore = 0.0;
		outRabbitScore = 0.0;
		outItemScore = null;//八个奖出分集合
		outSilverScore = 0.0;
		outGoldScore = 0.0;
		outBirdScore = 0.0;//飞禽总出分 ;
		outBeastScore = 0.0;//走兽总出分 ;
		outBombScore = 0.0;//炸弹出分
		//游戏配置
		prizeRecordNum = 5;//统计场数,考虑添加到配置函数
		commission_rate =0.0; //佣金费率
		timesMax = 0;//最高倍数
		commissionProfit = 0.0;//佣金收益
		lastDividend = 0.0;
		dividend = 0.0; //彩金池变量需要储存在数据库中
		againOrNot = false; //是否重转，默认否	
		// 实体变量
		timesEntity = null;
		prizeRecordEntity = null;
		betEntity = null;
		//自定义类型变量
		prizeName = Prize.RAFFLING;//奖项变量，默认正在抽奖
	}
	private List<PanelInfo> haveBet() {
		System.out.println("获取下注单函数");
		/*
		Map<String, String> orderby = new HashMap<String, String>(1);//定义Map集合
		orderby.put("createTime", "desc");//设置按创建时间倒序排列
		String where = "where betCount = ?";//设置查询条件语句
		Object[] queryParams = {false};//获取未操作过的参数值
		pageModelPanelData = betDao.find(where, queryParams, orderby, -1, -1);//执行查询方法
		betEntity = pageModelPanelData.getList();
		*/
		betEntity = new ArrayList<PanelInfo>();//下注单实体,一定要先初始化
		PanelInfo betItem1 = new PanelInfo();
		betItem1.setPanelBetId(StringUtil.createOrderId());// 设置21位的订单号
		betItem1.setSwallow(1);
		betItem1.setPigeon(1);
		betItem1.setPeafowl(1);
		betItem1.setEagle(1);
		betItem1.setLion(1);
		betItem1.setPanda(1);
		betItem1.setMonkey(1);
		betItem1.setRabbit(1);
		betItem1.setBird(1);
		betItem1.setSilver_shark(1);
		betItem1.setBomb(1);
		betItem1.setGold_shark(1);
		betItem1.setBeast(1);
		betItem1.setTotalBet(13);
		betItem1.setPrizeItem(Prize.RAFFLING);
		betItem1.setBetCount(false);
		betItem1.setTimesSwallow(6);
		betItem1.setTimesPigeon(6);
		betItem1.setTimesPeafowl(8);
		betItem1.setTimesEagle(24);
		betItem1.setTimesLion(24);
		betItem1.setTimesPanda(8);
		betItem1.setTimesMonkey(6);
		betItem1.setTimesRabbit(6);
		betEntity.add(betItem1);
		/*
		PanelInfo betItem2 = new PanelInfo();
		betItem2.setBeast(2);
		betItem2.setBetCount(true);
		betItem2.setBird(2);
		betItem2.setPanelBetId(StringUtil.createOrderId());// 设置21位的订单号
		betEntity.add(betItem2);
		PanelInfo betItem3 = new PanelInfo();
		betItem3.setBeast(3);
		betItem3.setBetCount(false);
		betItem3.setBird(3);
		betItem3.setPanelBetId(StringUtil.createOrderId());// 设置21位的订单号
		betEntity.add(betItem3);
		*/
		return betEntity;
	}
	/**
	 * 获取奖项记录
	 * @return
	 */
	private List<PrizeRecord> havePrizeRecord() {
		System.out.println("获取奖项记录函数");
		/* 
		Map<String, String> orderby = new HashMap<String, String>(1);//定义Map集合
		orderby.put("createTime", "desc");//设置按创建时间倒序排列
		pageModelPrizeRecord = prizeRecordDao.find(-1, -1, orderby);//执行查询方法
		prizeRecordEntity = pageModelPrizeRecord.getList();
		*/
		prizeRecordEntity = new ArrayList<PrizeRecord>();//奖项记录实体，一定要先初始一定要先初始化化
		PrizeRecord prize1 = new PrizeRecord();
		prize1.setPrizeId(StringUtil.getStringTime());//18位数字字符串作为奖项序号
		prize1.setCommissionRate(0.10);
		prize1.setCreateTime(null);
		prize1.setPrizeName(Prize.RAFFLING);
		prize1.setDividend(1050.0);
		prizeRecordEntity.add(prize1);
		PrizeRecord prize2 = new PrizeRecord();
		prize2.setDividend(320.0);
		prize2.setPrizeName(Prize.SWALLOW);
		prizeRecordEntity.add(prize2);
		PrizeRecord prize3 = new PrizeRecord();
		prize3.setPrizeName(Prize.RABBIT);
		prizeRecordEntity.add(prize3);
		PrizeRecord prize4 = new PrizeRecord();
		prize4.setPrizeName(Prize.PEAFOWL);
		prizeRecordEntity.add(prize4);
		PrizeRecord prize5 = new PrizeRecord();
		prize5.setPrizeName(Prize.EAGLE);
		prizeRecordEntity.add(prize5);
		PrizeRecord prize6 = new PrizeRecord();
		prize6.setPrizeName(Prize.PANDA);
		prizeRecordEntity.add(prize6);
		
		return prizeRecordEntity;
	}
	//getter和setter方法，放入request中，好在jsp页面中能拿到	
	public PageModel<SharkConfig> getPageModelConfig() {
		return pageModelConfig;
	}

	public void setPageModelConfig(PageModel<SharkConfig> pageModelConfig) {
		this.pageModelConfig = pageModelConfig;
	}
	
	public PageModel<PanelInfo> getPageModelPanelData() {
		return pageModelPanelData;
	}

	public void setPageModelPanelData(PageModel<PanelInfo> pageModelPanelData) {
		this.pageModelPanelData = pageModelPanelData;
	}

	public PageModel<PrizeRecord> getPageModelPrizeRecord() {
		return pageModelPrizeRecord;
	}

	public void setPageModelPrizeRecord(PageModel<PrizeRecord> pageModelPrizeRecord) {
		this.pageModelPrizeRecord = pageModelPrizeRecord;
	}
}
