package com.grq.model.dao.product;

import com.grq.model.dao.BaseDao;
import com.grq.model.pojo.product.Order;

public interface OrderDao extends BaseDao<Order> {
	public Order findByCustomer(int customerId);
}
