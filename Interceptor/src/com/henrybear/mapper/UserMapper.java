package com.henrybear.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.henrybear.bean.User;

public interface UserMapper {

	@Select("select * from tb_user where loginname = #{loginname} and password = #{password}")
	User findWithLoginname(@Param("loginname") String loginname,@Param("password") String password);

	@Select("select * from tb_user where loginname = #{loginname}")
	User findByLoginname(@Param("loginname") String loginname);
	
	@Select("select * from tb_user ")
	List<User> getAll();
	
	@SelectProvider(type=com.henrybear.mapper.UserDynaSqlProvider.class,method="selectWhitParam")
	List<User> selectWhitParam(User user);
	
	@InsertProvider(type=com.henrybear.mapper.UserDynaSqlProvider.class, method="insertUser")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insertUser(User user);
	
	@UpdateProvider(type=com.henrybear.mapper.UserDynaSqlProvider.class,method="updateUser")
	int updateUser(User user);
	
	@DeleteProvider(type=com.henrybear.mapper.UserDynaSqlProvider.class,method="deleteUser")
	int deleteUser(User user);
}
