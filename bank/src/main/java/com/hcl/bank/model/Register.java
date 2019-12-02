package com.hcl.bank.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "register")
@SequenceGenerator(name ="seq",initialValue = 6000000)
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Integer accountNumber;
	private String userName;
	private String passWord;
	private String gender;
	private Integer age;
	private String email;
	private Long phoneNo;
	private LocalDate dateOfBirth;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

}
