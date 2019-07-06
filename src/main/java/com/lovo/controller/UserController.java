package com.lovo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lovo.entity.PageBean;
import com.lovo.entity.UserBean;
import com.lovo.mapper.Excle2;
import com.lovo.service.IUserService;
import com.lovo.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("login.lovo")
	public ModelAndView login(String username, String password) {
		ModelAndView mv = new ModelAndView("show.lovo");
		UserBean user = userService.login(username, password);
		if (user == null) {
			mv.setViewName("fail");
		}
		return mv;
	}

	@RequestMapping("register.lovo")
	public ModelAndView register(String username, String password) {
		ModelAndView mv = new ModelAndView("login");
		UserBean user = new UserBean();
		if (username.equals("") && password.equals("")) {
			mv.setViewName("register");
		} else {
			user.setUsername(username);
			user.setPassword(password);
			userService.addUser(user);
		}
		return mv;

	}

	@RequestMapping("show.lovo")
	@ResponseBody // 不返回视图，只返回数据
	public PageBean<UserBean> show(Integer currentPage) {
		Integer totalPage = userService.getTotalCountByItem();
		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		List<UserBean> list = userService.findByItem(currentPage);
		PageBean<UserBean> page = new PageBean<UserBean>();
		page.setList(list);
		page.setCurrentPage(currentPage);
		page.setTotalPage(totalPage);
		return page;
	}

	
	@RequestMapping("poi.lovo")
	public ModelAndView poi() throws IOException {
		ModelAndView mv = new ModelAndView("show");
		List<UserBean> list = userService.findAllUser();
		Excle2.dbToExcle(list);
		return mv;		
	}
}
