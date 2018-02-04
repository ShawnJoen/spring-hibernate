package com.hibernate.entity.vo;

import java.io.Serializable;
import java.util.Date;

public class UsersVo implements Serializable {
	private static final long serialVersionUID = -6258443611409908478L;
	
	private Long userId;
	private String mobile;
	private String password;
	private String userName;
	private Date createTime;
	private int point;

	public UsersVo(Long userId, String mobile, String userName, int point) {
		super();
		this.userId = userId;
		this.mobile = mobile;
		this.userName = userName;
		this.point = point;
	}
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
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "UsersVo [userId=" + userId + ", mobile=" + mobile + ", password=" + password + ", userName=" + userName
				+ ", createTime=" + createTime + ", point=" + point + "]";
	}
	
}
