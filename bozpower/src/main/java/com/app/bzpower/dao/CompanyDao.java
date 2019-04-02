package com.app.bzpower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.Company;

public interface CompanyDao {

	/**
	 * 查询所有公司名称
	 * @return
	 */
	List<Company> selectCompany(@Param("page") int page , @Param("maxResult") int maxResult);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Company selectCompanyById(@Param("id") Integer id);
	
	
	/**
	 * 根据公司名字查询
	 * @param companyName
	 * @return
	 */
	Company selectCompanyByName(@Param("companyName") String companyName);
	
	int selectCompanyCount();
	
	/**
	 * 添加公司名称
	 * @param company
	 */
	void insertCompany(Company company);
	
	
	/**
	 *更新公司信息
	 */
	void updateCompany(Company company);
	
	
	/**
	 * 删除公司名称
	 * @param companyName
	 */
	void deleteCompanyByName(@Param("companyName") String companyName);
	
	/**
	 * 
	 * @param id
	 */
	void deleteCompanyById(@Param("id") int id);
	
}
