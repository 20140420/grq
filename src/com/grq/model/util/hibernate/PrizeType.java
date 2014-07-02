package com.grq.model.util.hibernate;

import com.grq.model.customizeenum.Prize;
/**
 * 奖项Hibernate映射类型
 * @author JiangQuan
 */
public class PrizeType extends EnumType<Prize> {
	//结构体
	public PrizeType() {
		super(Prize.class);
	}
}
