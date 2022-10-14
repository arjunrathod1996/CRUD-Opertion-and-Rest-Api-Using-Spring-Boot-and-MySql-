package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.StudentDetailss;
import com.student.exception.StudentNotFounderException;
import com.student.service.StudentService;

	@RestController
	@RequestMapping("/students")
	public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
/*	@PostMapping("/addStudentDetailss")
	public StudentDetailss savestudent(@RequestBody StudentDetailss student) {
		
		return service.savestudent(student);
		
	} */
	
	@GetMapping("/")
	public String login() {
		
		return "Successfull";
		
	}
	
	@PostMapping("/addStudentDetailss")
	public ResponseEntity<StudentDetailss> savestudent(@RequestBody StudentDetailss student) {
		
		return new ResponseEntity<>(service.savestudent(student),HttpStatus.CREATED);
		
	}
	
	@PostMapping("/studentDetailsss")
	public ResponseEntity<List<StudentDetailss>> savestudents(@RequestBody List<StudentDetailss> students){
		
		return new ResponseEntity<> (service.savestudents(students),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/studentDetailssById/{id}")
	public StudentDetailss getStudentById(@PathVariable int id) throws StudentNotFounderException {
		
		return service.getStudentById(id);
		
	}
	@GetMapping("/studentDetailssByName/{name}")
	public StudentDetailss getStudentByName(@PathVariable String name) {
		
		return service.getStudentByName(name);
		
	}
	
	@GetMapping("/studentDetails")
	public ResponseEntity<List<StudentDetailss>> getAllStudents(){
		
		return ResponseEntity.ok(service.getAllStudents());
		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		
		service.deleteStudent(id);
		
		return "Stundet Id Deleted " + id;
		
	}
	
	@PutMapping("/update")
	public StudentDetailss updateStudent(@RequestBody StudentDetailss detailss) {

		
		return service.updateStudent(detailss);
		
	}
	
	
}

	

