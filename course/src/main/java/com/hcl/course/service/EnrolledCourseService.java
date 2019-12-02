package com.hcl.course.service;


import org.springframework.stereotype.Service;

import com.hcl.course.dto.Enroll;
import com.hcl.course.exception.UserIdNotFoundException;
import com.hcl.course.model.EnrolledCourse;

@Service
public interface EnrolledCourseService {

	String registerCourse(Enroll enroll) throws UserIdNotFoundException;

	EnrolledCourse findCourseByfromUserId(Integer list);
}
