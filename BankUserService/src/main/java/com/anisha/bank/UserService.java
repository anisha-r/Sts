package com.anisha.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserByUserName(String userName) {
		User user = userRepository.getUserByUserName(userName);
		return user;
	}
	
	
	

}
