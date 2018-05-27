package com.henrybear.bean;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

public class User implements Serializable {

	/**
	 * 4935745141628130725L
	 */
	private static final long serialVersionUID = -4935745141628130725L;

	public static enum ROLE {ADMIN,USER,VISITOR};

	private int id;
	private Enum role;
	private String loginname;
	private String password;
	private String username;
	private String phone;
	private String address;
	private String bak;
	private String bak1;
	private String bak2;
	private String bak3;
	private String bak4;
	private String bak5;
	private String bak6;
	private String bak7;
	private String bak8;
	private String bak9;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Enum getRole() {
		return role;
	}


	public void setRole(Enum role) {
		this.role = role;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBak() {
		return bak;
	}

	public void setBak(String bak) {
		this.bak = bak;
	}

	public String getBak1() {
		return bak1;
	}

	public void setBak1(String bak1) {
		this.bak1 = bak1;
	}

	public String getBak2() {
		return bak2;
	}

	public void setBak2(String bak2) {
		this.bak2 = bak2;
	}

	public String getBak3() {
		return bak3;
	}

	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}

	public String getBak4() {
		return bak4;
	}

	public void setBak4(String bak4) {
		this.bak4 = bak4;
	}

	public String getBak5() {
		return bak5;
	}

	public void setBak5(String bak5) {
		this.bak5 = bak5;
	}

	public String getBak6() {
		return bak6;
	}

	public void setBak6(String bak6) {
		this.bak6 = bak6;
	}

	public String getBak7() {
		return bak7;
	}

	public void setBak7(String bak7) {
		this.bak7 = bak7;
	}

	public String getBak8() {
		return bak8;
	}

	public void setBak8(String bak8) {
		this.bak8 = bak8;
	}

	public String getBak9() {
		return bak9;
	}

	public void setBak9(String bak9) {
		this.bak9 = bak9;
	}

	public String toJson() {
		return JSON.toJSONString(this);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", role=" + role + ", loginname=" + loginname + ", password=" + password
				+ ", username=" + username + ", phone=" + phone + ", address=" + address + ", bak=" + bak + ", bak1="
				+ bak1 + ", bak2=" + bak2 + ", bak3=" + bak3 + ", bak4=" + bak4 + ", bak5=" + bak5 + ", bak6=" + bak6
				+ ", bak7=" + bak7 + ", bak8=" + bak8 + ", bak9=" + bak9 + "]";
	}

}
