package com.henrybear.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.henrybear.bean.User;

public class AuthorizationInterceptor implements HandlerInterceptor {

	private static final String[] IGNORE_URI = {"/loginForm","/login"};
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("#########afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("#########postHandle");
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("#########preHandle");
		boolean flag = false;
		String servletpath = arg0.getServletPath();
		for(String uri : IGNORE_URI) {
			if(servletpath.contains(uri)) {
				flag = true;
				break;
			}
		}
		for(String uri : new String[]{"logout"}) {
			if(servletpath.contains(uri)) {
				User user = (User) arg0.getSession().getAttribute("user");
				if(user != null) {
					HttpSession session = arg0.getSession();
					session.setAttribute("user", null);
				}
			}
		}
		
		if(!flag) {
			User user = (User) arg0.getSession().getAttribute("user");
			if(user == null) {
				arg0.setAttribute("message", "pleasse login");
				arg0.getRequestDispatcher("/user/login").forward(arg0, arg1);
			}else {
				flag = true;
			}
		}
		return flag;
	}

}
