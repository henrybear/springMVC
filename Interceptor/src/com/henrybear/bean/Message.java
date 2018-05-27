package com.henrybear.bean;

import com.alibaba.fastjson.JSON;

public class Message {

	private String flag;
	private String status;
	private String message;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toJson() {
		return JSON.toJSONString(this);
	}
}
