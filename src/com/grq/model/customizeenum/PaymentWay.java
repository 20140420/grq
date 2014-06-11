package com.grq.model.customizeenum;
/**
 * 支付方式
 * @author JiangQuan
 */
public enum PaymentWay {
	NET_BANK{
		@Override
		public String getName() {
			return "网银支付";
		}
	},
	ALIPAY{
		@Override
		public String getName() {
			return "支付宝";
		}
	},
	FINISH_PAY{
		@Override
		public String getName() {
			return "货到付款";
		}
	},
	POSTOFFICE_PAY{
		@Override
		public String getName() {
			return "邮局汇款";
		}
	};
	public abstract String getName();
}
