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
import com.grq.model.util.StringUtil;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("sharkAction")
public class SharkAction extends BaseAction implements ModelDriven<PanelInfo>{
	private static final long serialVersionUID = 1L;
	
	/* 游戏配置后期单独做一块 */
	//游戏倍数
	int timesSwallow = 6;
	int timesPigeon = 6;
	int timesPeafowl = 8;
	int timesEagle = 24;
	int timesLion = 24;
	int timesPanda = 8;
	int timesMonkey = 6;
	int timesRabbit = 6;
	int timesMax = 99;//最高倍数
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
	double dividend = 300.00; //彩金池变量
	double commission_rate = 0.10; //佣金费率
	double single_bet = 1000.00; //单注上限
	int bet_limit = 999; //押注上限
	
	
	// 键盘panel对象
	private PanelInfo panelData = new PanelInfo();//一定要先初始化obj对象！
	
	private PageModel<PanelInfo> pageModel;// 分页组件
	private Random randomNum = new Random();//用于获取随机数
	private float totalPriceSum = 0f; //统计下注总额之和的变量
	private float totalSwallowSum = 0f; //统计燕子下注总额之和
	private float totalPigeonSum = 0f;
	private float totalPeafowlSum = 0f;
	private float totalEagleSum = 0f;
	private float totalLionSum = 0f;
	private float totalPandaSum = 0f;
	private float totalMonkeySum = 0f;
	private float totalRabbitSum = 0f;
	private float totalBirdSum = 0f;//统计飞禽下注总额之和
	private float totalSilverSum = 0f;
	private float totalBombSum = 0f;
	private float totalGoldSum = 0f;
	private float totalBeastSum = 0f;//统计走兽下注总额之和
	private boolean againOrNot = false; //是否重转，默认否
	private Prize prizeString = Prize.RAFFLING;//奖项变量，默认正在抽奖
	


	
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
	/**
	 * 出奖
	 * @return
	 */
	private Prize havePrize(){
		//StringBuffer prize = new StringBuffer();//定义字符串对象
		float totalPriceSum = countTotalPrice();//获得下注总额之和
		dividend = dividend + totalPriceSum*(1-commission_rate);//筹码注入彩金池
		if( dividend > (totalPriceSum*timesMax) ){//如果已有99倍余额
			return sharkPrize();//鲨鱼函数,根据返回值确定是金鲨还是银鲨，等同setPrizeString(sharkPrize());
		} else if( dividend > (totalPriceSum*24) ){//如果已有24倍余额
			return randomPrize();//随机函数
		} else if( dividend > 0){
			return dividendUpPrize();//彩金池增加的吃分函数
		} else {
			//setPrizeString(attractPrize());//诱惑函数
			return randomPrize();//随机函数
		}
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
	private Prize sharkPrize() {
		againOrNot = true;//设置为true，用于再转一次,等同于setAgainOrNot(true); 
		double a = Math.floor(randomNum.nextInt(2));//随机获取大于等于0到小于2的整数部分,即随机获取0或1
		int silverOrGold = (int)a;//将double数据类型转换成int
		if(silverOrGold == 0){//为银鲨概率1/2
			float silverOutScore = getTotalSilverSum()*24;//银鲨总出分
			dividend = dividend - silverOutScore; //发了银鲨奖的彩金池
			//记得更新到数据库
			return Prize.SILVER_SHARK;//出奖银鲨+再转一次
		} else if(silverOrGold == 1){//为金鲨概率1/2
			int goldSharkTimes =(int)(Math.floor(randomNum.nextInt(75))+25);//随机获取大于等于25到小于100的整数
			float goldOutScore = getTotalGoldSum()*goldSharkTimes;//金鲨总出分
			dividend = dividend - goldOutScore; //发了金鲨奖的彩金池
			//记得更新到数据库
			return Prize.GOLD_SHARK;//出奖金鲨+再转一次
		} else {
			System.out.print("不应该出现的error");
		}
		return null;
	}
	/** 
	 * 随机函数
	 */
	private Prize randomPrize() {
		setAgainOrNot(false); //设置为false不重转
		int birdOrBeast =(int)(Math.floor(randomNum.nextInt(2)));//随机获取大于等于0到小于2的整数部分,即随机获取0或1
		if(birdOrBeast == 0){//为飞禽概率1/2
			float birdOutScore = getTotalBirdSum()*2;//飞禽总出分
			dividend = dividend - birdOutScore; //发了飞禽奖的彩金池
			int birdWhat =(int)(Math.floor(randomNum.nextInt(4)));//随机获取大于等于0到小于4的整数部分,即随机获取0或1或2或3，概率都为1/4。
			if(birdWhat == 0){//奖项燕子
				float swallowOutScore = getTotalSwallowSum()*6;//燕子总出分，倍数暂时固定
				dividend = dividend - swallowOutScore; //发了第二个奖燕子后的彩金池
				return Prize.SWALLOW;
			} else if(birdWhat == 1){//奖项鸽子
				float pigeonOutScore = getTotalPigeonSum()*6;//鸽子总出分，倍数暂时固定
				dividend = dividend - pigeonOutScore; //发了第二个奖鸽子后的彩金池
				return Prize.PIGEON;
			} else if(birdWhat == 2){//奖项孔雀
				float peafowlOutScore = getTotalPeafowlSum()*8;//鸽子总出分，倍数暂时固定
				dividend = dividend - peafowlOutScore; //发了第二个奖鸽子后的彩金池
				return Prize.PEAFOWL;
			} else if(birdWhat == 3){//奖项老鹰
				float eagleOutScore = getTotalEagleSum()*24;//鸽子总出分，倍数暂时固定
				dividend = dividend - eagleOutScore; //发了第二个奖鸽子后的彩金池
				return Prize.EAGLE;
			} else {
				System.out.print("不应该出现的error");
			}
			//记得更新到数据库
		} else if(birdOrBeast == 1){//为走兽概率1/2
			float beastOutScore = getTotalBeastSum()*2;//走兽总出分
			dividend = dividend - beastOutScore; //发了走兽奖的彩金池
			int beastWhat =(int)(Math.floor(randomNum.nextInt(4)));//随机获取大于等于0到小于4的整数部分,即随机获取0或1或2或3，概率都为1/4。
			if(beastWhat == 0){//奖项兔子
				float rabbitOutScore = getTotalRabbitSum()*6;//兔子总出分，倍数暂时固定
				dividend = dividend - rabbitOutScore; //发了第二个奖兔子后的彩金池
				return Prize.RABBIT;
			} else if(beastWhat == 1){//奖项猴子
				float monkeyOutScore = getTotalMonkeySum()*6;//猴子总出分，倍数暂时固定
				dividend = dividend - monkeyOutScore; //发了第二个奖猴子后的彩金池
				return Prize.MONKEY;
			} else if(beastWhat == 2){//奖项熊猫
				float pandaOutScore = getTotalPandaSum()*8;//熊猫总出分，倍数暂时固定
				dividend = dividend - pandaOutScore; //发了第二个奖熊猫后的彩金池
				return Prize.PANDA;
			} else if(beastWhat == 3){//奖项狮子
				float lionOutScore = getTotalLionSum()*24;//狮子总出分，倍数暂时固定
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
	 * 彩金池增加的吃分函数
	 */
	private Prize dividendUpPrize() {
		setAgainOrNot(false); //设置为false不重转
		float priceForPrize = (float) (totalPriceSum*(1-commission_rate));//单场用于发奖注额
		float swallowOutScore = (float) (totalSwallowSum*timesSwallow);
		float pigeonOutScore = (float) (totalPigeonSum*timesPigeon);
		float peafowlOutScore = (float) (totalPeafowlSum*timesPeafowl);
		float eagleOutScore = (float) (totalEagleSum*timesEagle);
		float lionOutScore = (float) (totalLionSum*timesLion);
		float pandaOutScore = (float) (totalPandaSum*timesPanda);
		float monkeyOutScore = (float) (totalMonkeySum*timesMonkey);
		float rabbitOutScore = (float) (totalRabbitSum*timesRabbit);		
		ArrayList<Object> totalSum = new ArrayList<Object>();		
		totalSum.add(swallowOutScore);//注意顺序不能弄乱
		totalSum.add(pigeonOutScore);
		totalSum.add(peafowlOutScore);
		totalSum.add(eagleOutScore);
		totalSum.add(lionOutScore);
		totalSum.add(pandaOutScore);
		totalSum.add(monkeyOutScore);
		totalSum.add(rabbitOutScore);
		float birdOutScore = getTotalBirdSum()*2;//飞禽总出分 ;
		float beastOutScore = getTotalBeastSum()*2;//走兽总出分 ;
		Vector<Object> less = lessThan(totalSum,birdOutScore,beastOutScore,priceForPrize);//获得能吃分的几个奖项的索引的集合
		if(less.size() > 0 && less != null){//如果存在能吃分的奖项的索引
			int index=(int)(Math.random()*less.size());//从总共less.size()个能吃分奖中，随机一个能吃分奖的索引的索引，
			if((Integer)less.get(index) == 0){//第index个吃分奖对应的索引
				System.out.println("燕子发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.SWALLOW;
			} else if((Integer)less.get(index) == 1){
				System.out.println("鸽子发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.PIGEON;
			} else if((Integer)less.get(index) == 2){
				System.out.println("孔雀发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.PEAFOWL;
			} else if((Integer)less.get(index) == 3){
				System.out.println("老鹰发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.EAGLE;
			} else if((Integer)less.get(index) == 4){
				System.out.println("狮子发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.LION; 
			} else if((Integer)less.get(index) == 5){
				System.out.println("熊猫发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.PANDA;
			}  else if((Integer)less.get(index) == 6){
				System.out.println("猴子发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.MONKEY;
			}  else if((Integer)less.get(index) == 7){
				System.out.println("兔子发奖："+totalSum.get((Integer) less.get(index)));
				return Prize.RABBIT;
			} else{
				System.out.print("不应该出现的error");
			}
		} else {
			int bombNum = 15;
			if(bombNum < 20){//判断20场内是否出现地雷奖项，这里要再写
				int index = outScoreMin(totalSum,birdOutScore,beastOutScore);//获取符合要求的值的索引
				if(index == 0){//第一个奖对应的索引
					System.out.println("燕子发奖："+totalSum.get((Integer) less.get(index)));
					return Prize.SWALLOW;
				} else if(index == 1){
					System.out.println("鸽子发奖："+totalSum.get((Integer) less.get(index)));
					return Prize.PIGEON;
				} else if(index == 2){
					System.out.println("孔雀发奖："+totalSum.get((Integer) less.get(index)));
					return Prize.PEAFOWL;
				} else if(index == 3){
					System.out.println("老鹰发奖："+totalSum.get((Integer) less.get(index)));
					return Prize.EAGLE;
				} else if(index == 4){
					System.out.println("狮子发奖："+totalSum.get((Integer) less.get(index)));
					return Prize.LION; 
				} else if(index == 5){
					System.out.println("熊猫发奖："+totalSum.get((Integer) less.get(index)));
					return Prize.PANDA;
				}  else if(index == 6){
					System.out.println("猴子发奖："+totalSum.get((Integer) less.get(index)));
					return Prize.MONKEY;
				}  else if(index == 7){
					System.out.println("兔子发奖："+totalSum.get((Integer) less.get(index)));
					return Prize.RABBIT;
				} else{
					System.out.print("不应该出现的error");
				}
			} else {
				bombPrize();
			}
			
		}
		return null;
	}
	/**
	 * 得到符合要求的和值最小的奖的索引
	 * @param totalSum
	 * @param birdOutScore
	 * @param beastOutScore
	 * @return 
	 */
	private int outScoreMin(ArrayList<Object> totalSum, float birdOutScore,float beastOutScore) {
		try{
			int index = 0;//预定义集合第一个值为符合要求值,记下索引值
			double min = Float.parseFloat(totalSum.get(0).toString()) + birdOutScore;//预定义集合第一个值加和为符合要求值
			if (totalSum.size() > 0){//集合多于两个值时
				for(int i=0 ; i<totalSum.size() ; i++){
					double temp = Float.parseFloat(totalSum.get(i).toString());
					if( i < (totalSum.size()/2) ){//飞禽类
						if ( min > (temp+birdOutScore)){
							min = (temp+birdOutScore);
							index = i;
						}
					} else {//走兽类
						if ( min > (temp+beastOutScore)){
							min = (temp+beastOutScore);
							index = i;
						}
					}

				}
				return index;//返回符合要求的和最小的奖的索引
			}
			
		}catch (Exception ex) {
			System.out.printf("通用计算公式", "计算符合要求的值的索引:" + ex.getMessage());
        }
		return (Integer) null;
	}
	/**
	 * 获得能吃分的几个奖项的索引
	 * @param totalSum
	 * @param birdOutScore
	 * @param beastOutScore
	 * @param priceForPrize
	 * @return 奖项的索引
	 */
	private Vector<Object> lessThan(ArrayList<Object> totalSum,
			float birdOutScore, float beastOutScore, float priceForPrize) {
		Vector<Object> v = new Vector<Object>(totalSum.size());
		for(int i=0 ; i<totalSum.size() ; i++){
			if( i < (totalSum.size()/2) ){//飞禽类
				if ((Float)totalSum.get(i) < (priceForPrize - birdOutScore)){
					v.add(i);
				}
			} else {//走兽类
				if ((Float)totalSum.get(i) < (priceForPrize - beastOutScore)){
					v.add(i);
				}
			}

		}
		return v;
	}
	/**
	 * 炸弹函数
	 */
	private void bombPrize() {
		try{
			if( totalBombSum > 0 ){//如果有人下注
				
			} else {
				
			}
			
		} catch  (Exception ex) {
			System.out.printf("炸弹分奖", "炸弹奖:" + ex.getMessage());
		}

	}
	/**
	 * 诱惑函数
	private String attractPrize() {
		return null;
	} */
	/**
	 * 再转函数
	 */
	private String turnAgain() {		
		return null;
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
				panelData.setPrizeItem(Prize.RAFFLING);// 设置奖项状态为正在抽奖
				sharkDao.save(panelData);//保存panel获得数据	
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
	public boolean isAgainOrNot() {
		return againOrNot;
	}
	public void setAgainOrNot(boolean againOrNot) {
		this.againOrNot = againOrNot;
	}
	public Prize getPrizeString() {
		return prizeString;
	}
	public void setPrizeString(Prize prizeString) {
		this.prizeString = prizeString;
	}

	
}
