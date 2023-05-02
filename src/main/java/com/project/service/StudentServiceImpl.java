package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.StudentData;
import com.project.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentDAO;

	public void saveStudent(StudentData student) {
		studentDAO.save(student);
		// TODO Auto-generated method stub
	}

	public boolean updateStudent(StudentData student) {
      		return false;
	}

	public boolean deleteStudent(Long id) {
		// TODO Auto-generated method stub
		studentDAO.deleteById(id);
		return false;
	}

	public List<StudentData> getAllStudent() {
		// TODO Auto-generated method stub
		List<StudentData> studentt=studentDAO.findAll();
		return studentt;
	}

	public Optional<StudentData> getStudentById(Long id)
	{
		Optional<StudentData> student=studentDAO.findById(id);
		return student;
	}
	
}
