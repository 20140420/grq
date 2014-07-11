package com.grq.controller.action.shark;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.customizeenum.Prize;
import com.grq.model.pojo.shark.SharkConfig;
import com.grq.model.util.StringUtil;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("optionAction")
public class OptionAction extends BaseAction implements ModelDriven<SharkConfig>{
	private static final long serialVersionUID = 1L;
	
/** -------------------------------------------------------------------- */
	// 游戏配置对象
	private SharkConfig sharkConfig = new SharkConfig();//一定要先初始化obj对象！
	/**
	 * 此方法是Modeldriven接口的方法，要重写
	 * @return
	 */
	@Override
	public SharkConfig getModel() {
		return sharkConfig;
	}
/** -------------------------------------------------------------------- */	
	
	/**
	 * 游戏shark的设定
	 * @return shark设定页面
	 * @throws Exception
	 */
	public String option() throws Exception{

		return "option";
	}
	/**
	 * 保存游戏配置设置
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		//System.out.print("提交的配置设定");
		if(getLoginUser() != null){//如果用户已登录
			//System.out.print("用户登入的");
			return "option";//返回设定页面
		}
		return ADMIN_LOGIN;//返回登入页面
	}
}
