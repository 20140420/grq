package com.grq.model.customizeenum;
/**
 * ֧����ʽ
 * @author JiangQuan
 */
public enum PaymentWay {
	NET_BANK{
		@Override
		public String getName() {
			return "��������֧��";
		}
	},
	ALIPAY{
		@Override
		public String getName() {
			return "֧����";
		}
	},
	FINISH_PAY{
		@Override
		public String getName() {
			return "��������";
		}
	},
	POSTOFFICE_PAY{
		@Override
		public String getName() {
			return "�ʾֻ��";
		}
	};
	public abstract String getName();
}
