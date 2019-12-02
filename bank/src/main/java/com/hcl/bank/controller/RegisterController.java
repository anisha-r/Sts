package com.hcl.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.model.Register;
import com.hcl.bank.model.Transaction;
import com.hcl.bank.service.RegisterService;

@RestController
@RequestMapping("/bank")
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@RequestMapping(value = "/register/user", method = RequestMethod.POST)
	public ResponseEntity<String> ShowRegister(@RequestBody Register register) {
		return new ResponseEntity<String>(registerService.RegisterUser(register), new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{accountNumber}", method = RequestMethod.GET)

	public ResponseEntity<List<Register>> viewUserByAccountNumber(@PathVariable("accountNumber") Integer accountNumber) {
		List<Register> login = registerService.LoginUser(accountNumber);
		if (login.isEmpty()) {
			return new ResponseEntity<List<Register>>(login, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Register>>(login, new HttpHeaders(), HttpStatus.OK);

	}
	@RequestMapping(value = "/register/login", method = RequestMethod.POST)
	public ResponseEntity<List<Transaction>> loginUser(@RequestBody Register register) {
		return new ResponseEntity<List<Transaction>>(registerService.loginAuthenticate(register), new HttpHeaders(), HttpStatus.OK);
	}
	

}
