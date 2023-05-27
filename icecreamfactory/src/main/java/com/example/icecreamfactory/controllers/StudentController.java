package com.example.icecreamfactory.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.icecreamfactory.entity.Student;
import com.example.icecreamfactory.service.StudentService;


@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handler method to handle list students and return mode and view
	
	@GetMapping("/employees")
	public String employeeManagement() {
		return "employees";
	}
	@GetMapping("/students")
	public String listStudents(Model model) {
		
		//call pageable for pagination 
		return findPaginated(1, model);
		
		/*model.addAttribute("students", studentService.getAllStudents());
		return "students";*/
	}
	
	@PostMapping("/students")
	public String saveStudents(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student=new Student();
		
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
	    int pageSize = 5;

	    Page<Student> page = studentService.findPaginated(pageNo, pageSize);
	    List< Student > listOfStudents = page.getContent();

	    model.addAttribute("currentPage", pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    model.addAttribute("listOfStudents", listOfStudents);
	    return "students";
	}
	
	
}
