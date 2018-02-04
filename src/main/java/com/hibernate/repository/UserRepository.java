package com.hibernate.repository;

import com.hibernate.entity.Users;
import com.hibernate.entity.vo.UsersVo;

public interface UserRepository extends DomainRepository<Users> {
	UsersVo getUserByMobile(String mobile);
}
