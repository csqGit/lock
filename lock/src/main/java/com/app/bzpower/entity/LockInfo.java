package com.app.bzpower.entity;
/**
 * 智能锁
 */
public class LockInfo {

	private Integer id;
	private String did;//箱体编号
	private String mac;//箱体名称
	private String companyName;//所属公司
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "Lock [id=" + id + ", did=" + did + ", mac=" + mac + ", companyId=" + companyName + "]";
	}
	
	
}
