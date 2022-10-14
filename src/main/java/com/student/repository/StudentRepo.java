package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.StudentDetailss;

public interface StudentRepo extends JpaRepository<StudentDetailss, Integer> {

	StudentDetailss findStudentByName(String name);

}
