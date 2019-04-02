package com.app.bzpower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.LockInfo;

public interface LockDao {

	/**
	 * 查询所有锁信息
	 * @return
	 */
	List<LockInfo> selectLockList(@Param("startPage") int startPage, @Param("maxResult") int maxResult);
	
	/**
	 * 根据锁名称查询锁信息
	 * @param lockName
	 * @return
	 */
	LockInfo selectLockByName(@Param("lockName") String lockName);
	
	LockInfo selectLockByDid(@Param("did") String did);
	
	LockInfo selectLockById(@Param("id") Integer id);
	
	int selectLockCount();
	/**
	 * 新增锁信息
	 * @param lock
	 */
	void insertLock(LockInfo lockInfo);
	
	/**
	 * 删除锁根据锁名称
	 */
	void deleteLockByName(@Param("lockName") String lockName);
	
	/**
	 * 删除锁根据锁名称
	 */
	void deleteLockById(@Param("id") Integer id);
	
	/**
	 * 更新锁信息
	 * @param lockInfo
	 */
	void updateLock(LockInfo lockInfo);
	
	
	
//	void insertLock(Lock lock);
}
