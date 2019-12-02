package com.hcl.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.course.exception.CourseIdNotFoundException;
import com.hcl.course.exception.CourseNotFoundException;
import com.hcl.course.model.AllCourse;
import com.hcl.course.service.AllCourseService;

@RestController
@RequestMapping("/allcourses")
public class AllCourseController {

	@Autowired
	AllCourseService allCourseService;

	@RequestMapping(value = "/course/enroll", method = RequestMethod.POST)
	public ResponseEntity<String> loginUser(@RequestBody AllCourse allCourse) {
		return new ResponseEntity<String>(allCourseService.getAllCourse(allCourse), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/courseName/search")
	public ResponseEntity<List<AllCourse>> viewCourseByCourseName(String  courseName) throws  CourseNotFoundException {
		List<AllCourse> allCourse = allCourseService.getDetails(courseName);
		return new ResponseEntity<List<AllCourse>> (allCourse, new HttpHeaders(), HttpStatus.OK);

	}
	@GetMapping("/course/search")
	public ResponseEntity<AllCourse> viewCourseByCourseId(Integer courseId) throws CourseIdNotFoundException {
		AllCourse allCourse = allCourseService.searchCourse(courseId);
		return new ResponseEntity<AllCourse>(allCourse, new HttpHeaders(), HttpStatus.OK);

	}
	@GetMapping("/list/")
	public ResponseEntity<List<AllCourse>> viewCourses() throws CourseNotFoundException {
		return new ResponseEntity<List<AllCourse>>(allCourseService.displayAll(), new HttpHeaders(), HttpStatus.OK);

	}

}
