package com.hcl.course.service;

import java.util.List;

import com.hcl.course.exception.CourseIdNotFoundException;
import com.hcl.course.exception.CourseNotFoundException;
import com.hcl.course.model.AllCourse;

public interface AllCourseService {

	String getAllCourse(AllCourse allCourse);

	AllCourse searchCourse(Integer courseId) throws CourseIdNotFoundException;
	
	List<AllCourse> displayAll() throws CourseNotFoundException;
	
	List<AllCourse> getDetails(String courseName) throws CourseNotFoundException;

}
