package com.app.bzpower.controller.pc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.bzpower.entity.PageData;
import com.app.bzpower.entity.Admin;
import com.app.bzpower.service.AdminService;
import com.app.bzpower.service.CompanyService;
import com.app.bzpower.util.Md5Utils;

@Controller("pcAdminController")
@RequestMapping("/pcAdmin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CompanyService companyService;
	
	/**
	 * 用户登录
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin(HttpServletRequest request, Admin admin) {
		ModelAndView mav = new ModelAndView();
		Admin newAdmin = null;
		
		if(StringUtils.isEmpty(admin.getUsername()))  {
			request.setAttribute("err", "用户名输入为空");
			mav.setViewName("/admin/admin_login.jsp");
			return mav;
		}
		if(StringUtils.isEmpty(admin.getPassword()))  {
			request.setAttribute("err", "密码输入为空");
			mav.setViewName("/admin/admin_login.jsp");
			return mav;
		}
		
		List<Admin> existUser = adminService.selectAdminByName(admin.getUsername());
		if(existUser.size() == 0) {
			mav.setViewName("/admin/admin_login.jsp");
			request.setAttribute("err", "用户名输入错误");
			return mav;
		}else {
			String newPass = admin.getPassword();
			newPass = Md5Utils.encodingMd5(newPass);//密码加密
			newAdmin = adminService.AdminLogin(admin.getUsername(),newPass); 
			if(newAdmin != null) {//表示登录成功
				mav.setViewName("/admin/admin_login_success.jsp");
				mav.addObject("admin", newAdmin);
				System.out.println(newAdmin.getRealname());
				return mav;
			}else {
				mav.setViewName("/admin/admin_login.jsp");
				request.setAttribute("err", "密码输入错误");
				return mav;
			}
		}
	}
//	
	@RequestMapping("/selectAdminList")
	public ModelAndView selectAdminList(PageData pageData) {
		ModelAndView mav = new ModelAndView();
		List<Admin> adminList = adminService.selectAdminList(pageData);
		pageData.setPages(adminService.selectPages());
		mav.addObject("adminList", adminList);
		mav.addObject("pageData", pageData);
		mav.setViewName("/admin/admin_query_success.jsp");
		return mav;
	}
//	
//	@RequestMapping("/selectUserById")
//	public ModelAndView selectUserById(String param, int id) {
//		ModelAndView mav = new ModelAndView();
//		if(param != null && !"".equals(param)) {
//			mav.addObject("user", userService.selectUserById(id));
//			mav.setViewName("/user/user_edit.jsp");
//		}
//		return mav;
//		
//	}
//	
	@RequestMapping("/deleteAdmin")
	public ModelAndView deleteAdmin(int id) {
		ModelAndView mav = new ModelAndView();
		try {
			adminService.deleteAdmin(id);
			mav.addObject("result", "删除成功！");
		} catch (Exception e) {
			mav.addObject("result", "删除失败！");
		}
		mav.setViewName("/admin/admin_addOrEdit_result.jsp");
		return mav;
	}
//	
//	
	@RequestMapping("/updateAdmin")
	public ModelAndView updateAdmin(Admin admin) {
			ModelAndView mav = new ModelAndView();
			try {
				String newPass = admin.getPassword();
				newPass = Md5Utils.encodingMd5(newPass);//密码加密
				admin.setPassword(newPass);
				adminService.updateAdmin(admin);
				mav.addObject("result", "修改成功！");
			} catch (Exception e) {
				mav.addObject("result", "修改失败！");
			}
			mav.setViewName("/admin/admin_addOrEdit_result.jsp");
			return mav;
	}
//	
//	
	@RequestMapping("/insertAdmin")
	public ModelAndView insertAdmin(Admin admin) {
		ModelAndView mav = new ModelAndView();
		try {
			String newPass = admin.getPassword();
			newPass = Md5Utils.encodingMd5(newPass);//密码加密
			admin.setPassword(newPass);
			adminService.insertAdmin(admin);
			mav.addObject("result", "添加成功！");
		} catch (Exception e) {
			mav.addObject("result", "添加失败！");
		}
		mav.setViewName("/admin/admin_addOrEdit_result.jsp");
		return mav;
	}
//	
	@RequestMapping("/requestType")
	public String requestType(HttpServletRequest request, Model model, String param,Integer id) {
		PageData pageData = new PageData();
		pageData.setPage(0);
		pageData.setPages(1000);
		String url = "";
		if("logOut".equals(param)) {
			HttpSession session = request.getSession();
			session.invalidate();
			url = "/admin/admin_login.jsp";
			return url;
		}
		model.addAttribute("companyList", companyService.selectCompany(pageData));
		if("add".equals(param)) {
			url = "/admin/admin_add.jsp";
			return url;
		}
		if("update".equals(param)) {
			Admin admin = adminService.selectAdminById(id);
			model.addAttribute("admin",admin );
			url = "/admin/admin_edit.jsp";
			return url;
		}
		return url;
	}
//	
	

}
