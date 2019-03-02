package com.app.bzpower.entity;

import java.util.Date;

/**
 * 日志表
 *
 */
public class Log {

	private Integer id;
	private String company;//所属公司
	private String userId;//用户的编号
	private String mac;//锁的mac地址
	private String did;//锁编号
	private String requestTime;//请求开锁时间
	private String openTime;//开锁时间
	private String closeTime;//关锁时间
	private String actionD;//开箱动作
	public Log() {
		
	}
	public Log(String userId, String mac, String did, String openTime, String closeTime, String actionD) {
		super();
		this.userId = userId;
		this.mac = mac;
		this.did = did;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.actionD = actionD;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	
	
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getActionD() {
		return actionD;
	}
	public void setActionD(String actionD) {
		this.actionD = actionD;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", company=" + company + ", userId=" + userId + ", mac=" + mac + ", did=" + did
				+ ", openTime=" + openTime + ", closeTime=" + closeTime + ", action=" + actionD + "]";
	}
	
	
	
}
