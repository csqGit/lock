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
	List<Log> getLog(@Param("status") int status, @Param("actionD") int actionD, @Param("requestTime") String requestTime);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	Log getLogById(@Param("id") int id);
	
	/**
	 * 根据设备char字段判断是否是同一条数据的不同设备新增
	 * @param closeTime
	 * @return
	 */
	Log selectLogByCloseTime(@Param("closeTime") String closeTime, @Param("did") String did);
	
	/**
	 * 分页查询
	 * @param page
	 * @param resultPage
	 * @return
	 */
	List<Log> selectLogList(@Param("page")int page, @Param("resultPage")int resultPage);

	
	/**
	 * 查询当天请求信息
	 * @param requestTime
	 * @return
	 */
	List<Log> selectLogByRequestTime(@Param("requestTime") String requestTime);
	
	/**
	 * 根据开锁时间来查询锁是否以开
	 * @param openTime
	 * @return
	 */
	Log selectLogOpenTime (@Param("openTime") String openTime);
	/**
	 * 查询所有日志条数
	 * @return
	 */
	int selectLogCount();
	
	/*
	 * 更新开锁申请信息
	 */
//	void updateOpenLockInfo(@Param("id") int id,@Param("openTime") String openTime,
//			@Param("on_off")int on_off, @Param("actionD") int actionD, @Param("status") int status);
	void updateOpenLockInfo(Log log);
	/**
	 * 根据ID删除日志信息
	 * @param id
	 */
	void deleteLog(int id);
	
}
