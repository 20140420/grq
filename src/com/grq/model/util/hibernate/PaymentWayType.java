package com.grq.model.util.hibernate;

import com.grq.model.customizeenum.PaymentWay;
/**
 * ֧����ʽHibernateӳ������
 * @author JiangQuan
 */
public class PaymentWayType extends EnumType<PaymentWay> {
	//�ṹ��
	public PaymentWayType() {
		super(PaymentWay.class);
	}
}
