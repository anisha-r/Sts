package com.anisha.bank;


public interface AccountRepository {
	
	 public Account byUserid( int userid);
	 
	 public Account byAccountnum(int accountnum);
    
	 public String addAccount(Account account);
    
	 public String deleteAccount(int accountnum);

}
