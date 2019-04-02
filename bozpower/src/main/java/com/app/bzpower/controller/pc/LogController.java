package com.app.bzpower.controller.pc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.bzpower.entity.Log;
import com.app.bzpower.entity.PageData;
import com.app.bzpower.service.LogService;

/**
 * 日志查询
 * @author 123
 *
 */
@Controller("pcLogController")
@RequestMapping("/pcLog")
public class LogController {
	
	@Autowired
	private LogService logService;
	
	@RequestMapping("/selectLogList")
	public ModelAndView selectLogList(PageData pageData) {
		ModelAndView mav = new ModelAndView();
		List<Log> logList = logService.selectLogList(pageData);
		mav.addObject("logList", logList);
		int pages = logService.selectPages();
		pageData.setPage(pageData.getPage());
		pageData.setPages(pages);
		mav.addObject("pageData", pageData);
		mav.setViewName("/log/log_query_success.jsp");
		return mav;
	}
	
	@RequestMapping("/deleteLog")
	public ModelAndView deleteLog(Integer id) {
		ModelAndView mav = new ModelAndView();
		try {
			logService.deleteLog(id);
			mav.addObject("result", "删除成功！");
			mav.setViewName("/log/log_delete_result.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("result", "删除失败！");
		}
		return mav;
	}
	

}
