
package com.hcl.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.course.dto.Enroll;
import com.hcl.course.exception.UserIdNotFoundException;
import com.hcl.course.service.EnrolledCourseService;

@RestController
@RequestMapping("/courses")
public class EnrolledCourseController {
	
	@Autowired
	EnrolledCourseService enrolledCourseService;
	
	
	
	@RequestMapping(value = "/new/enroll", method = RequestMethod.POST)
	public ResponseEntity<String> enrollUser(@RequestBody Enroll enroll) throws UserIdNotFoundException {
		return new ResponseEntity<String>(enrolledCourseService.registerCourse(enroll), new HttpHeaders(), HttpStatus.OK);
	}
	


	}
