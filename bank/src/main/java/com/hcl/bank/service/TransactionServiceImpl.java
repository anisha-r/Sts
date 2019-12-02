package com.hcl.bank.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.bank.dao.AccountRepository;
import com.hcl.bank.dao.TransactionRepository;
import com.hcl.bank.model.Account;
import com.hcl.bank.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountService accountService;

	@Override
	public String credit(Transaction transaction) {
		
		Account account = accountRepository.findByAccountNumber(transaction.getFromAccountNumber());
		Account account1 = accountRepository.findByAccountNumber(transaction.getToAccountNumber());
		Integer fromAccountAmount = account.getAmount();
		Integer toAccountAmount = account1.getAmount();
		Integer transferredAmount = transaction.getTransferredAmount();
		if(fromAccountAmount == toAccountAmount) {
			return "Not Possible";
		}else {
			
		if(fromAccountAmount > transferredAmount) {
			fromAccountAmount=fromAccountAmount - transferredAmount;
			toAccountAmount=toAccountAmount+transferredAmount;
			account.setAmount(fromAccountAmount);
			account1.setAmount(toAccountAmount);
			accountRepository.save(account);
			accountRepository.save(account1);
			transactionRepository.save(transaction);
			return "Amount credited";
		} else {
			return "Insuffiient Amount";
		}
		
		}
	}

	@Override
	public List<Transaction> findTransactionByfromAccountNumber(Integer list) {
		return transactionRepository.findTransactionByfromAccountNumber(list);
	}

	
}
