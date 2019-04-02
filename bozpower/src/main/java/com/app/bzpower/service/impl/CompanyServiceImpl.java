package com.app.bzpower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bzpower.dao.CompanyDao;
import com.app.bzpower.entity.Company;
import com.app.bzpower.entity.PageData;
import com.app.bzpower.service.CompanyService;
import com.app.bzpower.util.DefaultUtils;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	private int maxResult = DefaultUtils.maxResult;
	
	public List<Company> selectCompany(PageData pageData) {
		int page = pageData.getPage();
		if(page == 0) 
			maxResult = 0;
		page = (page - 1) * maxResult;
		List<Company> companyList = null;
		try {
			companyList = companyDao.selectCompany(page, maxResult);
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

	public Company selectCompanyById(Integer id) {
		
		return companyDao.selectCompanyById(id);
	}


	public int selectPages() {
		int pages = companyDao.selectCompanyCount();
		if(maxResult != 0) {
			if (pages % maxResult != 0) {
				pages = pages / maxResult + 1;
			} else {
				pages = pages / maxResult;
			}
		}else {
			pages = pages / 10;
		}
		
		return pages;
	}

	public void deleteCompanyById(int id) {
		try {
			companyDao.deleteCompanyById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public void updateCompany(Company company) {
		try {
			companyDao.updateCompany(company);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
