package com.hibernate.entity;

public class UserExtends {
	
	private Long userId;
	private int point;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "UserExtends [userId=" + userId + ", point=" + point + "]";
	}
	
}
