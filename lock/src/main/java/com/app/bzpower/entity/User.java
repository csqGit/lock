package com.app.bzpower.entity;
/**
 * 用户表
 */
public class User {
	private Integer id;
	private String userName;//用户名
	private String realName;//真实姓名
	private String telephone;//电话
	private Company companyId;//所属公司
	private Integer type;//类型 1 2 3
	private String jobNumber;//员工工号
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Company getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + userName + ", realName=" + realName + ", telephone=" + telephone
				+ ", company=" + companyId + ", type=" + type + ", jobNumber=" + jobNumber + "]";
	}

	
}
