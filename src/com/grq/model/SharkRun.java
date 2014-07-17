package com.grq.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;

import com.grq.model.customizeenum.Prize;
import com.grq.model.dao.shark.BetDao;
import com.grq.model.dao.shark.SharkConfigDao;
import com.grq.model.pojo.shark.PanelInfo;
import com.grq.model.pojo.shark.PrizeRecord;
import com.grq.model.pojo.shark.SharkConfig;
import com.grq.model.pojo.shark.TimesEntity;

public class SharkRun extends TimerTask {
	private PanelInfo panelData = new PanelInfo();//一定要先初始化obj对象！
	
	private static List<TimesEntity> timesEntity;//包含六组倍数的实体
	private static List<PrizeRecord> prizeRecordEntity;//奖项记录实体
	private static List<PanelInfo> betEntity;//下注单实体
	
	private static SharkConfig topConfigList;
	private static Prize prizeName;//奖项变量，默认正在抽奖
	
	private static double lastDividend;//上场奖项彩金池
	private static double dividend; //彩金池变量
	private static double commission_rate; //佣金费率
	private static double commissionProfit;//佣金收益
	private static int timesMax;//最高倍数
	private static int timesGoldShark;//金鲨倍数
	private static int whatPrize;//什么奖
	
	private static Random randomNum = new Random();//用于获取随机数
	private static boolean againOrNot; //是否重转，默认否
	
	private static int timeBet;//观察下注时间	
	
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
	//各奖项出分
	private static double outSwallowScore;
	private static double outPigeonScore;
	private static double outPeafowlScore;
	private static double outEagleScore;
	private static double outLionScore;
	private static double outPandaScore;
	private static double outMonkeyScore;
	private static double outRabbitScore;
	private static double outSilverScore;
	private static double outGoldScore;
	
	@Autowired
	protected BetDao betDao;
	@Autowired
	protected SharkConfigDao sharkConfigDao;
	
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
		makeTimes();          //获取倍数,倍数随机生成不统一		
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
		betClear();   //重置清零		
	}
	/**
	 * 随机生成一组倍数列表
	 * @return
	 */
	private void makeTimes() {
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
	}
	/**
	 * 获取配置
	 * @return
	 */
	private void haveConfig() {
		System.out.println("获取配置函数");
		Map<String, String> orderby = new HashMap<String, String>();//定义Map集合
		orderby.put("createTime", "desc");//设置排序条件及方式
		PageModel<SharkConfig> configList = sharkConfigDao.find(-1, -1, orderby);//获取最近一条数据
		if(configList.getList().get(0).getId() != null){//存在配置
			topConfigList = sharkConfigDao.get(configList.getList().get(0).getId());//加载对象最新配置序列号
		}		
		ArrayList<Object> lastConfigList = new ArrayList<Object>();//列表
		lastConfigList.add(topConfigList.getCommissionRate());//获取最新的费率配置
		lastConfigList.add(topConfigList.getInitialDividend());//获取初始彩金池
		lastConfigList.add(topConfigList.getTimesMax());  //获取最新的最大倍率配置
		lastConfigList.add(topConfigList.getTimeCycle()); //周期
		lastConfigList.add(topConfigList.getBetLimit());
		lastConfigList.add(topConfigList.getTimeCircle());//转圈时间,延迟时间
		System.out.println("最新配置列表："+lastConfigList);
		System.out.println("最新配置列表："+topConfigList);
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
		if(totalBetSum != 0){
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
			} else {
				//return attractPrize();//诱惑函数
				return randomPrize();//随机函数
			}
		}
		return randomPrize();
	}
	
	private Prize dividendUpPrize() {
		return null;
	}
	/**
	 * 随机函数
	 * @return
	 */
	private Prize randomPrize() {
		System.out.print("随机函数：");
		againOrNot = false; //设置为false不重转
		whatPrize =(int)(Math.floor(randomNum.nextInt(8)));//随机获取大于等于0到小于8的整数部分,即随机获取0/1/2/3/4/5/6/7
		if(whatPrize == 0){//为燕子概率1/8
			dividend = dividend - outSwallowScore; //发了奖燕子后的彩金池
			return Prize.SWALLOW;
		} else if(whatPrize == 1){//鸽子
			dividend = dividend - outPigeonScore; //发了第二个奖鸽子后的彩金池
			return Prize.PIGEON;
		} else if(whatPrize == 2){//奖项孔雀
			dividend = dividend - outPeafowlScore; //发了第二个奖鸽子后的彩金池
			return Prize.PEAFOWL;
		} else if(whatPrize == 3){//奖项老鹰
			dividend = dividend - outEagleScore; //发了第二个奖鸽子后的彩金池
			return Prize.EAGLE;			
		} else if(whatPrize == 4){//奖项狮子
			dividend = dividend - outLionScore; //发了第二个奖兔子后的彩金池
			return Prize.RABBIT;
		} else if(whatPrize == 5){//奖项熊猫
			dividend = dividend - outPandaScore; //发了第二个奖猴子后的彩金池
			return Prize.MONKEY;
		} else if(whatPrize == 6){//奖项猴子
			dividend = dividend - outMonkeyScore; //发了第二个奖熊猫后的彩金池
			return Prize.PANDA;
		} else if(whatPrize == 7){//奖项兔子
			dividend = dividend - outRabbitScore; //发了第二个奖狮子后的彩金池
			return Prize.LION;
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
		Map<String, String> orderby = new HashMap<String, String>(1);//定义Map集合
		orderby.put("createTime", "desc");//设置按创建时间倒序排列
		String where = "where betCount = ?";//设置查询条件语句
		Object[] queryParams = {false};//获取未操作过的参数值
		PageModel<PanelInfo> panelData = betDao.find(where, queryParams, orderby, -1, -1);//执行查询方法
		betEntity = panelData.getList();//获取所有未操作过的下注条目
		if(betEntity != null && betEntity.size() >0){
			for(PanelInfo panelInfo : betEntity){//遍历所有的下注条目
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
				}				
			}
			ArrayList<Object> totalPrizeSum = new ArrayList<Object>();//八个奖出分集合	
			totalPrizeSum.add(totalSwallowSum);//注意顺序不能弄乱
			totalPrizeSum.add(totalPigeonSum);
			totalPrizeSum.add(totalPeafowlSum);
			totalPrizeSum.add(totalEagleSum);
			totalPrizeSum.add(totalLionSum);
			totalPrizeSum.add(totalPandaSum);
			totalPrizeSum.add(totalMonkeySum);
			totalPrizeSum.add(totalRabbitSum);
			totalPrizeSum.add(totalBirdSum);
			totalPrizeSum.add(totalSilverSum);
			totalPrizeSum.add(totalBombSum);
			totalPrizeSum.add(totalGoldSum);
			totalPrizeSum.add(totalBeastSum);
			totalPrizeSum.add(totalBetSum);
			System.out.println("查看单场各项押注："+totalPrizeSum);
			ArrayList<Object> outPrizeScore = new ArrayList<Object>();//八个奖出分集合	
			outPrizeScore.add(outSwallowScore);//注意顺序不能弄乱
			outPrizeScore.add(outPigeonScore);
			outPrizeScore.add(outPeafowlScore);
			outPrizeScore.add(outEagleScore);
			outPrizeScore.add(outLionScore);
			outPrizeScore.add(outPandaScore);
			outPrizeScore.add(outMonkeyScore);
			outPrizeScore.add(outRabbitScore);
			System.out.println("查看八个奖出分集合outPrizeScore值："+outPrizeScore);
		} else {
			System.out.println("无人下注");
		}		
	}
	
	private void makeRecord() {
		System.out.println("记录奖项函数");		
	}
	
	private void betClear() {
		System.out.println("重置清零函数");		
	}

	/**
	 * 获取奖项记录
	 * @return
	 */
	private List<PrizeRecord> havePrizeRecord() {
		//添加数据测试
		prizeRecordEntity=new ArrayList<PrizeRecord>();		
		PrizeRecord prize1 = new PrizeRecord();
		prize1.setPrizeId("2014");
		prize1.setCommissionRate(0.10);
		prize1.setCreateTime(null);
		prize1.setPrizeName(Prize.RAFFLING);
		prize1.setDividend(310.0);
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
}
