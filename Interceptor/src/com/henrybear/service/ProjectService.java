package com.henrybear.service;

import java.util.List;

import com.henrybear.bean.Project;

public interface ProjectService {

	public int insertProject(Project project);
	
	public List<Project> selectWhitParam(Project project);
	
	Project findBySequence(String sequence);
	
	int updateProject(Project project);
}
