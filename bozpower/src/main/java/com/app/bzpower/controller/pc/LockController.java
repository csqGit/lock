package com.app.bzpower.controller.pc;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.bzpower.entity.LockInfo;
import com.app.bzpower.entity.PageData;
import com.app.bzpower.service.CompanyService;
import com.app.bzpower.service.LockService;
import com.app.bzpower.service.TransformerSubService;


/**
 * 锁
 */
@Controller(value = "/pcLockController")
@RequestMapping(value = "/pcLock")
public class LockController {

	@Autowired
	private LockService lockService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private TransformerSubService transformerSubService;

	
	
	@RequestMapping("/selectLockList")
	public ModelAndView selectLockList(HttpServletRequest request, PageData pageData) {
		ModelAndView mav = new ModelAndView();
		
		try {
			mav.addObject("lockList", lockService.selectLockList(pageData));
			PageData page = new PageData();
			List company = companyService.selectCompany(page);
			request.getSession().setAttribute("companyList", company);
			List trans = transformerSubService.selectTransformerSubList();
			request.getSession().setAttribute("transformerSubList", trans);
			int pages = lockService.selectPages();
			pageData.setPages(pages);
			mav.addObject("pageData", pageData);
			mav.setViewName("/jsp/lock_query_success.jsp");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			return mav;
		}
	}
	
	@RequestMapping("/selectLockById")
	public ModelAndView selectLockById(String param, Integer id) {
		ModelAndView mav = new ModelAndView();
		if(param != null && !"".equals(param)) {//表示为修改
			mav.setViewName("/jsp/lock_edit.jsp");
		}else {
			mav.setViewName("/jsp/lock_success.jsp");
		}
		try {
			mav.addObject("lock", lockService.selectLockById(id));
			PageData page = new PageData();
			mav.addObject("companyList", companyService.selectCompany(page));
			mav.addObject("transformerSubList", transformerSubService.selectTransformerSubList());
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			return mav;
		}
	}


	
	/**
	 * 根据锁名称查询锁信息
	 * 
	 * @param lockName
	 * @return
	 */
	@RequestMapping("/selectLockByDid")
	public ModelAndView selectLockByDid(String did) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/jsp/lock_edit");
		LockInfo lock = null;
		try {
			if (did != null || !"".equals(did)) {
			 lock = lockService.selectLockByDid(did);
			 mav.addObject("lock", lock);
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("lock", lock);
		}
		return mav;
	}
	
	/**
	 * 根据锁名称查询锁信息
	 * 
	 * @param lockName
	 * @return
	 */
	@RequestMapping("/selectLockByName")
	public ModelAndView selectLockByName(String lockName) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/jsp/lock_query_success.jsp");
		LockInfo lock = null;
		try {
			if (lockName != null && !"".equals(lockName)) {
			 lock = lockService.selectLockByName(lockName);
			 List<LockInfo> lockList = new ArrayList<LockInfo>();
			 lockList.add(lock);
			 mav.addObject("lockList", lockList);
			}else {
				PageData pageData = new PageData();
				mav.addObject("lockList", lockService.selectLockList(pageData));
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("lock", lock);
		}
		return mav;
	}
	
	@RequestMapping("/updateLock")
	public ModelAndView updateLock(LockInfo lockInfo) {
		ModelAndView mav = new ModelAndView();
		try {
			lockService.updateLock(lockInfo);
			mav.setViewName("/jsp/lock_edit_success.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * 新增锁信息
	 * @param lockInfo
	 * @return
	 */
	@RequestMapping("/insertLock")
	public ModelAndView insertLock(LockInfo lockInfo) {
		ModelAndView mav = new ModelAndView();
		try {
			lockService.insertLock(lockInfo);
			mav.setViewName("/jsp/lock_add_success.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/jsp/lock_add_fail.jsp");
		}
		return mav;
	}
	
	@RequestMapping("/deleteLockById")
	public String deleteLockById(Integer id) {
		ModelAndView mav = new ModelAndView();
		try {
			lockService.deleteLockById(id);
//			mav.setViewName("/jsp/lock_query_success.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/jsp/lock_delete_fail.jsp");
		}
		return "redirect:selectLockList?page=1";
	}
	
	

	
}
