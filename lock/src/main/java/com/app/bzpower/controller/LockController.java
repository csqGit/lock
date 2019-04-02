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
	 * 得到设备名称列表
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
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

	/**
	 * 根据锁名称查询锁信息
	 * 
	 * @param lockName
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/selectLockByName")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult selectLockByName(String lockName) {
		RequestResult rr = new RequestResult();

		try {
			if (lockName != null || !"".equals(lockName)) {
				rr.setCode(100);
				LockInfo lock = lockService.selectLockByName(lockName);
				if (lock != null)
					rr.setResult(lock);
				else
					rr.setResult("该锁不存在");
				return rr;
			} else {
				rr.setCode(300);
				rr.setResult("请输入锁名称");
				return rr;
			}
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(200);
			rr.setResult("请重新查询");
			return rr;
		}

	}

	/**
	 * 添加锁
	 * 
	 * @param lock
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/insertLock")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult insertLock(LockInfo lockInfo) {
		RequestResult rr = new RequestResult();
		try {
			if (lockInfo != null) {
				lockService.insertLock(lockInfo);
				rr.setCode(100);
				rr.setResult("添加成功");
				return rr;
			} else {
				rr.setCode(300);
				rr.setResult("请正确填写信息");
				return rr;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rr.setCode(200);
			rr.setResult("添加失败");
			return rr;
		}
	}

	/**
	 * 删除锁
	 * 
	 * @param lockName
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/deleteLock")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult deleteLock(String lockName) {
		RequestResult rr = new RequestResult();
		try {
			if (lockName != null || !"".equals(lockName)) {
				lockService.deleteLockByName(lockName);
				rr.setCode(100);
				rr.setResult("删除成功");
				return rr;
			} else {
				rr.setCode(300);
				rr.setResult("请正确填写锁名称");
				return rr;
			}
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(200);
			rr.setResult("删除失败");
			return rr;
		}
	}

}
