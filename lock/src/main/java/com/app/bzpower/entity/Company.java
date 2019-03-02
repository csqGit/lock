package com.app.bzpower.entity;
/**
 * 公司名称
 */
public class Company {
	private Integer id;
	
	private String company;//公司名称
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", company=" + company + "]";
	}
	
}
