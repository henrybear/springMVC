package com.henrybear.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.henrybear.bean.Message;
import com.henrybear.bean.Project;
import com.henrybear.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	@Qualifier("projectService")
	private ProjectService projectService;

	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add() {
		return "projectadd";
	}

	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String search() {
		return "projectsearch";
	}

	@RequestMapping(value="/mod", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView mod(@RequestParam("q") String q, ModelAndView mv) {
		
		Project project = projectService.findBySequence(q);
		mv.addObject("project", project);
		mv.setViewName("projectmod");
		return mv;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public Object addProject(@RequestBody Project project) {
		System.out.println(project);
		int ret = projectService.insertProject(project);
		Message msg = new Message();
		if(ret == 1) {
			msg.setFlag("success");
			msg.setStatus("0");
			msg.setMessage("添加【"+project.getName()+"】成功");
		}else {
			msg.setFlag("fail");
			msg.setStatus("-1");
			msg.setMessage("添加【"+project.getName()+"】失败");
		}
		return msg;
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	@ResponseBody
	public List<Project> searchProject(@RequestBody Project project){
		List<Project> list = projectService.selectWhitParam(project);
		System.out.println(list.size());
		return list;
	}
	
	@RequestMapping(value="/mod", method = RequestMethod.POST)
	public void modProject(@RequestBody Project project, HttpServletRequest request, HttpServletResponse response) {
		int res = projectService.updateProject(project);
		
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
}
