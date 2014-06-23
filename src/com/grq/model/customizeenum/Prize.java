package com.grq.model.customizeenum;
import java.util.ArrayList;
import java.util.List;

/**
 * 奖项枚举
 * @author JiangQuan
 */
public enum Prize {
	SWALLOW{
		@Override
		public String getName() {
			return "燕子";
		}
	},PIGEON{
		@Override
		public String getName() {
			return "鸽子";
		}
	}, PEAFOWL{
		@Override
		public String getName() {
			return "孔雀";
		}
	},EAGLE{
		@Override
		public String getName() {
			return "老鹰";
		}
	},LION{
		@Override
		public String getName() {
			return "狮子";
		}
	},PANDA{
		@Override
		public String getName() {
			return "熊猫";
		}
	},MONKEY{
		@Override
		public String getName() {
			return "猴子";
		}
	},RABBIT{
		@Override
		public String getName() {
			return "兔子";
		}
	},BIRD{
		@Override
		public String getName() {
			return "飞禽";
		}
	},SILVER_SHARK{
		@Override
		public String getName() {
			return "银鲨";
		}
	}, BOMB{
		@Override
		public String getName() {
			return "炸弹";
		}
	}, GOLD_SHARK{
		@Override
		public String getName() {
			return "金鲨";
		}
	}, BEAST{
		@Override
		public String getName() {
			return "走兽";
		}
	};
	public abstract String getName();
	public static List<String> getValues(){
		List<String> list = new ArrayList<String>();
		for (Prize prize : Prize.values()) {
			list.add(prize.getName());
		}
		return list;
	}
}
