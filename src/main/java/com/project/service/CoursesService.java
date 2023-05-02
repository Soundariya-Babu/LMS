package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.model.Courses;


public interface CoursesService {
	
	public void saveCourse(Courses student);
	 public boolean updateCourse( Courses student);
	 public boolean deleteCourse(Long id);
	 public List<Courses> getAllCourse();
	 public Optional<Courses> getCourseById(Long id);

}
