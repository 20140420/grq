package com.grq.model.util.conversion;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.grq.model.customizeenum.PaymentWay;
/**
 * ֧����ʽ����ת����
 * @author JiangQuan
 *
 */
public class PaymentWayConversion extends StrutsTypeConverter{
	/**
	 * ����Ƕ������飬���ڣ�����ȶ����������������
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
	 * �����name ��Ӧ�� java�ֶ�  ֻ���ַ���
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String convertToString(Map arg0, Object arg1) {
		PaymentWay paymentWay = (PaymentWay)arg1;
		return paymentWay.getName();
	}

}
