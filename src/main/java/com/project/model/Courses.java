package com.project.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Courses")
public class Courses {
	@Column(name = "name")
	private String name;
    @Column(name = "content")
	private String content;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "duration")
	private String duration;
	@Column(name = "created_on")
	private LocalDate createdOn;
	
	
//	 @ManyToMany(mappedBy = "students", fetch=FetchType.LAZY)
//	 @JoinTable(name = "Courses_Student",
//     joinColumns = @JoinColumn(name = "courseId"), 
//     inverseJoinColumns = @JoinColumn(name = "studentId"))
//	    private List<StudentData> students = new ArrayList<>();
//
//	 
//public List<StudentData> getStudents() {
//		return students;
//	}
//	public void setStudents(List<StudentData> students) {
//		this.students = students;
//	}
//		@OneToMany(mappedBy = "courses", fetch= FetchType.LAZY)
//    private List<CoursesStudent> coursesStudent = new ArrayList<>();
//	
//	
//	public List<CoursesStudent> getCoursesStudent() {
//		return coursesStudent;
//	}
//	public void setCoursesStudent(List<CoursesStudent> coursesStudent) {
//		this.coursesStudent = coursesStudent;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	
}
