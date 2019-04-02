package com.app.bzpower.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.Log;
import com.app.bzpower.entity.PageData;
import com.app.bzpower.entity.Admin;

public interface AdminService {
	/**
	 * 用户注册
	 */
	void insertAdmin(Admin admin);
	
	/**
	 * 分页查询
	 * @param page
	 * @param maxResult
	 * @return
	 */
	List<Admin> selectAdminList(PageData pageData);
	
	Admin selectLogByTelephone(String phone);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	Admin selectAdminById(int id);
	
	/**
	 * 根据用户名查询
	 * @param AdminName
	 * @return
	 */
	List<Admin> selectAdminByName(String adminName);
	
	/**
	 * 得到总页数
	 * @return
	 */
	int selectPages();
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	void deleteAdmin(int id);
	
	/**
	 * 根据ID更新用户信息
	 * @param Admin
	 */
	void updateAdmin(Admin admin);
	
	/*
	 * 用户登录
	 */
	Admin AdminLogin(@Param("adminName") String adminName, @Param("password") String password);

}
