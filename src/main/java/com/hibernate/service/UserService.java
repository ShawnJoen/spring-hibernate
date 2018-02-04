package com.hibernate.service;

import java.util.List;
import com.hibernate.entity.Users;

public interface UserService {
	Long createUser(String mobile, String password);
	Users selectUser();
	List<Users> selectUserList();
	void updateUser();
}
