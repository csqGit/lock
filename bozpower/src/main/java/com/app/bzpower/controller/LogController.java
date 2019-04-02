package com.app.bzpower.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.bzpower.entity.LockInfo;
import com.app.bzpower.entity.Log;
import com.app.bzpower.entity.RequestResult;
import com.app.bzpower.service.LockService;
import com.app.bzpower.service.LogService;

/**
 * 日志信息
 * @author Admin
 *
 */
@Controller("appLogController")
@RequestMapping("/appLog")
public class LogController {
	
	@Autowired
	private LogService logService;
	@Autowired
	private LockService lockService;
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
	@RequestMapping("getLog")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult getLog(HttpServletResponse response, Integer status, Integer actionD) {
		RequestResult rr = new RequestResult();
//		response.setContentType("Content-Type=json;text/html;charset=utf-8;");
//		response.setContentType("json");
		try {
			List<Log> logList = logService.getLog(status, actionD);
			Set set = new  HashSet(); 
		    List newList = new  ArrayList(); 
		    if(logList.size() > 0) {
		    	for (Log cd:logList) {
				       if(set.add(cd)){
				           newList.add(cd);
				       }
				   }
					rr.setCode(100);
					rr.setResult(newList);
		    }else {
		    	rr.setCode(100);
		    	rr.setResult("空");
		    }
		    
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("insertUserRequestOpenLock")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult insertUserRequestOpenLock(String char1, String userName, String did, String mac, String requestTime,
			int on_off, int actionD, int status) {
		RequestResult rr = new RequestResult();
		try {
			
			LockInfo lock = lockService.selectLockByDid(did);
			if(lock == null) {
				return rr;
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String currentDate = df.format(new Date());
			Log log = new Log();
			log.setCompany("西安博展电力技术有限公司");
			log.setLockName(lock.getLockName());
			log.setTransformersub(lock.getTransformerSubName());
			log.setCloseTime(char1);
			log.setClasses(lock.getClasses());
			log.setMac(mac);
			log.setDid(did);
			log.setRequestTime(requestTime);
			log.setOpenTime(null);
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
	
//	/*
//	 * 更新开锁申请审核信息
//	 */
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@RequestMapping("updateOpenLockInfo")
//	@ResponseBody
//	@CrossOrigin(origins = "*", maxAge = 3600)
//	public RequestResult updateOpenLockInfo(int id,String openTime, int on_off, int actionD, int status) {
//		RequestResult rr = new RequestResult();;
//		try {
//			logService.updateOpenLockInfo(id, openTime, on_off, actionD, status);
//			rr.setCode(100);
//			rr.setResult("修改信息成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			rr.setCode(200);
//			rr.setResult("修改信息失败");
//		}
//		return rr;
//	}
	
	/*
//	 * 更新开锁申请审核信息
//	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("updateOpenLockInfo")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult updateOpenLockInfo(Log log) {
		RequestResult rr = new RequestResult();;
		try {
			//先查询是否已经开锁，如果已开锁，则不再更新数据，不再开锁
			if(log == null) {
				rr.setCode(300);
				rr.setResult("该请求不存在");
				return rr;
			}
			Log l = logService.getLogById(log.getId());
			if(l != null) {
				if(!"".equals(l.getId()) && l.getOpenTime() != null) {
					rr.setCode(400);
					rr.setResult("该请求已经同意");
					return rr;
				}
			}
			logService.updateOpenLockInfo(log);
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
	 * 根据设备did获取锁请求信息
	 * @param did
	 * @return
	 */
	@RequestMapping("selectLogByDid")
		@ResponseBody
		@CrossOrigin(origins = "*", maxAge = 3600)
	public Log selectLogByDid(String did) {
		Log log = new Log();
		return log;
	}
	
	/**
	 * 获取动态码
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
