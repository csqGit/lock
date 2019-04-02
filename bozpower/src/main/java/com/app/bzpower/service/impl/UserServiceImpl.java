package com.app.bzpower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bzpower.dao.UserMapper;
import com.app.bzpower.entity.Admin;
import com.app.bzpower.entity.PageData;
import com.app.bzpower.entity.User;
import com.app.bzpower.entity.UserExample;
import com.app.bzpower.service.UserService;
import com.app.bzpower.util.DefaultUtils;

/**
 * 用户Service
 * @author Admin
 *
 */
@Service
public class UserServiceImpl implements UserService  {
	
//	@Autowired
//	private UserDao userDao;
	
	@Autowired
	private UserMapper userMapper;
	
	private int maxResult = DefaultUtils.maxResult;

	public void insertUser(User user) {
		try {
			userMapper.insert(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<User> selectUserList(PageData pageData) {
		int page = pageData.getPage();			
		if (page == 0) {// 手机端全部查询
			maxResult = 0;
		} 
		page = (page - 1) * maxResult;
		List<User> userList = null;
		try {
			UserExample example = new UserExample();
			userList = userMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	public User selectUserById(int id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	public List<User> selectUserByName(String userName) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(userName);
		List<User> user = userMapper.selectByExample(example);
		return user;
	}

	public void deleteUser(int id) {
		try {
			userMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			userMapper.updateByPrimaryKey(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public User userLogin(String userName, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(userName);
		example.createCriteria().andPasswordEqualTo(password);
		List<User> userList = userMapper.selectByExample(example);
		if(userList.size() > 0)
			return userList.get(0);
		else 
		return null;
	}

	public int selectPages() {
		UserExample example = new UserExample();
		
		int pages = userMapper.selectByExample(example).size();
		if(maxResult == 0) {//防止出现java.lang.ArithmeticException: / by zero
			return 0;
		}
		if (pages % maxResult != 0) {
			pages = pages / maxResult + 1;
		} else {
			pages = pages / maxResult;
		}
		return pages;
	}

	public User selectLogByTelephone(String telephone) {
		UserExample example = new UserExample();
		example.createCriteria().andPhoneEqualTo(telephone);
		List<User> userList = userMapper.selectByExample(example);
		if(userList.size() > 0)
			return userList.get(0);
		else return null;
	}

	public User UserLogin(String username, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		example.createCriteria().andPasswordEqualTo(password);
		List<User> userList = userMapper.selectByExample(example);
		if(userList.size() > 0)
			return userList.get(0);
		else return null;
	}


	

}
