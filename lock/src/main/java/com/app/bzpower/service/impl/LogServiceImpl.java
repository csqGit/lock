package com.app.bzpower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bzpower.dao.LogDao;
import com.app.bzpower.entity.Log;
import com.app.bzpower.service.LogService;

@Service
public class LogServiceImpl implements LogService {
	
	@Autowired
	private LogDao logDao;

	

	public void updataLog(String openTime) {
		logDao.updataLog(openTime);

	}

	public List<Log> getLog(int status, int actionD) {
		return logDao.getLog(status, actionD);
	}


	public void insertUserRequestOpenLock(String userName, String did, String mac, 
			String requestTime, int on_off, int actionD, int status) {
//		logDao.insertUserRequestOpenLock(userName, did, mac, requestTime, on_off, actionD, status);
		
	}

	public Log getLogById(int id) {
		// TODO Auto-generated method stub
		return logDao.getLogById(id);
	}

	public void updateOpenLockInfo(int id, String openTime, int on_off, int actionD, int status) {
		logDao.updateOpenLockInfo(id, openTime, on_off, actionD, status);
		
	}

	public void insertUserRequestOpenLock(Log log) {
		// TODO Auto-generated method stub
		logDao.insertUserRequestOpenLock(log);
	}

}
