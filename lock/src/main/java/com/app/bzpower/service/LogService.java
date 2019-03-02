package com.app.bzpower.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.Log;

public interface LogService {
	/*
	 * 保存请求设备信息
	 */
	void insertUserRequestOpenLock(String userName, String did, String mac, String requestTime,
			String actionD, String request);
	
	
	/*
	 * 修改开锁时间
	 */
	void updataLog(@Param("openTime") String openTime);
	
	/*
	 * 查询请求信息
	 */
	List<Log> getLog(@Param("request") String request);
	
	/*
	 * 更新开锁申请信息
	 */
	void updateOpenLockInfo(int id,String request,String openTime,  String actionD);
	
}
