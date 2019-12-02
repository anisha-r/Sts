package com.hcl.course.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hcl.course.model.EnrolledCourse;

@Repository
public interface EnrolledCourseRepository extends CrudRepository<EnrolledCourse, Integer> {
	
	List<EnrolledCourse> findByCourseNameAndUserId(String courseName, Integer userId);
	
	EnrolledCourse findCourseByUserId(Integer userId);

	
}
