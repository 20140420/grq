package com.grq.model.dao.user;

import com.grq.model.dao.BaseDao;
import com.grq.model.pojo.user.User;

public interface UserDao extends BaseDao<User> {
	public User login(String username, String password);
	public boolean isUnique(String username);
}
