package com.app.bzpower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.Log;
import com.app.bzpower.entity.RequestResult;

public interface LogDao {
	/*
	 * 保存请求设备信息
	 */
	void insertUserRequestOpenLock(@Param("userName")String userName, @Param("did")String did, @Param("mac") String mac, @Param("requestTime")
	String requestTime, @Param("actionD")String actionD, @Param("request") String request);
	
	
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
	void updateOpenLockInfo(@Param("id") int id,@Param("request") String request,
			@Param("openTime")String openTime, @Param("actionD") String actionD);
	
}
