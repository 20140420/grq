package com.grq.model.util.conversion;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.grq.model.customizeenum.PaymentWay;
/**
 * 支付方式类型转换器
 * @author JiangQuan
 *
 */
public class PaymentWayConversion extends StrutsTypeConverter{
	/**
	 * 如果是对象（数组，日期，对象等都进入这个处理方法）
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		PaymentWay[] paymentWays = PaymentWay.values();
		for (PaymentWay paymentWay : paymentWays) {
			if(paymentWay.getName().equals(arg1[0])){
				return paymentWay;
			}
		}
		return null;
	}
	/**
	 * 如果表单name 对应的 java字段  只是字符串
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String convertToString(Map arg0, Object arg1) {
		PaymentWay paymentWay = (PaymentWay)arg1;
		return paymentWay.getName();
	}

}
