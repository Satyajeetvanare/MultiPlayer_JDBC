package com.jspiders.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springrest.pojo.StudentPOJO;
import com.jspiders.springrest.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository;

	public StudentPOJO add(StudentPOJO student) {
		StudentPOJO stud = repository.add(student);
		return stud;
	}

	public StudentPOJO search(int id) {
		StudentPOJO pojo = repository.search(id);
		return pojo;
	}

	public List<StudentPOJO> displayAll() {
		List<StudentPOJO> students = repository.displayAll();
		return students;
	}

	public StudentPOJO delete(int id) {
		StudentPOJO pojo = repository.delete(id);
		return pojo;
	}

	public StudentPOJO update(StudentPOJO student) {
		StudentPOJO pojo = repository.update(student);
		return pojo;
	}

}
