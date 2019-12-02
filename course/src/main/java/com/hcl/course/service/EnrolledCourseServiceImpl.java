package com.hcl.course.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.course.dao.AllCourseRepository;
import com.hcl.course.dao.EnrolledCourseRepository;
import com.hcl.course.dto.Enroll;
import com.hcl.course.exception.UserIdNotFoundException;
import com.hcl.course.model.AllCourse;
import com.hcl.course.model.EnrolledCourse;

@Service
public class EnrolledCourseServiceImpl implements EnrolledCourseService {

	@Autowired
	EnrolledCourseRepository enrolledCourseRepository;

	@Autowired
	AllCourseRepository allCourseRepository;

	@Autowired
	UserService userService;

	@Override
	public EnrolledCourse findCourseByfromUserId(Integer userId) {
		return enrolledCourseRepository.findCourseByUserId(userId);
	}

	@Override
	public String registerCourse(Enroll enroll) throws UserIdNotFoundException {
		String result = "";
		AllCourse allCourse = allCourseRepository.findCourseByCourseName(enroll.getCourseName());
		List<EnrolledCourse> enrolledCourse = enrolledCourseRepository.findByCourseNameAndUserId(enroll.getCourseName(),enroll.getUserId());
		if (enrolledCourse.isEmpty()){
			EnrolledCourse enrolledCourse2 = new EnrolledCourse();
			enrolledCourse2.setAuthorName(allCourse.getAuthorName());
			enrolledCourse2.setCourseName(enroll.getCourseName());
			enrolledCourse2.setDuration(allCourse.getDuration());
			enrolledCourse2.setUserId(enroll.getUserId());
			enrolledCourseRepository.save(enrolledCourse2);
			return result = "Success";
		}
		else {
			return result="Fail";
		}

		}

	
}
