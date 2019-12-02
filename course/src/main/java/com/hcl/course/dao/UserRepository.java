package com.hcl.course.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.course.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByUserName(Integer userName);

	User findByUserName(String name);

	User findUserByUserId(Integer userId);

}
