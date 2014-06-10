package com.grq.model.util.hibernate;

import com.grq.model.customizeenum.PaymentWay;
/**
 * 支付方式Hibernate映射类型
 * @author JiangQuan
 */
public class PaymentWayType extends EnumType<PaymentWay> {
	//结构体
	public PaymentWayType() {
		super(PaymentWay.class);
	}
}
