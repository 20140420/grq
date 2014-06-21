package com.grq.model.util.conversion;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.grq.model.customizeenum.Prize;
/**
 * ����ת����
 * @author JiangQuan
 */
public class PrizeConversion extends StrutsTypeConverter {
	
	/**
	 * ����Ƕ������飬���ڣ�����ȶ����������������
	 */
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		//�Ѵ����һ���ַ���������һ������Ȼ�󷵻ظ���Ӧ���ֶΡ�
		Prize prizes[] = Prize.values();
		for(Prize prize : prizes){
			if(prize.getName().equals(arg1[0])){
				System.out.println("OK~~���󣨽���prize��������ɣ����ض��󣨽���prize��");
				return prize;
			}
		}
		return null;
	}
	
	/**
	 * �����name ��Ӧ�� java�ֶ�  ֻ���ַ���
	 */
	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		Prize prize = (Prize) arg1;
		return prize.getName();
	}

}
