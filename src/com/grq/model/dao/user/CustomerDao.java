package com.grq.model.dao.user;

import com.grq.model.dao.BaseDao;
import com.grq.model.pojo.user.Customer;

public interface CustomerDao extends BaseDao<Customer> {
	public Customer login(String username, String password);
	public boolean isUnique(String username);
}
