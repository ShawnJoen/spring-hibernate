package com.hibernate.service;

import java.util.List;
import com.hibernate.entity.Users;
import com.hibernate.entity.vo.UsersVo;

public interface UserService {
	Long createUser(String mobile, String password);
	UsersVo selectUser(String mobile);
	List<Users> selectUserList();
	void updateUser();
}
