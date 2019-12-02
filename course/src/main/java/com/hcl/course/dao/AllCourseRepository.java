package com.hcl.course.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.course.model.AllCourse;


@Repository
public interface AllCourseRepository extends CrudRepository<AllCourse, Integer>{

	AllCourse findCourseByCourseId(Integer courseId);
	
	AllCourse findCourseByCourseName(String courseName);
	
	List<AllCourse> findAll();
	
	
	
boolean existsBycourseName(String courseName);
	
	
   


}
