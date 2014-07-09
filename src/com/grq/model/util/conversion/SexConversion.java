package com.grq.model.util.conversion;

import java.util.Map;
//import ognl.DefaultTypeConverter;
import org.apache.struts2.util.StrutsTypeConverter;
//import java.util.List;
//import java.util.ArrayList;

import com.grq.model.customizeenum.Sex;
/**
 * 性别类型转换器
 * @author JiangQuan
 */
public class SexConversion extends StrutsTypeConverter {
	
	/**
	 * 如果是对象（数组，日期，对象等都进入这个处理方法）
	 */
	//@SuppressWarnings("unchecked")
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		//把传入的一串字符串解析成一个对象，然后返回给对应的字段。
		Sex sexs[] = Sex.values();
		for (Sex sex : sexs) {
			if(sex.getName().equals(arg1[0])){
				System.out.println("OK~~对象处理完成，返回对象");
				return sex;
			}
		}
		return null;
	}
	
	/**
	 * 如果表单name 对应的 java字段  只是字符串
	 */
	//@SuppressWarnings("unchecked")
	@Override
	public String convertToString(Map arg0, Object arg1) {
		Sex sex = (Sex) arg1;
		return sex.getName();
	}
}
