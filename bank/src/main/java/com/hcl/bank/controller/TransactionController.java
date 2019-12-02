package com.hcl.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.model.Transaction;
import com.hcl.bank.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public ResponseEntity<String> userTransaction(@RequestBody Transaction transaction) {
		return new ResponseEntity<String>(transactionService.credit(transaction), new HttpHeaders(), HttpStatus.OK);
	}

}
