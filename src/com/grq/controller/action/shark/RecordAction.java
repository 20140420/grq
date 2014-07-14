package com.grq.controller.action.shark;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.PageModel;
import com.grq.model.customizeenum.Prize;
import com.grq.model.pojo.shark.PrizeRecord;
import com.grq.model.pojo.shark.TimesEntity;
import com.grq.model.util.StringUtil;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("recordAction")
public class RecordAction extends BaseAction implements ModelDriven<PrizeRecord>{
	private static final long serialVersionUID = 1L;
	
/** -------------------------------------------------------------------- */
	private PageModel<PrizeRecord> pageModel;// 分页组件
	// 实体变量
	private static List<TimesEntity> timesEntity;
	
	
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
	 * 随机生成一组倍数列表，并保存到奖项记录数据表中
	 * @return
	 */
	public List<Object> timesCreate() {
		//添加倍数数据（写在pojo中）
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
		/*
		try{
			prizeRecord.setPrizeId(StringUtil.getStringTime());//添加18位数字字符串作为奖项结果期号
			prizeRecord.setTimesSwallow(timesEntity.get(timesIndex).getTimesSwallow());
			prizeRecord.setTimesPigeon(timesEntity.get(timesIndex).getTimesPigeon());
			prizeRecord.setTimesPeafowl(timesEntity.get(timesIndex).getTimesPeafowl());
			prizeRecord.setTimesEagle(timesEntity.get(timesIndex).getTimesEagle());
			prizeRecord.setTimesLion(timesEntity.get(timesIndex).getTimesLion());
			prizeRecord.setTimesPanda(timesEntity.get(timesIndex).getTimesPanda());
			prizeRecord.setTimesMonkey(timesEntity.get(timesIndex).getTimesMonkey());
			prizeRecord.setTimesRabbit(timesEntity.get(timesIndex).getTimesRabbit());
			System.out.println("奖项记录："+prizeRecord.getPrizeId());
			prizeRecordDao.saveOrUpdate(prizeRecord);//保存到对象
		} catch(Exception ex){
			System.out.println("保存倍数列表时出现问题");
		}
		*/
		prizeRecord.setPrizeId(StringUtil.getStringTime());//添加18位数字字符串作为奖项结果期号
		prizeRecord.setCommissionRate(0.0);
		prizeRecord.setPrizeName(Prize.RAFFLING);
		prizeRecord.setDividend(0.0);
		prizeRecord.setTimesSwallow(timesEntity.get(timesIndex).getTimesSwallow());
		prizeRecord.setTimesPigeon(timesEntity.get(timesIndex).getTimesPigeon());
		prizeRecord.setTimesPeafowl(timesEntity.get(timesIndex).getTimesPeafowl());
		prizeRecord.setTimesEagle(timesEntity.get(timesIndex).getTimesEagle());
		prizeRecord.setTimesLion(timesEntity.get(timesIndex).getTimesLion());
		prizeRecord.setTimesPanda(timesEntity.get(timesIndex).getTimesPanda());
		prizeRecord.setTimesMonkey(timesEntity.get(timesIndex).getTimesMonkey());
		prizeRecord.setTimesRabbit(timesEntity.get(timesIndex).getTimesRabbit());
		prizeRecord.setTimesGoldShark(0);
		prizeRecord.setTotalSwallowSum(0.0);
		prizeRecord.setTotalPigeonSum(0.0);
		prizeRecord.setTotalPeafowlSum(0.0);
		prizeRecord.setTotalEagleSum(0.0);
		prizeRecord.setTotalLionSum(0.0);
		prizeRecord.setTotalPandaSum(0.0);
		prizeRecord.setTotalMonkeySum(0.0);
		prizeRecord.setTotalRabbitSum(0.0);
		prizeRecord.setTotalBirdSum(0.0);
		prizeRecord.setTotalSilverSum(0.0);
		prizeRecord.setTotalBombSum(0.0);
		prizeRecord.setTotalGoldSum(0.0);
		prizeRecord.setTotalBeastSum(0.0);
		prizeRecord.setTotalBetSum(0.0);
		System.out.println("奖项记录的兔子："+prizeRecord.getTimesRabbit());
		System.out.println("奖项记录的费率："+prizeRecord.getCommissionRate());
		System.out.println("奖项记录的时间："+prizeRecord.getCreateTime());
		prizeRecordDao.saveOrUpdate(prizeRecord);//保存到对象
		//把生成的一组倍数加到list对象中
		ArrayList<Object> newTimesList = new ArrayList<Object>();//随机生成一组倍数
		newTimesList.add(timesEntity.get(timesIndex).getTimesSwallow());//注意添加的顺序
		newTimesList.add(timesEntity.get(timesIndex).getTimesPigeon());
		newTimesList.add(timesEntity.get(timesIndex).getTimesPeafowl());
		newTimesList.add(timesEntity.get(timesIndex).getTimesEagle());
		newTimesList.add(timesEntity.get(timesIndex).getTimesLion());
		newTimesList.add(timesEntity.get(timesIndex).getTimesPanda());
		newTimesList.add(timesEntity.get(timesIndex).getTimesMonkey());
		newTimesList.add(timesEntity.get(timesIndex).getTimesRabbit());
		return newTimesList;
	}
	
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
