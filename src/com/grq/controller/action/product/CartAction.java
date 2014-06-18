package com.grq.controller.action.product;

import java.util.Iterator;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grq.controller.action.BaseAction;
import com.grq.model.pojo.product.OrderItem;
import com.grq.model.pojo.product.ProductInfo;
/**
 * ���ﳵAction
 * @author JiangQuan
 */
@Scope("prototype")
@Controller("cartAction")
public class CartAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	// ��Ʒid
	private Integer productId;

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * ���ﳵ�������Ʒ
	 * @return 
	 */
	@Override
	public String add() throws Exception {
		if(productId != null && productId > 0){
			// ��ȡ���ﳵ
			Set<OrderItem> cart = getCart();
			// �����ӵ���Ʒ�Ƿ���ͬһ����Ʒ
			boolean same = false;
			for (OrderItem item : cart) {
				if(item.getProductId() == productId){
					// ������ͬ����Ʒ����������
					item.setAmount(item.getAmount() + 1);
					same = true;
				}
			}
			// ����ͬһ����Ʒ
			if(!same){
				OrderItem item = new OrderItem();
				ProductInfo pro = productDao.load(productId);
				item.setProductId(pro.getId());
				item.setProductName(pro.getName());
				item.setProductPrice(pro.getSellprice());
				item.setProductMarketprice(pro.getMarketprice());
				cart.add(item);
			}
			session.put("cart", cart);
		}
		return LIST;
	}
	// �鿴���ﳵ
	public String list() throws Exception {
		return LIST;//���ع��ﳵҳ��
	}
	// �ӹ��ﳵ��ɾ����Ʒ
	public String delete() throws Exception {
		Set<OrderItem> cart = getCart();// ��ȡ���ﳵ
		// �˴�ʹ��Iterator���������java.util.ConcurrentModificationException
		Iterator<OrderItem> it = cart.iterator();
		while(it.hasNext()){//ʹ�õ�����������Ʒ������Ŀ��Ϣ
			OrderItem item = it.next();
			if(item.getProductId() == productId){
				it.remove();//�Ƴ���Ʒ������Ŀ��Ϣ
			}
		}
		session.put("cart", cart);//����պ����Ϣ���·���Session��
		return LIST;//���ع��ﳵҳ��
	}
	// ��չ��ﳵ
	public String clear() throws Exception {
		session.remove("cart");
		return LIST;
	}
}
