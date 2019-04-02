package com.app.bzpower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.LockInfo;

public interface LockDao {

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
	LockInfo selectLockByName(@Param("lockName") String lockName);
	
	
	/**
	 * 新增锁信息
	 * @param lock
	 */
	void insertLock(LockInfo lockInfo);
	
	/**
	 * 删除锁根据锁名称
	 */
	void deleteLockByName(@Param("lockName") String lockName);
	
	
	
//	void insertLock(Lock lock);
}
