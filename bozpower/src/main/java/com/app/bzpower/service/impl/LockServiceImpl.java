package com.app.bzpower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bzpower.dao.LockDao;
import com.app.bzpower.entity.LockInfo;
import com.app.bzpower.entity.PageData;
import com.app.bzpower.service.LockService;
import com.app.bzpower.util.DefaultUtils;

@Service
public class LockServiceImpl implements LockService {

	@Autowired
	private LockDao lockDao;
	private int maxResult = DefaultUtils.maxResult;
	
	public List<LockInfo> selectLockList(PageData pageData) {
		int page = pageData.getPage();			
		if (page == 0) {// 手机端全部查询
			maxResult = 0;
		} 
		int startPage = (page - 1) * maxResult;
		List<LockInfo> lockList = null;
		try {
			lockList = lockDao.selectLockList(startPage, maxResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lockList;
	}

	public LockInfo selectLockByName(String lockName) {
		return lockDao.selectLockByName(lockName);
	}
	
	
	
	public int selectPages() {
		int pages = lockDao.selectLockCount();
		if(maxResult == 0) {//防止出现java.lang.ArithmeticException: / by zero
			return 0;
		}
		if(pages % maxResult != 0) {
			pages = pages / maxResult + 1;
		}else {
			pages = pages / maxResult;
		}
		return pages;
	}

	public void insertLock(LockInfo lockInfo) {
		String lockName = autoLockName();
		lockInfo.setLockName(lockName);
		lockDao.insertLock(lockInfo);
		
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

	public LockInfo selectLockByDid(String did) {
		// TODO Auto-generated method stub
		return lockDao.selectLockByDid(did);
	}

	
	/**
	 * pc端更新
	 */
	public void updateLock(LockInfo lockInfo) {
		lockDao.updateLock(lockInfo);
		
	}

	public LockInfo selectLockById(Integer id) {
		// TODO Auto-generated method stub
		return lockDao.selectLockById(id);
	}

	public void deleteLockById(Integer id) {
		
		lockDao.deleteLockById(id);
	}
	
	private String autoLockName() {
		String newLockName = "";
		List<LockInfo> list = lockDao.selectLockList(0,0);
		int size = list.size();
		if(size > 0) {
			LockInfo lock = (LockInfo) list.get(size - 1);
			String preLockName = lock.getLockName();
			int len = preLockName.length();
			String val = Integer.parseInt(preLockName) + 1 + "";
			for(; newLockName.length() < len;) {
				for(; newLockName.length() < len - val.length();) {
					newLockName += "0";
				}
				newLockName += val;
			}
		}else {
			newLockName = "0001";
		}
		return newLockName;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		String preLockName = "0009";
		String newLockName = "";
		int len = preLockName.length();
		String val = Integer.parseInt(preLockName) + 1 + "";
		for(; newLockName.length() < len - val.length();) {
			System.out.println(newLockName);
			newLockName += "0";
		}
		newLockName += val;
		
	}

	



}
