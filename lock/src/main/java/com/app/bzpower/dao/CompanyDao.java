package com.app.bzpower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.Company;

public interface CompanyDao {

	/**
	 * 查询所有公司名称
	 * @return
	 */
	List<Company> selectCompany();
	
	
	/**
	 * 根据公司名字查询
	 * @param companyName
	 * @return
	 */
	Company selectCompanyByName(@Param("companyName") String companyName);
	
	
	/**
	 * 添加公司名称
	 * @param company
	 */
	void insertCompany(Company company);
	
	
	/**
	 * 删除公司名称
	 * @param companyName
	 */
	void deleteCompanyByName(@Param("companyName") String companyName);
}
