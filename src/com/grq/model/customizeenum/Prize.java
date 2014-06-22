package com.grq.model.customizeenum;
import java.util.ArrayList;
import java.util.List;

/**
 * ����ö��
 * @author JiangQuan
 */
public enum Prize {
	SWALLOW{
		@Override
		public String getName() {
			return "����";
		}
	},
	PIGEON{
		@Override
		public String getName() {
			return "����";
		}
	},
	PEAFOWL{
		@Override
		public String getName() {
			return "��ȸ";
		}
	},
	EAGLE{
		@Override
		public String getName() {
			return "��ӥ";
		}
	},
	LION{
		@Override
		public String getName() {
			return "ʨ��";
		}
	},
	PANDA{
		@Override
		public String getName() {
			return "��è";
		}
	},
	MONKEY{
		@Override
		public String getName() {
			return "����";
		}
	},
	RABBIT{
		@Override
		public String getName() {
			return "����";
		}
	},
	BIRD{
		@Override
		public String getName() {
			return "����";
		}
	},
	BEAST{
		@Override
		public String getName() {
			return "����";
		}
	},
	GOLD_SHARK{
		@Override
		public String getName() {
			return "����";
		}
	},
	SILVER_SHARK{
		@Override
		public String getName() {
			return "����";
		}
	},
	BOMB{
		@Override
		public String getName() {
			return "ը��";
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
