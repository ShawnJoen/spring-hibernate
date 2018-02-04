package com.hibernate.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hibernate.entity.Users;
import com.hibernate.entity.vo.UsersVo;
import com.hibernate.repository.UserRepository;
import com.hibernate.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
	
	@Transactional
	@Override
	public Long createUser(String mobile, String password) {
		Users user = new Users();
		user.setMobile(mobile);
		user.setPassword(password);
		user.setUserName("Shawn Random: " + new Random().nextInt(1000));
		user.setCreateTime(new Date());
		return userRepository.save(user);
	}

	@Override
	public UsersVo selectUser(String mobile) {
		return userRepository.getUserByMobile(mobile);
	}

	@Override
	public List<Users> selectUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser() {
		// TODO Auto-generated method stub

	}

}
