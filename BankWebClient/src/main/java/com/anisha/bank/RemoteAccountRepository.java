package com.anisha.bank;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dinesh.Rajput
 *
 */
public class RemoteAccountRepository implements AccountRepository {
	
	@Autowired
	protected RestTemplate restTemplate;
	 
	protected String serviceUrl;
	
	public RemoteAccountRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	
	@Override
	public Account byUserid(int userid) {
		return restTemplate.getForObject(serviceUrl + "/account/{userid}",
				Account.class, userid);
	}

	@Override
	public Account byAccountnum(int accountnum) {
		return restTemplate.getForObject(serviceUrl + "/account/{accountnum}",
				Account.class, accountnum);
	}

	@Override
	public String addAccount(Account account) {
		 restTemplate.getForObject(serviceUrl + "/addAccount",
				Account.class, account);
		 return "Account Added";
	}

	@Override
	public String deleteAccount(int accountnum) {
		 restTemplate.getForObject(serviceUrl + "/{accountnum}/delete",
				Account.class, accountnum);	
          return "Account Deleted";
}
}
