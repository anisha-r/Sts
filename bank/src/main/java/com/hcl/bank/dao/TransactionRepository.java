package com.hcl.bank.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bank.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	 List<Transaction> findTransactionByfromAccountNumber(Integer list);
}
