package com.app.bzpower.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bzpower.dao.LogDao;
import com.app.bzpower.entity.Log;
import com.app.bzpower.entity.PageData;
import com.app.bzpower.service.LogService;
import com.app.bzpower.util.DefaultUtils;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao logDao;

	private int maxResult = DefaultUtils.maxResult;

	public void updataLog(String openTime) {
		logDao.updataLog(openTime);
	}

	public List<Log> getLog(int status, int actionD) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDate = df.format(new Date());
		String[] strArray = currentDate.split(" ");
		String str = strArray[0];
		return logDao.getLog(status, actionD, str);
	}

	public Log getLogById(int id) {
		// TODO Auto-generated method stub
		return logDao.getLogById(id);
	}

	public void updateOpenLockInfo(int id, String openTime, int on_off, int actionD, int status) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDate = df.format(new Date());
		String[] strArray = currentDate.split(" ");
		String str = strArray[0];
//		logDao.updateOpenLockInfo(id, openTime, on_off, actionD, status);

	}
	
	public void updateOpenLockInfo(Log log) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDate = df.format(new Date());
		String[] strArray = currentDate.split(" ");
		String str = strArray[0];
		logDao.updateOpenLockInfo(log);
	}

	public void insertUserRequestOpenLock(Log log) {
		synchronized (log) {
			String requestTime = log.getRequestTime();
			List<Log> l = logDao.selectLogByRequestTime(requestTime);
			String closeTime = log.getCloseTime();
			String did = log.getDid();
			Log ll = logDao.selectLogByCloseTime(closeTime, did);
			if(ll != null){
				return ;
			}
			if(l.size() > 0)//如果该条数据存在，则不再保存
				return ;
			else 
	 			logDao.insertUserRequestOpenLock(log);
		}
	}

	public String dateFormat(String date) {
		String[] strArray = date.split(" ");

		return strArray[0];
	}

	public List<Log> selectLogList(PageData pageData) {
		int page = pageData.getPage();			
		if (page == 0) {// 手机端全部查询
			maxResult = 0;
		} 
		int startPage = (page - 1) * maxResult;
		List<Log> logList = null;
		try {
			logList = logDao.selectLogList(startPage, maxResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logList;
	}

	public int selectPages() {
		int pages = logDao.selectLogCount();
		if(maxResult == 0) {//防止出现java.lang.ArithmeticException: / by zero
			return 0;
		}
		if (pages % maxResult != 0) {
			pages = pages / maxResult + 1;
		} else {
			pages = pages / maxResult;
		}
		return pages;
	}

	public void deleteLog(int id) {
		try {
			logDao.deleteLog(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e.getLocalizedMessage();
		}
		
	}

	public Log selectLogOpenTime(String openTime) {
		
		return logDao.selectLogOpenTime(openTime);
	}

}
