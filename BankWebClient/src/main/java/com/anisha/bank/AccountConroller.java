package com.anisha.bank;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("/Account")
public class AccountConroller {
	
	@Autowired
	private  RemoteAccountRepository remoteAccountRepository;
	
	@RequestMapping(value = "/{userid}/get", method = RequestMethod.GET)
	public ModelAndView byUserid(ModelAndView model) {
		Account account = new Account();
		model.addObject("Account", account);
		model.setViewName("Form");
		return model;
	}
	
	@RequestMapping(value = "/{accountnum}/get", method = RequestMethod.GET)
	public ModelAndView byAccountnum(ModelAndView model) {
		Account account = new Account();
		model.addObject("Account", account);
		model.setViewName("Form");
		return model;
	}
	
	@RequestMapping(value = "/addAccount", method = RequestMethod.GET)
	public ModelAndView addAccount(ModelAndView model) {
		Account account = new Account();
		model.addObject("Account", account);
		model.setViewName("Form");
		return model;
	}
	@RequestMapping(value = "/{accountnum}/delete", method = RequestMethod.GET)
	public ModelAndView deleteExam(HttpServletRequest request) {
		int accountnum = Integer.parseInt(request.getParameter("accountnum"));
		remoteAccountRepository.deleteAccount(accountnum);
		return new ModelAndView("redirect:/");
	}
		
	}
	


