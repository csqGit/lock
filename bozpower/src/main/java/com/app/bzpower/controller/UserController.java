package com.app.bzpower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.bzpower.entity.Company;
import com.app.bzpower.entity.RequestResult;
import com.app.bzpower.entity.Admin;
import com.app.bzpower.service.AdminService;

/**
 * 用户
 */
@Controller("appController")
@RequestMapping("/appUser")
public class UserController {
	
	@Autowired
	private AdminService adminService;


	@SuppressWarnings("rawtypes")
	@RequestMapping("/selectUserBytelePhone")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult selectUserBytelePhone(String phone) {
		RequestResult result = new RequestResult();
		try {
			Admin user = adminService.selectLogByTelephone(phone);
			if(user != null) {
				result.setCode(100);
				return result;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(0);
			return result;
		}
		return result;
	}
	
	
}
