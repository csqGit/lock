package com.app.bzpower.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.Log;

public interface LogService {
	/*
	 * 保存请求设备信息
	 */
	void insertUserRequestOpenLock(String userName, String did, String mac, String requestTime,
			int on_off, int actionD, int status);
	
	void insertUserRequestOpenLock(Log log);
	
	
	/*
	 * 修改开锁时间
	 */
	void updataLog(@Param("openTime") String openTime);
	
	/*
	 * 查询请求信息
	 */
	List<Log> getLog(int status, int actionD);
	
	/*
	 * 查询设备信息根据id
	 */
	Log getLogById(int id);
	
	/*
	 * 更新开锁申请信息
	 */
	void updateOpenLockInfo(int id, String openTime, int on_off, int actionD, int status);
	
}
