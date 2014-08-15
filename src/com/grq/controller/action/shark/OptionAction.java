package com.grq.controller.action.shark;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.PageModel;
import com.grq.model.pojo.shark.SharkConfig;
import com.grq.model.util.StringUtil;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("optionAction")
public class OptionAction extends BaseAction implements ModelDriven<SharkConfig>{
	private static final long serialVersionUID = 1L;
	
/** -------------------------------------------------------------------- */
	private PageModel<SharkConfig> pageModel;// 分页组件
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
	//getter和setter方法，放入request中，好在jsp页面中能拿到	
	public PageModel<SharkConfig> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<SharkConfig> pageModel) {
		this.pageModel = pageModel;
	}
	public SharkConfig getSharkConfig() {
		return sharkConfig;
	}
	public void setSharkConfig(SharkConfig sharkConfig) {
		this.sharkConfig = sharkConfig;
	}
/** -------------------------------------------------------------------- */	
	
	/**
	 * 游戏shark的设定
	 * @return shark设定页面
	 * @throws Exception
	 */
	public String option() throws Exception{
		
		return list();
	}
	/**
	 * 保存游戏配置设置
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		try{
			if(getLoginUser() != null){//如果管理用户已登录
				sharkConfig.setId(StringUtil.getStringTime());//添加18位数字字符串与其他配置属性一起加到数据库
				sharkConfigDao.saveOrUpdate(sharkConfig);//保存到对象
				return list();//返回设定页面
			}
		} catch(Exception ex){
			System.out.println("保存游戏配置时出现问题");
		}
		return ADMIN_LOGIN;//返回登入页面
	}
	/**
	 * 查询所有历来配置
	 * @return String
	 * @throws Exception
	 */
	public String list() throws Exception {
		if(getLoginUser() != null){//如果用户已登录
			Map<String, String> orderby = new HashMap<String, String>(1);//创建Map集合
			orderby.put("createTime", "desc");//设置排序条件及方式
			//获取最新一条配置
			pageModel = sharkConfigDao.find(-1, -1, orderby);//执行查询方法
			if(pageModel.getList().get(0).getId() != null){//存在配置
				this.sharkConfig = sharkConfigDao.get(pageModel.getList().get(0).getId());//加载对象最新配置序列号
				boolean isBegin = sharkConfig.getIsBegin();//获取游戏是否开启
				if(isBegin){//如果游戏开启
					Shark.main(null);//通过Shark的main函数启动游戏
				}
			}
			System.out.println("最新初始彩金池："+sharkConfig.getInitialDividend());
			//获取历史所有配置以分页形式保存
			pageModel = sharkConfigDao.find(pageNo, pageSize, orderby);//执行查询方法
			//System.out.println("获取配置分页对象："+pageModel.getList().get(0).getCreateTime());
			return "option";//返回配置列表页面
		}
		return ADMIN_LOGIN;//返回登入页面
	}
}
