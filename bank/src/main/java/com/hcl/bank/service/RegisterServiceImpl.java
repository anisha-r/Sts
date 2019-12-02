package com.hcl.bank.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.dao.AccountRepository;
import com.hcl.bank.dao.RegisterRepository;
import com.hcl.bank.dao.TransactionRepository;
import com.hcl.bank.model.Register;
import com.hcl.bank.model.Transaction;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	RegisterRepository registerRepository;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	TransactionService transactionService;

	@Override
	public String RegisterUser(Register register) {
		registerRepository.save(register);
		return "Saved SuccessFully";
	}

	@Override
	public List<Register> LoginUser(Integer accountNumber) {

		List<Register> login = registerRepository.findByAccountNumber(accountNumber);
		return login;

	}

	@Override
	public List<Transaction> loginAuthenticate(Register  register) {
		String name = register.getUserName();
		String code = register.getPassWord();
		Register register1 = registerRepository.findRegisterByuserName(name);
		if (register1.getUserName().equals(name) && register1.getPassWord().equals(code)) {
			Integer list = register1.getAccountNumber();
			return transactionService.findTransactionByfromAccountNumber(list);
		}else {
		return null;
		}
	}
 
	@Override
	public Register findRegisterByuserName(String userName) {
		return registerRepository.findRegisterByuserName(userName); 
	}

}
