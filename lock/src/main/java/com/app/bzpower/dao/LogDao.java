package com.app.bzpower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.Log;
import com.app.bzpower.entity.RequestResult;

public interface LogDao {
	/*
	 * 保存请求设备信息
	 */
//	void insertUserRequestOpenLock(@Param("userName")String userName, @Param("did")String did, @Param("mac") String mac, @Param("requestTime")
//	String requestTime, @Param("on_off")int on_off, @Param("actionD") int actionD, @Param("status") int status);
	
	void insertUserRequestOpenLock(Log log);
	
	/*
	 * 修改开锁时间
	 */
	void updataLog(@Param("openTime") String openTime);
	
	/*
	 * 查询请求信息
	 */
	List<Log> getLog(@Param("status") int status, @Param("actionD") int actionD);
	
	Log getLogById(@Param("id") int id);
	
	
	/*
	 * 更新开锁申请信息
	 */
	void updateOpenLockInfo(@Param("id") int id,@Param("openTime") String openTime,
			@Param("on_off")int on_off, @Param("actionD") int actionD, @Param("status") int status);
	
}
