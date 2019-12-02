package com.hcl.bank.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="account")
public class Account {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	private Integer accountNumber;
	private Integer amount;
	private String accountType;
	private LocalDate createdDate;
}