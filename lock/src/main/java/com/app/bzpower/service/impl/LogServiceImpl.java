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

	public List<Log> getLog(String request) {
		return logDao.getLog(request);
	}

	public void updateOpenLockInfo(int id, String request, String openTime, String actionD) {
		logDao.updateOpenLockInfo(id, request, openTime, actionD);
		
	}

	public void insertUserRequestOpenLock(String userName, String did, String mac, String requestTime, String actionD,
			String request) {
		logDao.insertUserRequestOpenLock(userName, did, mac, requestTime, actionD, request);
		
	}

}
