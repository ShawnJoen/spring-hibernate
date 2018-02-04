package com.hibernate.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//简单 JPA注解 基本用法
@Embeddable //可被嵌套的类
public class UserExtends implements Serializable {
	private static final long serialVersionUID = -1954271141882683062L;
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long userId;
	
	@Column(name="point")
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
