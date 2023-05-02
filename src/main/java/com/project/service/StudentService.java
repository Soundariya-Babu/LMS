package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.StudentData;

public interface StudentService {

	 public void saveStudent(StudentData student);
	 public boolean updateStudent( StudentData student);
	 public boolean deleteStudent(Long id);
	 public List<StudentData> getAllStudent();
	 public Optional<StudentData> getStudentById(Long id);
	 
}
