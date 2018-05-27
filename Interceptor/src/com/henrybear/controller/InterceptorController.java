package com.henrybear.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.henrybear.bean.User;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
	
	@RequestMapping(value="/{formName}")
	public String redirect(@PathVariable String formName) {
		return formName;
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(String loginname, String password, ModelAndView mv, HttpSession session) {
		if(loginname != null && loginname.equals("test") && password != null && password.equals("test")) {
			User user = new User();
			user.setLoginname(loginname);
			user.setPassword(password);
			user.setRole(User.ROLE.ADMIN);
			
			session.setAttribute("user", user);
			mv.setViewName("redirect:main");
		}else {
			mv.addObject("message","login again!");
			mv.setViewName("loginForm");
		}
		return mv;
	}
}
