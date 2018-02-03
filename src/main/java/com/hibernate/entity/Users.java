package com.hibernate.entity;

import java.util.Date;

public class Users {
	
	private Long userId;
	private String mobile;
	private String password;
	private String userName;
	private Date createTime;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", mobile=" + mobile + ", password=" + password + ", userName=" + userName
				+ ", createTime=" + createTime + "]";
	}
	
}
