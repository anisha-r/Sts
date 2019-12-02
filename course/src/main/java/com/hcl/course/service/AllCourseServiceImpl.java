package com.hcl.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.course.dao.AllCourseRepository;
import com.hcl.course.exception.CourseIdNotFoundException;
import com.hcl.course.exception.CourseNotFoundException;
import com.hcl.course.model.AllCourse;

@Service
public class AllCourseServiceImpl implements AllCourseService {

	@Autowired
	AllCourseRepository allCourseRepository;

	@Autowired
	AllCourseService allCourseService;

	@Override
	public String getAllCourse(AllCourse allCourse) {
		allCourseRepository.save(allCourse);
		return "Saved SuccessFully";
	}

	@Override
	public AllCourse searchCourse(Integer courseId) throws CourseIdNotFoundException {
		AllCourse allCourse = allCourseRepository.findCourseByCourseId(courseId);
		if (allCourse == null) {
			throw new CourseIdNotFoundException("CourseId Not found");
		} else {
			return allCourse;
		}
	}

	@Override
	public List<AllCourse> displayAll() throws CourseNotFoundException {
		List<AllCourse> list = allCourseRepository.findAll();
		if (list.isEmpty()) {
			throw new CourseNotFoundException("Courses Not Added");
		}
		return list;
	}

	@Override
	public List<AllCourse> getDetails(String courseName) throws CourseNotFoundException {
		Iterable<AllCourse> allCourse = allCourseRepository.findAll();
		List<AllCourse> courses = new ArrayList<>();
		for (AllCourse courseFetch : allCourse) {
			courses.add(courseFetch);
		}
		courses = courses.stream()
				.filter(courseDetail -> courseDetail.getCourseName().toLowerCase().startsWith(courseName.toLowerCase()))
				.collect(Collectors.toList());
		if (courses.isEmpty()) {
			throw new CourseNotFoundException("No course Found");
		}

		return courses;
	}

}
