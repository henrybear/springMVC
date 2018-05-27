package com.henrybear.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.henrybear.bean.User;

public class UserDynaSqlProvider {

	public String selectWhitParam(User user) {
		return new SQL() {
			{
				SELECT("*");
				FROM("tb_user");
				WHERE("1=1");
				if(user.getId() > 0){
					WHERE(" id = #{id} ");
				}
				if(user.getLoginname() != null && !user.getLoginname().equals("")){
					WHERE(" loginname = #{loginname} ");
				}
				if(user.getPassword() != null&& !user.getPassword().equals("")){
					WHERE("password = #{password}");
				}
				if(user.getUsername() != null&& !user.getUsername().equals("")){
					WHERE("username = #{username}");
				}
				if(user.getAddress() != null&& !user.getAddress().equals("")){
					WHERE("address = #{address}");
				}
				if(user.getPhone() != null&& !user.getPhone().equals("")){
					WHERE("phone = #{phone}");
				}
			}
		}.toString();
	}
	
	public String insertUser(User user) {
		return new SQL() {
			{
				INSERT_INTO("tb_user");
				if(user.getLoginname() != null){
					VALUES("loginname", "#{loginname}");
				}
				if(user.getPassword() != null){
					VALUES("password", "#{password}");
				}
				if(user.getUsername()!= null){
					VALUES("username", "#{username}");
				}
				if(user.getPhone()!= null){
					VALUES("phone", "#{phone}");
				}
				if(user.getAddress()!= null){
					VALUES("address", "#{address}");
				}
				if(user.getBak()!= null){
					VALUES("bak", "#{bak}");
				}
				if(user.getBak1()!= null){
					VALUES("bak1", "#{bak1}");
				}
				if(user.getBak2()!= null){
					VALUES("bak2", "#{bak2}");
				}
				if(user.getBak3()!= null){
					VALUES("bak3", "#{bak3}");
				}
			}
		}.toString();
	}
	
	public String updateUser(User user) {
		return new SQL() {
			{
				UPDATE("tb_user");
				if(user.getPassword() != null){
					SET("password = #{password}");
				}
				if(user.getUsername()!= null){
					SET("username = #{username}");
				}
				if(user.getPhone()!= null){
					SET("phone = #{phone}");
				}
				if(user.getAddress()!= null){
					SET("address = #{address}");
				}
				if(user.getPhone()!= null){
					SET("phone = #{phone}");
				}
				if(user.getBak()!= null){
					SET("bak = #{bak}");
				}
				if(user.getBak2()!= null){
					SET("bak1 = #{bak1}");
				}
				if(user.getBak2()!= null){
					SET("bak2 = #{bak2}");
				}
				if(user.getBak3()!= null){
					SET("bak3 = #{bak3}");
				}
				WHERE(" loginname = #{loginname} ");
			}
		}.toString();
	}
	
	public String deleteUser(User user) {
		return new SQL() {
			{
				DELETE_FROM("tb_user");
				if(user.getId() > 0){
					WHERE(" id = #{id} ");
				}
				if(user.getLoginname() != null){
					WHERE(" loginname = #{loginname} ");
				}
				if(user.getPassword() != null){
					WHERE("password = #{password}");
				}
				if(user.getUsername() != null){
					WHERE("username = #{username}");
				}
			}
		}.toString();
	}
}
