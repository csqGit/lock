package com.app.bzpower.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.PageData;
import com.app.bzpower.entity.User;

public interface UserService {
	/**
	 * 用户注册
	 */
	void insertUser(User user);
	
	/**
	 * 分页查询
	 * @param page
	 * @param maxResult
	 * @return
	 */
	List<User> selectUserList(PageData pageData);
	
	User selectLogByTelephone(String phone);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	User selectUserById(int id);
	
	/**
	 * 根据用户名查询
	 * @param UserName
	 * @return
	 */
	List<User> selectUserByName(String userName);
	
	/**
	 * 得到总页数
	 * @return
	 */
	int selectPages();
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	void deleteUser(int id);
	
	/**
	 * 根据ID更新用户信息
	 * @param User
	 */
	void updateUser(User user);
	
	/*
	 * 用户登录
	 */
	User UserLogin(String username, String password);

}
