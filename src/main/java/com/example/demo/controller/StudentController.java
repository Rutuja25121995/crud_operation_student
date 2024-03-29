package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student)
	{
		System.out.println("inside StudentController.createStudent-->" +student);
		Student stud=studentService.createStudent(student);
		return stud;
	}
	
	@GetMapping("/getAllStudent")
	public Iterable<Student> getAllStudent()
	{
		System.out.println("inside StudentController.getAllStudent-->");
		Iterable<Student> stdList=studentService.getAllStudent();
		return stdList;
	}
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int sid1)
	{
		System.out.println("inside StudentController.deleteStudent-->" +sid1);
		//studentService.deleteStudent(sid1);
		String responseValue=studentService.deleteStudent1(sid1);
		
		return responseValue;
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student)
	{
		System.out.println("inside StudentController.updateStudent-->" +student);
		
		
		Student student1=studentService.updateStudent(student);
		
		return student1;
	
}
}