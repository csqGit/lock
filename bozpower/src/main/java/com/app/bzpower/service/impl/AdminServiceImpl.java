package com.app.bzpower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bzpower.dao.AdminMapper;
import com.app.bzpower.entity.Admin;
import com.app.bzpower.entity.AdminExample;
import com.app.bzpower.entity.PageData;
import com.app.bzpower.service.AdminService;
import com.app.bzpower.util.DefaultUtils;

/**
 * 用户Service
 * 
 * @author Admin
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	private int maxResult = DefaultUtils.maxResult;

	public void insertAdmin(Admin record) {
		try {
			adminMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Admin AdminLogin(String username, String password) {
		AdminExample example = new AdminExample();
		example.createCriteria().andUsernameEqualTo(username);
		example.createCriteria().andPasswordEqualTo(password);
		List<Admin> adminList = adminMapper.selectByExample(example);
		if (adminList.size() > 0)
			return adminList.get(0);
		else
			return null;
	}

	public List<Admin> selectAdminList(PageData pageData) {
		int page = pageData.getPage();
		if (page == 0) {// 手机端全部查询
			maxResult = 0;
		}
		page = (page - 1) * maxResult;
		List<Admin> AdminList = null;
		try {
			AdminExample example = new AdminExample();
			AdminList = adminMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AdminList;
	}

	public Admin selectAdminById(int id) {
		Admin admin = adminMapper.selectByPrimaryKey(id);
		return admin;
	}

	public List<Admin> selectAdminByName(String username) {
		AdminExample example = new AdminExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<Admin> adminList = adminMapper.selectByExample(example);
		return adminList;
	}

	public void deleteAdmin(int id) {
		try {
			adminMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void updateAdmin(Admin record) {
		try {
			adminMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Admin adminLogin(String userName, String password) {
		AdminExample example = new AdminExample();
		Admin admin = null;
		example.createCriteria().andUsernameEqualTo(userName);
		example.createCriteria().andPasswordEqualTo(password);
		List<Admin> adminList = adminMapper.selectByExample(example);
		if (adminList.size() > 0)
			admin = adminList.get(0);
		return admin;
	}

	public int selectPages() {
		AdminExample example = new AdminExample();

		int pages = adminMapper.selectByExample(example).size();
		if (maxResult == 0) {// 防止出现java.lang.ArithmeticException: / by zero
			return 0;
		}
		if (pages % maxResult != 0) {
			pages = pages / maxResult + 1;
		} else {
			pages = pages / maxResult;
		}
		return pages;
	}

	public Admin selectLogByTelephone(String telephone) {
		AdminExample example = new AdminExample();
		example.createCriteria().andTelephoneEqualTo(telephone);
		List<Admin> adminList = adminMapper.selectByExample(example);
		if (adminList.size() > 0)
			return adminList.get(0);
		else
			return null;
	}
}
