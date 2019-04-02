package com.app.bzpower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.bzpower.entity.Company;
import com.app.bzpower.entity.RequestResult;
import com.app.bzpower.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("selectCompany")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult selectCompany() {
		RequestResult rr = new RequestResult();
		try {
			rr.setCode(100);
			rr.setResult(companyService.selectCompany());
			return rr;
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(200);
			return rr;
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("selectCompanyByName")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult selectCompanyByName(String companyName) {
		RequestResult rr = new RequestResult();
		try {
			rr.setCode(100);
			rr.setResult(companyService.selectCompanyByName(companyName));
			return rr;
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(200);
			rr.setResult("该公司不存在");
			return rr;
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("insertCompany")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult insertCompany(Company company) {
		RequestResult rr = new RequestResult();
		try {
			rr.setCode(100);
			companyService.insertCompany(company);
			rr.setResult("注册公司成功");
			return rr;
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(200);
			rr.setResult("注册公司失败");
			return rr;
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("deleteCompany")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public RequestResult deleteCompany(String companyName) {
		RequestResult rr = new RequestResult();
		try {
			companyService.deleteCompanyByName(companyName);
			rr.setCode(100);
			rr.setResult("删除公司成功");
			return rr;
		} catch (Exception e) {
			e.printStackTrace();
			rr.setCode(200);
			rr.setResult("删除公司失败");
			return rr;
		}
	}
}
