package com.hibernate.controller;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public void createUser() {
		logger.info("createUser: {}", new Date());
	}
	
	@RequestMapping(value = "/selectUser", method = RequestMethod.GET)
	public void selectUser(@RequestParam("mobile") String mobile) {
		logger.info("selectUser: {}", new Date());
	}
	
	@RequestMapping(value = "/selectUserList", method = RequestMethod.GET)
	public void selectUserList() {
		logger.info("selectUserList: {}", new Date());
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public void updateUser(@RequestParam("mobile") String mobile, 
			@RequestParam("userName") String userName) {
		logger.info("updateUser: {}", new Date());
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public void deleteUser(@RequestParam("mobile") String mobile) {
		logger.info("deleteUser: {}", new Date());
	}
	
}
