package com.project.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="Courses_Student")
public class CoursesStudent {
	
	@Column(name = "enrolled_On")
	private LocalDate enrolledOn;
	
    @Column(name = "status")
	private String status;
    
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name="student_Id")
	private Long studentId;
	
	@Column(name="course_Id")
	private Long courseId;
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
//	
//	@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "studentId")
//    private StudentData student;
//
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "courseId")
//    private Courses courses;
    
    
    
    
//	@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "studentId")
//    private StudentData student;
// 
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "courseId")
//    private Courses courses;
 
	
//	 public StudentData getStudents() {
//		return student;
//	}
//
//	public void setStudents(StudentData students) {
//		this.student = students;
//	}
//
//	public Courses getCourses() {
//		return courses;
//	}
//
//	public void setCourses(Courses courses) {
//		this.courses = courses;
//	}
	
	

	public LocalDate getEnrolledOn() {
		return enrolledOn;
	}

	public void setEnrolledOn(LocalDate enrolledOn) {
		this.enrolledOn = enrolledOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public StudentData getStudent() {
//		return student;
//	}
//
//	public void setStudent(StudentData student) {
//		this.student = student;
//	}
//
//	public Courses getCourse() {
//		return courses;
//	}
//
//	public void setCourse(Courses course) {
//		this.courses = course;
//	}

	
}
