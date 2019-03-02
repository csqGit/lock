package com.app.bzpower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bzpower.dao.UserDao;
import com.app.bzpower.entity.Company;
import com.app.bzpower.entity.User;
import com.app.bzpower.service.UserService;

/**
 * 用户Service
 * @author Admin
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public void userRegister(String telephone, String userName, String realName, Company company, String password) {
		/*
		 * 0 普通用户
		 * 1 中级用户
		 * 2 超级用户
		 */
		int type = 0;
		String jobNumber = "20190001";
		userDao.userRegister(telephone, userName, realName, 1, password, type,  jobNumber);
		
	}

	public User userLogin(String telephone, String password) {
		User user = userDao.userLogin(telephone, password);
		return user;
	}
	

}
