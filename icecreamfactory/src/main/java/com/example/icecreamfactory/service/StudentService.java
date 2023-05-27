package com.example.icecreamfactory.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.icecreamfactory.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();

	public Student saveStudent(Student student);

	public Student getStudentById(Long id);

	public Student updateStudent(Student student);

	public void deleteStudentById(Long id);
	
	Page<Student> findPaginated(int pageNo, int pageSize);

}
