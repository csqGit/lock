package com.app.bzpower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bzpower.dao.CompanyDao;
import com.app.bzpower.entity.Company;
import com.app.bzpower.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;

	public List<Company> selectCompany() {
		List<Company> companyList = null;
		try {
			companyList = companyDao.selectCompany();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyList;
	}

	public Company selectCompanyByName(String companyName) {
		Company company = null;
		try {
			company = companyDao.selectCompanyByName(companyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return company;
	}

	public void insertCompany(Company company) {
		try {
			companyDao.insertCompany(company);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void deleteCompanyByName(String companyName) {
		try {
			companyDao.deleteCompanyByName(companyName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
