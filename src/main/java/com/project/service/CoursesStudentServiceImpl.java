package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.CoursesStudent;
import com.project.repository.CoursesStudentRepository;

@Service
public class CoursesStudentServiceImpl implements CoursesStudentService {

	@Autowired
	private CoursesStudentRepository coursesDAO;
	
	
	public void saveCourseStudent(CoursesStudent courseStudent) {
		// TODO Auto-generated method stub
		coursesDAO.save(courseStudent);
	}

	public boolean updateCourseStudent(CoursesStudent courseStudent) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteCourseStudent(Long id) {
		// TODO Auto-generated method stub
		coursesDAO.deleteById(id);
		return false;
	}

	public List<CoursesStudent> getAllCourseStudent() {
		// TODO Auto-generated method stub
		List<CoursesStudent> coursesList=coursesDAO.findAll();
		return coursesList;
	}
	
	
	public Optional<CoursesStudent> getCourseStudentById(Long id)
	{
		Optional<CoursesStudent> course=coursesDAO.findById(id);
		return course;
	}
}
