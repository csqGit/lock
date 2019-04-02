package com.app.bzpower.controller;

import java.util.List;
import java.util.concurrent.locks.Lock;

import org.junit.Test;
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

	
	@RequestMapping("getLog")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult getLog(Integer status, Integer actionD) {
		RequestResult rr = new RequestResult();;
		try {
			List<Log> logList = logService.getLog(status, actionD);
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
			int on_off, int actionD, int status) {
		RequestResult rr = new RequestResult();;
		try {
			Log log = new Log();
			log.setCompany("西安博展电力技术有限公司");
			log.setUserName("测试");
			log.setMac(mac);
			log.setDid(did);
			log.setRequestTime(requestTime);
			log.setOpenTime(null);
			log.setCloseTime(null);
			log.setActionD(actionD);
			log.setStatus(status);
			log.setOnOff(on_off);
//			logService.insertUserRequestOpenLock(userName, did, mac, requestTime, on_off, actionD, status);
			logService.insertUserRequestOpenLock(log);
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
	public RequestResult updateOpenLockInfo(int id,String openTime, int on_off, int actionD, int status) {
		RequestResult rr = new RequestResult();;
		try {
			logService.updateOpenLockInfo(id, openTime, on_off, actionD, status);
			rr.setCode(100);
			rr.setResult("修改信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(200);
			rr.setResult("修改信息失败");
		}
		return rr;
	}
	
	@RequestMapping("getLogById")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Log getLogById(Integer id) {
		Log log = null;
		try {
			log = logService.getLogById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return log;
	}
	
	/**
	 * 获取动态码
	 */
	@RequestMapping("getDtm")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult getDtm(String yzm) {
		RequestResult rr = new RequestResult();
		if(yzm != null || !"".equals(yzm)) {
			rr.setCode(100);
			rr.setResult(autoDtm(yzm));
		}else {
			rr.setCode(200);
			rr.setResult("");
		}
		return rr;
	}
	
	
	public String autoDtm(String yzm) {
		int [] num = new int[4];
		String returnResult = "";
		for(int i = 0; i < yzm.length(); i ++) {
			String str = yzm.substring(i, i + 1);
			num[i] = Integer.parseInt(str);
			System.out.println(i + " - " + num[i] + " - ");
		}
		for(int j = 0; j < yzm.length(); j ++) {
			//定义算法方程为y = x^2 + 2*x + 1
			int result = num[j] * num[j] + 2 * num[j] + 1;
			if(result > 10) {//如果该数大于10，则取个位数
				result = result %= 10 ;
				System.out.println("result = " + result);
			}
			returnResult += String.valueOf(result);
			System.out.println("returnResult = " + returnResult);
		}
		System.out.println(returnResult);
		return returnResult;
	}
	
	
}
