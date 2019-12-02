package com.hcl.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.bank.model.Transaction;

@Service
public interface TransactionService {
	

	String credit(Transaction transaction);

	List<Transaction> findTransactionByfromAccountNumber(Integer list);

}
