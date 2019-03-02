package com.app.bzpower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.bzpower.entity.LockInfo;
import com.app.bzpower.entity.RequestResult;
import com.app.bzpower.service.LockService;

/**
 * 锁
 */
@Controller
public class LockController {
	
	@Autowired
	private LockService lockService;
	
	/*
	 * 用户登录
	 */
	@RequestMapping("/saveLock")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult saveLock() {
		return new RequestResult();
	}
	
	/*
	 * 得到设备名称列表
	 */
	@RequestMapping("/selectLockList")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult selectLockList() {
		RequestResult rr = new RequestResult();
		try {
			List<LockInfo> lockList = lockService.selectLockList();
			System.out.println(lockList);
			rr.setCode(100);
			rr.setResult(lockList);
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(200);
			rr.setResult("没有设备");
		}
		return rr;
	}
	
	

}
