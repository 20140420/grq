package com.grq.controller.action.interceptor;

import java.util.Map;

import com.grq.controller.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 消费者登录拦截器
 * @author JiangQuan
 *
 */
public class CustomerLoginInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;
	/**
	 * 拦截器
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();// 获取ActionContext
		Map<String, Object> session = context.getSession();// 获取Map类型的session
		if(session.get("customer") != null){// 判断用户是否登录 
			return invocation.invoke();// 调用执行方法
		}
		return BaseAction.CUSTOMER_LOGIN;// 返回登录
	}
}
