package com.app.bzpower.entity;


/**
 * 日志表
 *
 */
public class Log {

	private Integer id;
	private String company;//所属公司
	private String userName;//用户的编号
	private String mac;//锁的mac地址
	private String did;//锁编号
	private String requestTime;//请求开锁时间
	private String openTime;//开锁时间
	private String closeTime;//关锁时间
	private int actionD;//审核状态
	private int onOff;//开关状态
	private int status;//锁状态
	public Log() {
		
	}
	public Log(String userName, String mac, String did, String openTime, String closeTime, int actionD) {
		super();
		this.userName = userName;
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
		if(company == null || "".equals(company)) {
			company = "西安博展电力技术有限公司";
		}
		this.company = company;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public int getActionD() {
		return actionD;
	}
	public void setActionD(int actionD) {
		this.actionD = actionD;
	}
	
	public int getOnOff() {
		return onOff;
	}
	public void setOnOff(int onOff) {
		this.onOff = onOff;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", company=" + company + ", userName=" + userName + ", mac=" + mac + ", did=" + did
				+ ", requestTime=" + requestTime + ", openTime=" + openTime + ", closeTime=" + closeTime + ", actionD="
				+ actionD + ", request=" + onOff + ", status=" + status + "]";
	}
	
	
	
}
