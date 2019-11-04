package com.example.demo;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StockController {
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	UserRepository userRepository;

	
	
	@GetMapping("/getAll")
	public Iterable<Stock> getAll() {
		return stockRepository.findAll();
	}
	
	@GetMapping("/{stockId}")
	public Optional<Stock> getByUserId(@PathVariable int stockId) {
		return stockRepository.findById(stockId);
	}
	
	
	  @GetMapping("/getBuy") public Iterable<User> getById() { return
	  userRepository.findAll(); }
	  
	  @GetMapping("/BuyId/{buyId}") public Optional<User> getByBuyId(@PathVariable
	  int buyId) {
		  
	 return userRepository.findById(buyId);
	}
	
	@RequestMapping("/buyStock")
	public String createStock(Stock stock) {
		Optional<Stock> stock1 = stockRepository.findById(1);
		String username = "anuuu";
		double totalPrice=500;
		User user=new User();
		
	if(stock1.isPresent()) {
		user.setUserName(username);
		user.setStockName(stock1.get().getName());
		user.setQuantity(stock1.get().getQuantity());
		user.setPrice(stock1.get().getPrice());
		user.setBrokerage(stock1.get().getBrokerage());
		user.setTotalPrice(totalPrice);
		userRepository.save(user);
		return stock1.get().getName();
	}
	return "Buy";
	}
}