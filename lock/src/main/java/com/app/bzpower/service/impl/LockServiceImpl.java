package com.app.bzpower.service.impl;

import java.util.List;

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

}
