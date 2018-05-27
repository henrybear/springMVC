package com.henrybear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.henrybear.bean.Project;

public interface ProjectMapper {
	@Select("select * from tb_project where sequence = #{sequence}")
	Project findBySequence(@Param("sequence") String sequence);
	
	@Select("select * from tb_project ")
	List<Project> getAll();
	
	@SelectProvider(type=com.henrybear.mapper.ProjectDynaSqlProvider.class,method="selectWhitParam")
	List<Project> selectWhitParam(Project project);
	
	@InsertProvider(type=com.henrybear.mapper.ProjectDynaSqlProvider.class, method="insertProject")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insertProject(Project project);
	
	@UpdateProvider(type=com.henrybear.mapper.ProjectDynaSqlProvider.class,method="updateProject")
	int updateProject(Project project);
//	
//	@DeleteProvider(type=com.henrybear.mapper.ProjectDynaSqlProvider.class,method="deleteUser")
//	int deleteProject(Project project);
}
