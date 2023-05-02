package com.project.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Courses;
import com.project.model.CoursesStudent;
import com.project.service.CoursesStudentService;

@RestController
@RequestMapping("/assign")
public class CoursesStudentController {

	
	@Autowired
	private CoursesStudentService coursesStudent;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody CoursesStudent cs)
	{
		cs.setEnrolledOn(LocalDate.now());
		coursesStudent.saveCourseStudent(cs);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam Long id)
	{
		coursesStudent.deleteCourseStudent(id);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity <List<CoursesStudent>> getAllCourses()
	{
		List<CoursesStudent> courses=coursesStudent.getAllCourseStudent();
		return new ResponseEntity<List<CoursesStudent>>(courses,HttpStatus.OK);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Optional<CoursesStudent>> getById(@RequestParam Long id)
	{
		Optional<CoursesStudent> courses=coursesStudent.getCourseStudentById(id);
		return new ResponseEntity<Optional<CoursesStudent>>(courses,HttpStatus.OK);
		
	}
}
