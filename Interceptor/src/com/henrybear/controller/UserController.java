package com.henrybear.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSONObject;
import com.henrybear.bean.Message;
import com.henrybear.bean.User;
import com.henrybear.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping("/login")
	public ModelAndView login(String loginname, String password, ModelAndView mv, HttpSession session) {
		User user = userService.login(loginname, password);
		if(user != null) {
			session.setAttribute("user", user);
			mv.setView(new RedirectView("/Interceptor/main"));
		}else {
			mv.addObject("message","login error!");
			mv.setViewName("loginForm");
		}
		return mv;
	}
	
	@RequestMapping(value="/useradd", method = RequestMethod.GET)
	public String add() {
		return "useradd";
	}
	
	@RequestMapping(value="/useradd", method=RequestMethod.POST)
	@ResponseBody
	public Object addUser(@RequestBody User user, ModelAndView mv) {
		int ret = userService.insertUser(user);
		Message msg = new Message();
		if(ret == 1) {
			mv.addObject("message","添加【"+user.getUsername()+"】成功");
			msg.setFlag("success");
			msg.setStatus("0");
			msg.setMessage("添加【"+user.getUsername()+"】成功");
		}else {
			mv.addObject("message","添加【"+user.getUsername()+"】失败");
			msg.setFlag("fail");
			msg.setStatus("-1");
			msg.setMessage("添加【"+user.getUsername()+"】失败");
		}
		return msg;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search() {
		return "usersearch";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	@ResponseBody
	public List<User> searchUser(@RequestBody User user) {
		List<User> list = userService.selectWhitParam(user);
		return list;
	}
	
	@RequestMapping(value="/mod", method=RequestMethod.GET)
	public ModelAndView mod(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) {
		String loginname = request.getParameter("q");
		User user = userService.findByLoginname(loginname);
		System.out.println(user.toJson()+"###########");
		mv.addObject("user", user);
		mv.setViewName("usermod");
		return mv;
	}
	
	@RequestMapping(value="/mod", method=RequestMethod.POST)
	@ResponseBody
	public void modUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
		int res = userService.updateUser(user);
		Message msg = new Message();
		if(res == 1) {
			msg.setFlag("true");
			msg.setStatus("0");
			msg.setMessage("更新成功！");
		}else {
			msg.setFlag("true");
			msg.setStatus("0");
			msg.setMessage("更新失败，res="+res);
		}
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().println(JSONObject.toJSONString(msg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	@RequestMapping(value="/del", method=RequestMethod.GET)
	public ModelAndView del(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) {
		String loginname = request.getParameter("q");
		User user = userService.findByLoginname(loginname);
		System.out.println(user.toJson()+"###########");
		mv.addObject("user", user);
		mv.setViewName("userdel");
		return mv;
	}

	@RequestMapping(value="/del", method=RequestMethod.POST)
	@ResponseBody
	public void delUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
		int res = userService.deleteUser(user);
		Message msg = new Message();
		if(res == 1) {
			msg.setFlag("true");
			msg.setStatus("0");
			msg.setMessage("删除成功！");
		}else {
			msg.setFlag("true");
			msg.setStatus("0");
			msg.setMessage("删除失败，res="+res);
		}
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().println(JSONObject.toJSONString(msg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}
