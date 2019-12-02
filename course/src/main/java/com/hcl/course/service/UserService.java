package com.hcl.course.service;

import org.springframework.stereotype.Service;
import com.hcl.course.exception.AuthenticationFailedException;
import com.hcl.course.model.EnrolledCourse;
import com.hcl.course.model.User;

@Service
public interface UserService {

	EnrolledCourse login(User user) throws AuthenticationFailedException ;

	User findCourseByfromUserId(Integer userId);

	String getUserCourse(User user);

}
