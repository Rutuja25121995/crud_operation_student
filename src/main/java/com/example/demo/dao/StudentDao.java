package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {

}
