package com.app.bzpower.service;

import java.util.List;

import com.app.bzpower.entity.LockInfo;

public interface LockService {
	

	/**
	 * 查询所有锁信息
	 * @return
	 */
	List<LockInfo> selectLockList();
	
	/**
	 * 根据锁名称查询锁信息
	 * @param lockName
	 * @return
	 */
	LockInfo selectLockByName(String lockName);
	
	
	/**
	 * 新增锁信息
	 * @param lock
	 */
	void insertLock(LockInfo lockInfo);
	
	/**
	 * 删除锁根据锁名称
	 */
	void deleteLockByName(String lockName);
	
}
