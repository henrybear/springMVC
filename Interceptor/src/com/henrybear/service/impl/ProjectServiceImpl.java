package com.henrybear.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.henrybear.bean.Project;
import com.henrybear.mapper.ProjectMapper;
import com.henrybear.service.ProjectService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;
	
	@Override
	public int insertProject(Project project) {
		// TODO Auto-generated method stub
		return projectMapper.insertProject(project);
	}

	@Override
	public List<Project> selectWhitParam(Project project) {
		// TODO Auto-generated method stub
		return projectMapper.selectWhitParam(project);
	}

	@Override
	public Project findBySequence(String sequence) {
		// TODO Auto-generated method stub
		return projectMapper.findBySequence(sequence);
	}

	@Override
	public int updateProject(Project project) {
		// TODO Auto-generated method stub
		return projectMapper.updateProject(project);
	}

}
