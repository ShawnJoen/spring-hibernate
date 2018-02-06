package com.hibernate.repository;

import java.util.List;
import com.hibernate.entity.Users;
import com.hibernate.entity.vo.UsersVo;

public interface UserRepository extends DomainRepository<Users> {
	UsersVo getUserByMobile(String mobile);
	List<UsersVo> getUserList();
	int updateUser(String mobile, String userName);
}
