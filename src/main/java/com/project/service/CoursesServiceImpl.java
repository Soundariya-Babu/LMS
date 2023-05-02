package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Courses;
import com.project.repository.CoursesRepository;

@Service
public class CoursesServiceImpl implements CoursesService{

	@Autowired
	private CoursesRepository coursesDAO;
	
	
	public void saveCourse(Courses course) {
		// TODO Auto-generated method stub
		coursesDAO.save(course);
	}

	public boolean updateCourse(Courses course) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteCourse(Long id) {
		// TODO Auto-generated method stub
		coursesDAO.deleteById(id);
		return false;
	}

	public List<Courses> getAllCourse() {
		// TODO Auto-generated method stub
		List<Courses> coursesList=coursesDAO.findAll();
		return coursesList;
	}
	
	
	public Optional<Courses> getCourseById(Long id)
	{
		Optional<Courses> course=coursesDAO.findById(id);
		return course;
	}
}
