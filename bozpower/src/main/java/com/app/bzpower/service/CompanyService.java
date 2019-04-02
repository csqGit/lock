package com.app.bzpower.service;

import java.util.List;

import com.app.bzpower.entity.Company;
import com.app.bzpower.entity.PageData;

public interface CompanyService {
	
	List<Company> selectCompany(PageData pageData);
	
	Company selectCompanyByName(String companyName);
	
	Company selectCompanyById(Integer id);
	
	int selectPages();
	
	void insertCompany(Company company);
	
	void deleteCompanyByName(String companyName);

	void deleteCompanyById(int id);
	
	void updateCompany(Company company);
}
