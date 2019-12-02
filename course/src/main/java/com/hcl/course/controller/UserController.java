package com.hcl.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.course.exception.AuthenticationFailedException;
import com.hcl.course.model.EnrolledCourse;
import com.hcl.course.model.User;
import com.hcl.course.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<EnrolledCourse> loginUser(@RequestBody User user) throws AuthenticationFailedException {
		return new ResponseEntity<EnrolledCourse>(userService.login(user), new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add/users", method = RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody User user) {
		return new ResponseEntity<String>(userService.getUserCourse(user), new HttpHeaders(), HttpStatus.OK);
	}

}
