package com.grq.model.util.hibernate;

import com.grq.model.customizeenum.OrderState;
/**
 * 订单状态Hibernate映射类型
 * @author JiangQuan
 */
public class OrderStateType extends EnumType<OrderState> {
	//结构体
	public OrderStateType() {
		super(OrderState.class);
	}
}
