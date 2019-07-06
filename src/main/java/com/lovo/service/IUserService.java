package com.lovo.service;

import java.util.List;

import com.lovo.entity.UserBean;

public interface IUserService {
	
	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户实体
	 */
	public UserBean login(String username,String password);
	
	/**
	 * 添加用户
	 * @param user 用户
	 */
	public void addUser(UserBean user);
	
	/**
	 * 查看所有的用户
	 * @param currentPage 当前页面
	 * @return 用户集合
	 */
	public List<UserBean> findByItem(int currentPage);
	
	/**
	 * 获取总条数
	 * @return 总条数
	 */
	public int getTotalCountByItem();
	
	public List<UserBean> findAllUser();
}
