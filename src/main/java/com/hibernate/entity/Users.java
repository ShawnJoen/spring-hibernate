package com.hibernate.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//简单 JPA注解 基本用法
@Entity //实体类映射数据库
@Table(name="Users") //Java类和数据库表对应的表名
public class Users implements Serializable {
	private static final long serialVersionUID = -1954271141882683062L;

	@Id //注解一个主键, @GeneratedValue默认为GenerationType.AUTO
    @GeneratedValue(strategy = GenerationType.IDENTITY) //注释定义了标识字段生成方式
	private Long userId;
	
	@Column(name="mobile", length=11, nullable=false ,unique=true)
	private String mobile;
	
	@Column(name="password", length=32)
	private String password;
	
	@Column(name="userName", length=50, nullable=false)
	private String userName;
	
	@Column(name="createTime", nullable=false)
	private Date createTime;
	
	//@Embedded //注解将 UserExtends类嵌套进来
    //private UserExtends userExtends;
	
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
//	public UserExtends getUserExtends() {
//		return userExtends;
//	}
//	public void setUserExtends(UserExtends userExtends) {
//		this.userExtends = userExtends;
//	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", mobile=" + mobile + ", password=" + password + ", userName=" + userName
				+ ", createTime=" + createTime + "]";
	}
	
}
