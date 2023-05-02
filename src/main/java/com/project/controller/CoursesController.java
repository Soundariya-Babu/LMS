package com.project.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Courses;
import com.project.service.CoursesService;

@RestController
@RequestMapping("/courses")
public class CoursesController {

	@Autowired
	private CoursesService courseService;
	
	@PostMapping("/save")
	public ResponseEntity<String> store(@RequestBody Courses courses){
		//Courses newCourse =new Courses();
		courses.setCreatedOn(LocalDate.now());
		System.out.println(LocalDate.now());
		
		courseService.saveCourse(courses);
			String message="success";
			
			return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String>update(@RequestBody Courses courses)
	{
		boolean b=courseService.updateCourse(courses);
		String message="";
		if(b==true)
		{
			message="success";
		}
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam Long id)
	{
		courseService.deleteCourse(id);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
		
	@GetMapping("/getAll")
	public ResponseEntity <List<Courses>> getAllCourses()
	{
		List<Courses> courses=courseService.getAllCourse();
		return new ResponseEntity<List<Courses>>(courses,HttpStatus.OK);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Optional<Courses>> getById(@RequestParam Long id)
	{
		Optional<Courses> courses=courseService.getCourseById(id);
		return new ResponseEntity<Optional<Courses>>(courses,HttpStatus.OK);
		
	}
}
