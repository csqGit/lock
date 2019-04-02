package com.app.bzpower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.bzpower.entity.Company;
import com.app.bzpower.entity.RequestResult;
import com.app.bzpower.entity.User;
import com.app.bzpower.service.UserService;

/**
 * 用户
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	/*
	 * 用户注册
	 */
	@RequestMapping("userRegister")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult  userRegister(String telephone, String userName, 
			String realName, String company, String password) {
		Company cp = new Company();
		cp.setId(2);
		cp.setCompanyName(company);
		RequestResult result = new RequestResult();
		try {
			userService.userRegister(telephone, userName, realName, cp, password);
			result.setCode(001);
			result.setResult("注册成功");
		} catch (Exception e) {
			result.setCode(002);
			result.setResult("注册失败");
			e.printStackTrace();
		}
		return result;
	}
	
	
	/*
	 * 用户登录
	 */
	@RequestMapping("/userLogin")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult userLogin(String phone, String password) {
		System.out.println(phone + "---" + password);
		User user = userService.userLogin(phone, password);
		RequestResult result = new RequestResult();
		if(user != null) {
			result.setCode(001);
			result.setResult("登录成功");
			return result;
		}else {
			result.setCode(002);
			result.setResult("登录失败");
			return result;
		}
	}
	

}
