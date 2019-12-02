package com.hcl.bank.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hcl.bank.model.Account;
import com.hcl.bank.model.Register;

public interface AccountRepository extends CrudRepository<Account, Integer>{
	
	
	Account findByAccountNumber(Integer accountNumber); 
	
	Account findByAccountId(Integer accountId);


	void save(Register register);
	

}
