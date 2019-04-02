package com.app.bzpower.service;

import java.util.List;

import com.app.bzpower.entity.LockInfo;
import com.app.bzpower.entity.PageData;

public interface LockService {
	

	/**
	 * 查询所有锁信息
	 * @param i 
	 * @return
	 */
	List<LockInfo> selectLockList(PageData pageData);
	
	/**
	 * 根据锁名称查询锁信息
	 * @param lockName
	 * @return
	 */
	LockInfo selectLockByName(String lockName);
	
	/**
	 * 根据ID查询锁信息
	 * @param id
	 * @return
	 */
	LockInfo selectLockById(Integer id);
	
	/**
	 * 根据所did查询
	 * @param did
	 * @return
	 */
	LockInfo selectLockByDid(String did);
	
	/**
	 * 得到锁总数
	 * @return
	 */
	int selectPages();
	
	
	/**
	 * 新增锁信息
	 * @param lock
	 */
	void insertLock(LockInfo lockInfo);
	
	/**
	 * 删除锁根据锁名称
	 */
	void deleteLockByName(String lockName);
	
	/**
	 * 根据ID删除锁信息
	 * @param id
	 */
	void deleteLockById(Integer id);
	
	/**
	 * 根据ID修改锁信息
	 * @param lockInfo
	 */
	void updateLock(LockInfo lockInfo);
	
}
