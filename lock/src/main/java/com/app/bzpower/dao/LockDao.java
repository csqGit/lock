package com.app.bzpower.dao;

import java.util.List;

import com.app.bzpower.entity.LockInfo;

public interface LockDao {

	List<LockInfo> selectLockList();
	
//	void insertLock(Lock lock);
}
