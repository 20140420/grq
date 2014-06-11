package com.grq.model.customizeenum;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单状态
 * @author JiangQuan
 */
public enum OrderState {
	DELIVERED {
		@Override
		public String getName() {
			return "已发货";
		}
	},
	FINISH{
		@Override
		public String getName() {
			return "已完成";
		}
	},
	CANCLE{
		@Override
		public String getName() {
			return "已取消";
		}
	};
	public abstract String getName();
	public static List<String> getValues(){
		List<String> list = new ArrayList<String>();
		for (OrderState orderState : OrderState.values()) {
			list.add(orderState.getName());
		}
		return list;
	}
}
