package com.app.bzpower.entity;
/**
 * 智能锁
 */
public class LockInfo {

	private Integer id;
	private String did;//箱体编号
	private String mac;//箱体名称
	private String passcode;//
	private String lockName;//锁名称，系统自动生成
	private String companyName;//所属公司
	private String transformerSubName;//变电站
	private String classes;//所属班组
	
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
	
	
	public String getLockName() {
		return lockName;
	}
	public void setLockName(String lockName) {
		this.lockName = lockName;
	}
	
	
	public String getTransformerSubName() {
		return transformerSubName;
	}
	public void setTransformerSubName(String transformerSubName) {
		this.transformerSubName = transformerSubName;
	}
	
	
	
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	@Override
	public String toString() {
		return "LockInfo [id=" + id + ", did=" + did + ", mac=" + mac + ", lockName=" + lockName + ", companyName="
				+ companyName + ", transformerSubName=" + transformerSubName + ", classes=" + classes + "]";
	}
	
	
	
}
