package com.app.bzpower.entity;
/**
 * 公司名称
 */
public class Company {
	private Integer id;
	
	private String companyName;//公司名称
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", company=" + companyName + "]";
	}
	
}
