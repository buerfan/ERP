package com.example.icecreamfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.icecreamfactory.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	

}
