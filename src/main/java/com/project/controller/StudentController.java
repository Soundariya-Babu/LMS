package com.project.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.model.StudentData;
import com.project.service.StudentService;

@RestController
@RequestMapping("/student")

public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<StudentData> store(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("email") String email,
			@RequestParam("imageFile") MultipartFile file) throws IOException{
		   
	     	StudentData studentData=new StudentData();
	     	studentData.setUsername(name);
	     	studentData.setPassword(password);
	     	studentData.setEmail(email);
	     	studentData.setImageData(file.getBytes());
		
			studentService.saveStudent(studentData);
			String message="success";
			
			return new ResponseEntity<StudentData>(studentData, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String>update(@RequestBody StudentData student)
	{
		boolean b=studentService.updateStudent(student);
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
		studentService.deleteStudent(id);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
		
	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity <List<StudentData>> getAllStudnet()
	{
		List<StudentData> student=studentService.getAllStudent();
		System.out.println(student);
		return new ResponseEntity<List<StudentData>>(student,HttpStatus.OK);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Optional<StudentData>> getById(@RequestParam Long id)
	{
		Optional<StudentData> student=studentService.getStudentById(id);
		return new ResponseEntity<Optional<StudentData>>(student,HttpStatus.OK);
		
	}
	
	
}
