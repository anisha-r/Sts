package com.hcl.course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="enrolledcourse")
@SequenceGenerator(name ="seq",initialValue = 273097)
public class EnrolledCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Integer enrolledId;
	private Integer userId;
	private String courseName;
	private String authorName;
	private Integer duration; 

}
