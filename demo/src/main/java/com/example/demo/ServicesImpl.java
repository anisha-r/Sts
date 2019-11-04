package com.example.demo;


import org.springframework.stereotype.Service;

@Service
public abstract class ServicesImpl implements Services{
//	
//	@Autowired
//	StockRepository stockRepository;
//	
//	int n;
//	
//	@Override
//	public boolean buyStock(Stock stock) {
//			Stock nStock = new Stock();
//		
//			nStock = stockRepository.findById(stock.getStockId()).get();
//			if(nStock.getQuantity() != 0) {
//				
//				nStock.setQuantity(nStock.getQuantity() - n);
//				stockRepository.save(nStock);
//				nStock.setQuantity(n);
//				nStock.getName();
//				nStock.getBrokerage();
//				nStock.setPrice(nStock.getPrice());
//				
//	
//				nStock.setPrice(nStock.getPrice()+(nStock.getPrice()*nStock.getBrokerage()/100));
//			stockRepository.save(nStock);
//				
//				return true;
//				
//			} else {
//				
//				return false;
//				
//			}
//	}}
	
}
