package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.CoursesStudent;

@Repository
public interface CoursesStudentRepository extends JpaRepository<CoursesStudent, Long> {

}
