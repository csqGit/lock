package com.app.bzpower.entity;

/**
 * 日志表
 *
 */
public class Log {

	private Integer id;
	private String company;// 所属公司
	private String lockName;// 锁编号
	private String mac;// 锁的mac地址
	private String did;// 锁编号
	private String transformersub;// 变电站
	private String classes;// 运检班组
	private String requestTime;// 请求开锁时间
	private String openTime;// 开锁时间
	private String closeTime;// 关锁时间
	private int actionD;// 审核状态
	private int onOff;// 开关状态
	private int status;// 锁状态
	private String examinePerson;// 审核人

	public Log() {

	}

	public Log(String lockName, String mac, String did, String openTime, String closeTime, int actionD) {
		super();
		this.lockName = lockName;
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
		if (company == null || "".equals(company)) {
			company = "西安博展电力技术有限公司";
		}
		this.company = company;
	}

	public String getLockName() {
		return lockName;
	}

	public void setLockName(String lockName) {
		this.lockName = lockName;
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

	public String getTransformersub() {
		return transformersub;
	}

	public void setTransformersub(String transformersub) {
		this.transformersub = transformersub;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getExaminePerson() {
		return examinePerson;
	}

	public void setExaminePerson(String examinePerson) {
		this.examinePerson = examinePerson;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", company=" + company + ", lockName=" + lockName + ", mac=" + mac + ", did=" + did
				+ ", transformersub=" + transformersub + ", classes=" + classes + ", requestTime=" + requestTime
				+ ", openTime=" + openTime + ", closeTime=" + closeTime + ", actionD=" + actionD + ", onOff=" + onOff
				+ ", status=" + status + ", examinePerson=" + examinePerson + "]";
	}

}
