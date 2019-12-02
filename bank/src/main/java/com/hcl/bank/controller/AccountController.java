package com.hcl.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.model.Account;
import com.hcl.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public ResponseEntity<String> transact(@RequestBody Account account) {
		return new ResponseEntity<String>(accountService.userAccount(account), new HttpHeaders(), HttpStatus.OK);
	}

}
