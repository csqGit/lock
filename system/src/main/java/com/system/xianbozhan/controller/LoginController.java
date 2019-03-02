package com.system.xianbozhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.xianbozhan.entity.RequestResult;

@Controller
public class LoginController{
	
	@RequestMapping("/login")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult login(String un) {
		System.out.println(un);
		if("zs".equals(un)) {
		    RequestResult rr = new RequestResult();
		    rr.setCode(200);
			return rr;
		}else {
			RequestResult rr = new RequestResult();
		    rr.setCode(100);
			return rr;
		}
	}

}
