package com.app.bzpower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.bzpower.entity.Log;
import com.app.bzpower.entity.RequestResult;
import com.app.bzpower.service.LogService;

/**
 * 日志信息
 * @author Admin
 *
 */
@Controller
public class LogController {
	
	@Autowired
	private LogService logService;
	/*
	 * 存储用管理员开锁信息
	 * 100 开锁失败
	 * 200 开锁成功
	 * 300 拒绝成功
	 * 400 拒绝失败
	 * 
	 * request 0表示未审核  1表示已审核
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("saveLog")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult saveLog( String userName, String mac, 
								String did, String openDate, String closeDate, String action, String request) {
		RequestResult rr = new RequestResult();;
		try {
			if(action.equals(true)) {
				rr.setCode(100);
			}else {
				rr.setCode(300);
			}
			action = (action.equals("true")) ? "同意开锁" :"不同意开锁";
			
//			logService.saveLog(mac, did, openDate, action, request);
			rr.setResult("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(100);
			rr.setResult("保存失败");
		}
		return rr;
	}

	
	/*
	 * 用户请求开锁信息
	 */
	@RequestMapping("saveLog2")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult saveLog2(String mac, String did, String actionD, String requestTime, String request) {
		RequestResult rr = new RequestResult();;
		try {
			if(actionD.equals("true")) {
				rr.setCode(100);
			}else {
				rr.setCode(300);
			}
			actionD = (actionD.equals("true")) ? "请求开锁" :"请求关锁";
			
//			logService.saveLog(mac, did, requestTime, actionD, request);
			rr.setResult("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(100);
			rr.setResult("保存失败");
		}
		return rr;
	}
	
	@RequestMapping("getLog")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult getLog(String request) {
		RequestResult rr = new RequestResult();;
		try {
			List<Log> logList = logService.getLog(request);
			rr.setCode(100);
			rr.setResult(logList);
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(200);
			rr.setResult("查询失败");
		}
		return rr;
	}
	
	/*
	 * 保存用户请求开锁信息
	 */
	
	@RequestMapping("insertUserRequestOpenLock")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult insertUserRequestOpenLock(String userName, String did, String mac, String requestTime,
			String actionD, String request) {
		RequestResult rr = new RequestResult();;
		try {
			logService.insertUserRequestOpenLock(userName, did, mac, requestTime, actionD, request);
			rr.setCode(100);
			rr.setResult("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(200);
			rr.setResult("保存失败");
		}
		
		return rr;
	}
	
	/*
	 * 更新开锁申请审核信息
	 */
	@RequestMapping("updateOpenLockInfo")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult updateOpenLockInfo(int id, String request,String openTime, String actionD) {
		RequestResult rr = new RequestResult();;
		try {
			logService.updateOpenLockInfo(id, request, openTime, actionD);
			rr.setCode(100);
			rr.setResult("开锁成功");
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(200);
			rr.setResult("开锁失败");
		}
		return rr;
	}
}
