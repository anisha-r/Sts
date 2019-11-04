package com.example.demo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {
	
	@Id
	
	
	int stockId;
	String name;
	int quantity;
	double price;
	int brokerage;
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Column
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Column
	public int getBrokerage() {
		return brokerage;
	}
	public void setBrokerage(int brokerage) {
		this.brokerage = brokerage;
	}
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ ", brokerage=" + brokerage + "]";
	}
	public void setQuantity(double d) {
		// TODO Auto-generated method stub
		
	}
	
	

}
