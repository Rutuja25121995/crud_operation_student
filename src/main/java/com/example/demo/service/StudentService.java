package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.dto.Student;

@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;

	public Student createStudent(Student student) {
		System.out.println("inside StudentService.StudentService-->" + student);
		Student std = studentDao.save(student);
		System.out.println("student saved in db ");

		return std;
	}

	public Iterable<Student> getAllStudent() {
		System.out.println("inside StudentService.getAllStudent-->");
		Iterable<Student> stdListFromDB = studentDao.findAll();
		System.out.println("Response from db is -> " + stdListFromDB);
		return stdListFromDB;
	}

	

	public String deleteStudent1(int id) {
		System.out.println("inside StudentService.deleteStudent-->" + id);

		Student recordsFromDB = studentDao.findOne(id);
		System.out.println("records present in id-->" + recordsFromDB);
		if (recordsFromDB != null) {
			Student entity = new Student();
			entity.setId(id);
			studentDao.delete(entity);
			 return "Student deleted for id="+id ;
		} else {
            return "Student not deleted as id="+id +"is not present in DB";
		}

		
	}
	
	public Student updateStudent(Student stdInput) {
		System.out.println("inside StudentService.updateStudent-->" + stdInput);

		Student stdFromDB = studentDao.findOne(stdInput.getId());
		System.out.println("records from db for id is==> " + stdFromDB);
		if (stdFromDB != null) {
			System.out.println("std is present is db");

			Student stdupdate = new Student();
			stdupdate.setId(stdFromDB.getId());

			if (stdInput.getFname() != null) {
				System.out.println("fname  given from User");
				stdupdate.setFname(stdInput.getFname());
			} else {
				System.out.println("fname take from db");
				stdupdate.setFname(stdFromDB.getFname());
			}

			if (stdInput.getLname() != null) {
				System.out.println("lname  given from User");
				stdupdate.setLname(stdInput.getLname());
			} else {
				System.out.println("lname take from db");
				stdupdate.setLname(stdFromDB.getLname());
			}

			if (stdInput.getEmail() != null) {
				System.out.println("email  given from User");
				stdupdate.setEmail(stdInput.getEmail());
			} else {
				System.out.println("email take from db");
				stdupdate.setEmail(stdFromDB.getEmail());
			}

			System.out.println("student object to be updated--> " + stdupdate);
			Student std = studentDao.save(stdupdate);
			return std;
		} else {
			System.out.println("std is not present is db");
			Student std = new Student();
			return std;
		}

	}

	

}
