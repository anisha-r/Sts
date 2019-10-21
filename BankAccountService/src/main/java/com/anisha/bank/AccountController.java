package com.anisha.bank;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
  protected Logger logger = Logger
				.getLogger(AccountController.class.getName());
		@Autowired
		AccountRepository accountRepository;
		
  @RequestMapping("/{userid}/get")
  public Account byUserid(@PathVariable("userid") int userid) {
	logger.info("bankaccountservice byUserid() invoked: " + userid);
	Account account = accountRepository.findAccountByUserid(userid);
	logger.info("bankaccountservice byUserid() found: " + userid);
		return account;
		}
  
  @RequestMapping("/{accountnum}/getbyAccountnum")
  public Account byAccountnum(@PathVariable("accountnum") int accountnum) {
	logger.info("bankaccountservice byAccountnum() invoked: " + accountnum);
	Account account =(Account)accountRepository.findAccountByAccountnum(accountnum);
	logger.info("bankaccountservice byAccountnum() found: " + accountnum);
		return account;
		}
  
  
  @PostMapping("/addAccount")
	   public String addAccount(@RequestBody Account account) {
          accountRepository.save(account);
		   return "record Inserted";
	   }
  @DeleteMapping("/{accountnum}/delete")
     public String deleteAccount(@PathVariable("accountnum") int accountnum) {
	  accountRepository.deleteById(accountnum);
	  return "record deleted";
  }
       
	   

}
