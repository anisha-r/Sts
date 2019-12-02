package com.hcl.bank.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bank.model.Register;

@Repository
public interface RegisterRepository extends CrudRepository<Register, Integer> {
	
	List<Register> findAll();
	
	List<Register> findByAccountNumber(Integer accountNumber);

	Register findRegisterByuserName(String name);


}
