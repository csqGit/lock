package com.app.bzpower.service;

import java.util.List;

import com.app.bzpower.entity.Company;

public interface CompanyService {
	
	List<Company> selectCompany();
	
	Company selectCompanyByName(String companyName);
	
	void insertCompany(Company company);
	
	void deleteCompanyByName(String companyName);

}
