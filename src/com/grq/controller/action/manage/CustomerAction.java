package com.grq.controller.action.manage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.pojo.user.Customer;
import com.grq.model.util.AppException;
import com.opensymphony.xwork2.ModelDriven;
/**
 * �˿�Action
 * @author JiangQuan
 */
@Scope("prototype")
@Controller("customerAction")
public class CustomerAction extends BaseAction implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1L;
	// �˿�
	private Customer customer = new Customer();
	// ȷ������
	private String repassword;
	@Override
	public Customer getModel() {
		return customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	/**
	 * �̳�BaseAction����д���˿��û�����ҳ��
	 * @return "customerLogin"
	 * @throws Exception
	 */
	@Override
	public String login() throws Exception{
		return CUSTOMER_LOGIN;
	}
	/**
	 * �û���¼ 
	 * @return
	 * @throws Exception
	 */
	public String logon() throws Exception{
		//��֤�û����������Ƿ���ȷ
		Customer loginCustomer = customerDao.login(customer.getUsername(), customer.getPassword());
		if(loginCustomer != null){//���ͨ����֤
			session.put("customer", loginCustomer);//����¼��Ա��Ϣ������Session��
		}else{//��֤ʧ��
			addFieldError("", "CustomerAction�û��������벻��ȷ��");//���ش�����Ϣ
			return CUSTOMER_LOGIN;//���ػ�Ա��¼ҳ��
		}
		return CUSTOMER_MANAGE;//�˿͵���ɹ���ת���û���̨
	}
	/**
	 * �û��˳�
	 * @return String
	 * @throws Exception
	 */
	public String logout() throws Exception{
		if(session != null && session.size() > 0){
			session.clear();
		}
		return INDEX;
	}
	/**
	 * �û�ע��
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		boolean unique = customerDao.isUnique(customer.getUsername());//�ж��û����Ƿ�Ψһ
		if(unique){//����û�������
			customerDao.save(customer);//����ע����Ϣ
			return CUSTOMER_LOGIN;//���ػ�Ա��¼ҳ��
		}else{
			throw new AppException("user have Already exists!!���û���������");//���򷵻�ҳ�������Ϣ
		}
	}
	
	
	
	/**
	 * �˿��û���̨ҳ��
	 * @return
	 * @throws Exception
	 */
	@Override
	public String manage() throws Exception{

		return CUSTOMER_MANAGE;
	}
	public String usilverbuy() throws Exception{

		return "usilverbuy";
	}
	public String usilversell() throws Exception{

		return "usilversell";
	}
	public String uinquiryaccount() throws Exception{

		return "uinquiryaccount";
	}
	public String uinquirysilverrecord() throws Exception{

		return "uinquirysilverrecord";
	}
	public String uinquirygame() throws Exception{

		return "uinquirygame";
	}
	public String uinvest() throws Exception{

		return "uinvest";
	}
	public String uinvestrecord() throws Exception{

		return "uinvestrecord";
	}
	public String ugiro() throws Exception{

		return "ugiro";
	}
	public String ugirorecord() throws Exception{

		return "ugirorecord";
	}
	public String uprofile() throws Exception{

		return "uprofile";
	}
	public String upassquestion() throws Exception{

		return "upassquestion";
	}
	public String ubankcard() throws Exception{

		return "ubankcard";
	}
	public String umaster() throws Exception{

		return "umaster";
	}
	public String uapprentice() throws Exception{

		return "uapprentice";
	}
	
}
