package com.grq.model.util.conversion;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.grq.model.customizeenum.Prize;
/**
 * 奖项转换器
 * @author JiangQuan
 */
public class PrizeConversion extends StrutsTypeConverter {
	
	/**
	 * 如果是对象（数组，日期，对象等都进入这个处理方法）
	 */
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		//把传入的一串字符串解析成一个对象，然后返回给对应的字段。
		Prize prizes[] = Prize.values();
		for(Prize prize : prizes){
			if(prize.getName().equals(arg1[0])){
				System.out.println("OK~~对象（奖项prize）处理完成，返回对象（奖项prize）");
				return prize;
			}
		}
		return null;
	}
	
	/**
	 * 如果表单name 对应的 java字段  只是字符串
	 */
	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		Prize prize = (Prize) arg1;
		return prize.getName();
	}

}
