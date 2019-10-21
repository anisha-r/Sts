package com.anisha.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")

public class Account {
	
	private int accountnum;
	private double amount;
	private char accountype;
	private int userid;
	
	@Id
	@Column(name="accountnum")
	public int getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(int accountnum) {
		this.accountnum = accountnum;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public char getAccountype() {
		return accountype;
	}
	public void setAccountype(char accountype) {
		this.accountype = accountype;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Account(int accountnum, double amount, char accountype, int userid) {
		super();
		this.accountnum = accountnum;
		this.amount = amount;
		this.accountype = accountype;
		this.userid = userid;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
