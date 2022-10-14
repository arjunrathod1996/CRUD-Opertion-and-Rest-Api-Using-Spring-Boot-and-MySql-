package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exception.StudentNotFounderException;
import com.student.entity.StudentDetailss;
import com.student.exception.StudentNotFounderException;
import com.student.repository.StudentRepo;
@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	public StudentDetailss savestudent(StudentDetailss student) {
		
		return repo.save(student);
		
	}
	
	public List<StudentDetailss> savestudents(List<StudentDetailss> students){
		
		return repo.saveAll(students);
		
	}
	
/*	public StudentDetailss getStudentById(int id) {
		
		return repo.findById(id).orElse(null);
		
	}*/
	
	public StudentDetailss getStudentById(int id) throws StudentNotFounderException {
		
		StudentDetailss detailss = repo.findById(id).orElse(null);
		
		if(detailss != null) {
			return detailss;
		}else {
			throw new StudentNotFounderException("Student not found id " + id);
		}
		
	}
	
	public StudentDetailss getStudentByName(String name) {
		
		return repo.findStudentByName(name);
		
	}
	
	public List<StudentDetailss> getAllStudents(){
		
		return repo.findAll();
		
	}
	
	public String deleteStudent(int id) {
		
		repo.deleteById(id);
		
		return "Stundet Id Deleted " + id;
		
	}
	
	public StudentDetailss updateStudent(StudentDetailss detailss) {
		
		StudentDetailss existingStudentDetailss = repo.findById(detailss.getId()).orElse(null);
		
		existingStudentDetailss.setName(detailss.getName());
		existingStudentDetailss.setEmail(detailss.getEmail());
		existingStudentDetailss.setPhone(detailss.getPhone());
		existingStudentDetailss.setAddress(detailss.getAddress());
		
		return repo.save(existingStudentDetailss);
		
	}
	
	
}
