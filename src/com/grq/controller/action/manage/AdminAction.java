package com.grq.controller.action.manage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.pojo.user.User;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("adminAction")
public class AdminAction extends BaseAction implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	
	// �û�����
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * ����Ա����
	 */
	@Override
	public String login() throws Exception{
		return ADMIN_LOGIN;
	}
	/**
	 * ��¼ 
	 * @return
	 * @throws Exception
	 */
	public String logon() throws Exception{
		//��֤�û���������
		User loginUser = userDao.login(user.getUsername(), user.getPassword());
		if(loginUser != null){//ͨ����֤
			session.put("admin", loginUser);//������Ա��Ϣ������Session����admin��
		}else{
			addFieldError("", "�û��������벻��ȷ��");//���ش�����ʾ��Ϣ
			return ADMIN_LOGIN;//���ع���Ա��̨��¼ҳ��
		}
		System.out.print("����Ա����ɹ���OK");
		return ADMIN_MANAGE;//���ع���Ա��̨ҳ��
	}
	/**
	 * �˳�(�޸ĺ�ֻ����Ա�˳�)
	 * @return String
	 * @throws Exception
	 */
	public String logout() throws Exception{
		//if(session != null && session.size() > 0){
		if(session.get("admin") != null){
			//session.clear();
			session.put("admin", null);
		}
		return INDEX;
	}
	
	/**
	 * msidebarҳ��
	 * @return
	 * @throws Exception
	 */
	public String webserver() throws Exception{

		return "webserver";
	}
	public String webdatabase() throws Exception{

		return "webdatabase";
	}
	public String webotherinformation() throws Exception{

		return "webotherinformation";
	}
	public String adminuser() throws Exception{

		return "adminuser";
	}
	public String playeruser() throws Exception{

		return "playeruser";
	}
	public String assetgiro() throws Exception{

		return "assetgiro";
	}
	public String assetsilver() throws Exception{

		return "assetsilver";
	}
	public String assetinvest() throws Exception{

		return "assetinvest";
	}
	public String operatesales() throws Exception{

		return "operatesales";
	}
	public String operateoption() throws Exception{

		return "operateoption";
	}
		


}