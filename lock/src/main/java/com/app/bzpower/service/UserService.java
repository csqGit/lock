package com.app.bzpower.service;

import com.app.bzpower.entity.Company;
import com.app.bzpower.entity.User;

public interface UserService {
	/*
	 * 用户注册
	 */
	void userRegister( String telephone, String userName, String realName, 
			Company company, String password);
	
	/*
	 * 用户登录
	 */
	User userLogin(String phone, String password);


}
