package com.app.bzpower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.Admin;

/**
 * 用户dao
 * @author Admin
 *
 */
public interface UserDao {
	/**
	 * 用户注册
	 */
//	void insertUser(@Param("telephone") String telephone, 
//			@Param("userName") String userName,@Param("realName") String realName, 
//			@Param("companyId") int companyId,@Param("password") String password,
//			@Param("type") int type, 
//			@Param("jobNumber") String jobNumber);
	
	void insertUser(Admin user);
	
	/**
	 * 分页查询
	 * @param page
	 * @param maxResult
	 * @return
	 */
	List<Admin> selectUserList(@Param("page") int page, @Param("maxResult") int maxResult);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	Admin selectUserById(int id);
	
	/**
	 * 根据用户名查询
	 * @param userName
	 * @return
	 */
	List<Admin> selectUserByName(String userName);
	
	int selectUserCount();
	
	Admin selectUserByTelePhone(@Param("telephone") String telephone);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	void deleteUser(int id);
	
	/**
	 * 根据ID更新用户信息
	 * @param user
	 */
	void updateUser(Admin user);
	
	/*
	 * 用户登录
	 */
	Admin userLogin(@Param("userName") String userName, @Param("password") String password);

}
