package com.hcl.bank.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.bank.dao.AccountRepository;
import com.hcl.bank.dao.RegisterRepository;
import com.hcl.bank.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountService accountService;
	
	@Autowired
	RegisterRepository registerRepository;

	
	@Override
	public String userAccount(Account account) {
		accountRepository.save(account);
		return "Saved SuccessFully";
	}

	
}
