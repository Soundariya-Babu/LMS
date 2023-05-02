package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {

}
