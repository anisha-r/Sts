package com.anisha.bank;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class UserController {
	protected Logger logger = Logger
			.getLogger(UserController.class.getName());
	
	@Autowired
	UserRepository userRepository;
	

	@RequestMapping("/{userName}/user")
	
	public User byUserName(@PathVariable("userName") String userName) {
		logger.info("bankuserservice byUserName() invoked: " + userName);
		User user = userRepository.getUserByUserName(userName);
		logger.info("bankuserservice byUserName() found: " + user);
		
		return user;
	}

}
