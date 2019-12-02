package com.hcl.bank.service;

import java.util.List;
import com.hcl.bank.model.Register;
import com.hcl.bank.model.Transaction;

public interface RegisterService {

	String RegisterUser(Register register);

	List<Register> LoginUser(Integer accountNumber);

	Register findRegisterByuserName(String userName);


	List<Transaction> loginAuthenticate(Register register);
	
	

}
