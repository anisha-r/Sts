package com.hcl.bank.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "transaction")
@SequenceGenerator(name ="seq",initialValue = 1000)
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Integer transactionId;
	private Integer fromAccountNumber;
	private Integer toAccountNumber;
	private Integer transferredAmount;

}
