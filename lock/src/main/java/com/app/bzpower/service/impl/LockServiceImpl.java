package com.app.bzpower.service.impl;

import java.util.List;
import java.util.concurrent.locks.Lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bzpower.dao.LockDao;
import com.app.bzpower.entity.LockInfo;
import com.app.bzpower.service.LockService;

@Service
public class LockServiceImpl implements LockService {

	@Autowired
	private LockDao lockDao;
	
	public List<LockInfo> selectLockList() {
		// TODO Auto-generated method stub
		return lockDao.selectLockList();
	}

	public LockInfo selectLockByName(String lockName) {
		// TODO Auto-generated method stub
		return lockDao.selectLockByName(lockName);
	}

	public void insertLock(LockInfo lockInfo) {
		// TODO Auto-generated method stub
		try {
			lockDao.insertLock(lockInfo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void deleteLockByName(String lockName) {
		// TODO Auto-generated method stub
		try {
			lockDao.deleteLockByName(lockName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

}
