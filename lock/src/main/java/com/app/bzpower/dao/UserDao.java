package com.app.bzpower.dao;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.Company;
import com.app.bzpower.entity.User;

/**
 * 用户dao
 * @author Admin
 *
 */
public interface UserDao {
	/*
	 * 用户注册
	 */
	void userRegister(@Param("telephone") String telephone, 
			@Param("userName") String userName,@Param("realName") String realName, 
			@Param("companyId") int companyId,@Param("password") String password,
			@Param("type") int type, 
			@Param("jobNumber") String jobNumber);
	
	/*
	 * 用户登录
	 */
	User userLogin(@Param("telephone") String telephone, @Param("password") String password);

}
