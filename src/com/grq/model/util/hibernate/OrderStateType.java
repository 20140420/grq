package com.grq.model.util.hibernate;

import com.grq.model.customizeenum.OrderState;
/**
 * ����״̬Hibernateӳ������
 * @author JiangQuan
 */
public class OrderStateType extends EnumType<OrderState> {
	//�ṹ��
	public OrderStateType() {
		super(OrderState.class);
	}
}
