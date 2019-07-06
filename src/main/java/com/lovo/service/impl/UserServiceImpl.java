package com.lovo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovo.dao.IUserDao;
import com.lovo.entity.UserBean;
import com.lovo.service.IUserService;

@Service(value="userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	public UserBean login(String username, String password) {

		return userDao.login(username, password);
	}

	public void addUser(UserBean user) {
		userDao.addUser(user);
		
	}

	@Override
	public List<UserBean> findByItem(int currentPage) {
		currentPage = (currentPage - 1) * 5;
		List<UserBean> list = userDao.findByItem(currentPage);
		return list;
	}

	@Override
	public int getTotalCountByItem() {
		Integer totalCount = userDao.getTotalCountByItem();
		Integer totalPage = (totalCount + 5 - 1)/5;
		return totalPage;
	}

	@Override
	public List<UserBean> findAllUser() {
		
		return userDao.findAllUser();
	}

}
