package com.hcl.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.course.dao.UserRepository;
import com.hcl.course.exception.AuthenticationFailedException;
import com.hcl.course.model.EnrolledCourse;
import com.hcl.course.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EnrolledCourseService enrolledCourseService;

	
	@Override
	public String getUserCourse(User user){
		userRepository.save(user);
		return "Saved SuccessFully";
	}

	@Override
	public EnrolledCourse login(User user) throws AuthenticationFailedException {
		String name =user.getUserName();
		String code = user.getPassWord();
		User user1 = userRepository.findByUserName(user.getUserName());
		if(user1.getUserName().equals(name) && user1.getPassWord().equals(code)){
			Integer userId = user1.getUserId();
			return enrolledCourseService.findCourseByfromUserId(userId);
		}else {
		throw new AuthenticationFailedException("Authentication failed");
		}
	}


	
	@Override
	public User findCourseByfromUserId(Integer userId) {
		return userRepository.findUserByUserId(userId);
	}

}
