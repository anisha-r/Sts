package com.anisha.bank;


import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	public Account findAccountByUserid(int userid);
	
	public Account findAccountByAccountnum(int accountnum);
	

}
