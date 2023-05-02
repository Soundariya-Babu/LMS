package com.project.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Student_Data")
public class StudentData {
	@Column(name = "username")
	private String username;
    @Column(name = "email")
	private String email;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "password")
	private String password;
	@Lob
	@Column(name="image_data", columnDefinition="BLOB")
	private byte[] imageData;
	
//	
//	@ManyToMany(mappedBy="students",fetch = FetchType.LAZY)
//    @JoinTable(name = "Courses_Student",
//      joinColumns = @JoinColumn(name = "studentId"), 
//      inverseJoinColumns = @JoinColumn(name = "courseId"))
//    private List<Courses> courses = new ArrayList<>();
//	
//	
//public List<Courses> getCourses() {
//		return courses;
//	}
//	public void setCourses(List<Courses> courses) {
//		this.courses = courses;
//	}
	
	
//		@OneToMany(mappedBy = "student",fetch= FetchType.LAZY)
//    private List<CoursesStudent> coursesStudent = new ArrayList<>();
//	
//	public List<CoursesStudent> getCoursesStudent() {
//		return coursesStudent;
//	}
//	public void setCoursesStudent(List<CoursesStudent> coursesStudent) {
//		this.coursesStudent = coursesStudent;
//	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
}
