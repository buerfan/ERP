package com.example.icecreamfactory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.icecreamfactory.entity.User;
import com.example.icecreamfactory.service.UserService;
import com.example.icecreamfactory.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService=userService;
	}

	
	@GetMapping("/")
	public String getAllUsers(Model model){
		List<User> listOfUsers=userService.getAllUsers();
		model.addAttribute("listOfUsers", listOfUsers);
		return "users";
	}
	
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return this.userService.getUser(username);
	}
	
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
}
