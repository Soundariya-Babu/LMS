package com.project.service;

import java.util.List;
import java.util.Optional;
import com.project.model.CoursesStudent;


public interface CoursesStudentService{

	public void saveCourseStudent(CoursesStudent student);
	 public boolean updateCourseStudent( CoursesStudent student);
	 public boolean deleteCourseStudent(Long id);
	 public List<CoursesStudent> getAllCourseStudent();
	 public Optional<CoursesStudent> getCourseStudentById(Long id);
}
