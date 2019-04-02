package com.app.bzpower.controller.pc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.bzpower.entity.PageData;
import com.app.bzpower.entity.User;
import com.app.bzpower.service.CompanyService;
import com.app.bzpower.service.UserService;
import com.app.bzpower.util.Md5Utils;

@Controller("pcUserController")
@RequestMapping("/pcUser")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	/**
	 * 用户登录
	 * @param request
	 * @param user
	 * @return
	 */
//	@RequestMapping("/userLogin")
//	public ModelAndView userLogin(HttpServletRequest request, user user) {
//		ModelAndView mav = new ModelAndView();
//		user newuser = null;
//		
//		if(StringUtils.isEmpty(user.getUsername()))  {
//			request.setAttribute("err", "用户名输入为空");
//			mav.setViewName("/user/user_login.jsp");
//			return mav;
//		}
//		if(StringUtils.isEmpty(user.getPassword()))  {
//			request.setAttribute("err", "密码输入为空");
//			mav.setViewName("/user/user_login.jsp");
//			return mav;
//		}
//		
//		List<user> existUser = userService.selectuserByName(admin.getUsername());
//		if(existUser.size() == 0) {
//			mav.setViewName("/user/user_login.jsp");
//			request.setAttribute("err", "用户名输入错误");
//			return mav;
//		}else {
//			String newPass = admin.getPassword();
//			newPass = Md5Utils.encodingMd5(newPass);//密码加密
//			newAdmin = adminService.AdminLogin(admin.getUsername(),newPass); 
//			if(newAdmin != null) {//表示登录成功
//				mav.setViewName("/admin/admin_login_success.jsp");
//				mav.addObject("admin", newAdmin);
//				System.out.println(newAdmin.getRealname());
//				return mav;
//			}else {
//				mav.setViewName("/admin/admin_login.jsp");
//				request.setAttribute("err", "密码输入错误");
//				return mav;
//			}
//		}
//	}
//	
	@RequestMapping("/selectUserList")
	public ModelAndView selectUserList(PageData pageData) {
		ModelAndView mav = new ModelAndView();
		List<User> userList = userService.selectUserList(pageData);
		pageData.setPages(userService.selectPages());
		mav.addObject("adminList", userList);
		mav.addObject("pageData", pageData);
		mav.setViewName("/user/user_query_success.jsp");
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
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(int id) {
		ModelAndView mav = new ModelAndView();
		try {
			userService.deleteUser(id);
			mav.addObject("result", "删除成功！");
		} catch (Exception e) {
			mav.addObject("result", "删除失败！");
		}
		mav.setViewName("/user/user_addOrEdit_result.jsp");
		return mav;
	}
	
	
	@RequestMapping("/updateUser")
	public ModelAndView updateUser(User user) {
			ModelAndView mav = new ModelAndView();
			try {
				String newPass = user.getPassword();
				newPass = Md5Utils.encodingMd5(newPass);//密码加密
				user.setPassword(newPass);
				userService.updateUser(user);
				mav.addObject("result", "修改成功！");
			} catch (Exception e) {
				mav.addObject("result", "修改失败！");
			}
			mav.setViewName("/user/user_addOrEdit_result.jsp");
			return mav;
	}
//	
//	
	@RequestMapping("/insertUser")
	public ModelAndView insertUser(User user) {
		ModelAndView mav = new ModelAndView();
		try {
			String newPass = user.getPassword();
			newPass = Md5Utils.encodingMd5(newPass);//密码加密
			user.setPassword(newPass);
			userService.insertUser(user);
			mav.addObject("result", "添加成功！");
		} catch (Exception e) {
			mav.addObject("result", "添加失败！");
		}
		mav.setViewName("/user/user_addOrEdit_result.jsp");
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
//			session.removeAttribute("admin");
			session.invalidate();
			url = "/user/user_login.jsp";
			return url;
		}
		model.addAttribute("companyList", companyService.selectCompany(pageData));
		if("add".equals(param)) {
			url = "/user/user_add.jsp";
			return url;
		}
		if("update".equals(param)) {
			model.addAttribute("user", userService.selectUserById(id));
			url = "/user/user_edit.jsp";
			return url;
		}
		return url;
	}
//	
	

}
