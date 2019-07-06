package com.lovo.mapper;

import com.lovo.entity.UserBean;

public interface UserMapper {
	
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
}
