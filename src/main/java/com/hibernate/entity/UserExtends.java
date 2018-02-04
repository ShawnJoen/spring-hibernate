package com.hibernate.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//简单 JPA注解 基本用法
@Entity //实体类映射数据库
@Table(name="user_extends") //Java类和数据库表对应的表名
public class UserExtends implements Serializable {
	private static final long serialVersionUID = -1954271141882683062L;

	@Id //注解一个主键, @GeneratedValue默认为GenerationType.AUTO
	@Column(name = "userId", nullable = false)
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
