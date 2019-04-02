package com.app.bzpower.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.Log;
import com.app.bzpower.entity.PageData;

public interface LogService {
	/**
	 * 保存请求设备信息
	 */

	void  insertUserRequestOpenLock(Log log);
	
	
	/**
	 * 修改开锁时间
	 */
	void updataLog(@Param("openTime") String openTime);
	
	/**
	 * 查询请求信息
	 */
	List<Log> getLog(int status, int actionD);
	
	/**
	 * 分页查询所有日志
	 * @param page
	 * @return
	 */
	List<Log> selectLogList(PageData pageData);
	
	/**
	 * 根据开锁时间来查询锁是否以开
	 * @param openTime
	 * @return
	 */
	Log selectLogOpenTime (String openTime);
	
	/**
	 * 查询当前页数
	 * @return
	 */
	int selectPages();
	
	/**
	 * 查询设备信息根据id
	 */
	Log getLogById(int id);
	
	/**
	 * 更新开锁申请信息
	 */
//	void updateOpenLockInfo(int id, String openTime, int on_off, int actionD, int status);
	void updateOpenLockInfo(Log log);
	
	/**
	 * 根据ID删除日志信息
	 * @param id
	 */
	void deleteLog(int id);
	
}
